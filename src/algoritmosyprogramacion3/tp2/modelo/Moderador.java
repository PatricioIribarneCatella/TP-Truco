package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;

public class Moderador {
	
	
	private Jugable jugadorConDecision;
    private Jugable jugadorConTurno;   
    private Jugable jugadorMano;
    private Mesa mesaACargo;
    private List<Jugable> jugadores;
    private Mazo mazo;
    private Partida partidaEnCurso;
    private RotacionStrategy criterioDeRotacion;
    private ManejadorEnvidos manejadorEnvidos;
    private ManejadorTruco manejadorTruco;
    
    
	
	public Moderador(Mesa unaMesa){

		this.mazo = new  Mazo();
		this.mesaACargo = unaMesa;
		this.jugadores = this.mesaACargo.getJugadores();
		this.jugadorConTurno = this.jugadores.get(0);
		this.jugadorMano = this.jugadores.get(0); //Seteo por default que en toda partida el primer jugador es mano
		this.jugadorConDecision = this.jugadores.get(0);
		this.manejadorEnvidos = new ManejadorEnvidos(this.jugadores,this);
		this.manejadorTruco = new ManejadorTruco(this.mesaACargo);
	}
	
	
	public void setRotacionStrategy(RotacionStrategy criterioDeRotacion){
		
		this.criterioDeRotacion = criterioDeRotacion;
		this.jugadorConTurno = this.criterioDeRotacion.getJugadorConTurno();
		this.jugadorConDecision = this.criterioDeRotacion.getJugadorConDecision();
	}
	
	public void setPartida(Partida unaPartida){
		
		this.partidaEnCurso = unaPartida;
	}
		
	public void repartirCartas(){
		
	   for(int i = 0;i<3 ;i++){
		   
	  	  for(Jugable unJugador:this.jugadores){
		 		
		    	unJugador.recibirCarta(this.mazo.darCarta());	
		  }
	   }
	}

	public void repartirCartas(List<Carta> listaCartas) {
		
		int indiceCarta = 0;
		
		for (int i = 0; i < listaCartas.size()/2; i++) {
		
			for (Jugable jugador : this.jugadores) {
				jugador.recibirCarta(listaCartas.get(indiceCarta));
				indiceCarta++;
			}
		}
	}
	
     public void seJugoUnaCarta() {
	    	 
    	this.jugadorConTurno = this.criterioDeRotacion.getJugadorConTurno(); 
    	
    	if(!this.manejadorTruco.trucoCantado()){ // porque las decisiones cambian de alguna forma de comportamiento una vez cantado el truco
    		this.jugadorConDecision = this.criterioDeRotacion.getJugadorConDecision();
    	}
    	
     }
	    
	 public void rondaFinalizada(){
	   	
    	this.jugadorMano = this.criterioDeRotacion.getSiguienteJugadorMano();
    	this.jugadorConTurno = this.jugadorMano;
    	this.jugadorConDecision = this.jugadorConTurno;
    }
		 
	public Jugable getJugadorConTurno(){
	    	
		return this.jugadorConTurno;
	}
		 
		 
	public Jugable getJugadorMano(){
		    	
		 return this.jugadorMano;
	 }

	
	private Jugable getJugadorConDecision() {
		
		return this.criterioDeRotacion.getJugadorConDecision();
	}
	
	
	public void jugarPrimerCarta(Jugable unJugador){
		
		try{
			unJugador.jugarPrimerCarta();
		}
		catch(TurnoEquivocadoException e){
			
			throw new TurnoEquivocadoException();
		}
	}
	
	public void jugarSegundaCarta(Jugable unJugador){
		
		try{
			unJugador.jugarSegundaCarta();
		}
		catch(TurnoEquivocadoException e){
			
			throw new TurnoEquivocadoException();
		}
	}
	
	public void jugarTercerCarta(Jugable unJugador){
		
		try{
			unJugador.jugarSegundaCarta();
		}
		catch(TurnoEquivocadoException e){
			
			throw new TurnoEquivocadoException();
		}
	}
	
    /*METODOS DE ENVIDO Y TRUCO*/
	
	public void envidoCantado(Jugable jugadorQueCanto) {
       
		if(this.jugadorConDecision == jugadorQueCanto){
			
			Canto envido = new Envido();
			this.manejadorEnvidos.concatenarCanto(envido);
			this.jugadorConDecision = this.getJugadorConDecision(); // ahora el que decide si acepta o no es otro.
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
		
	}


	public void realEnvidoCantado(Jugable jugadorQueCanto) {
		
        if(this.jugadorConDecision == jugadorQueCanto){
			
			Canto realEnvido = new RealEnvido();
			this.manejadorEnvidos.concatenarCanto(realEnvido);
			this.jugadorConDecision = this.getJugadorConDecision(); 
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
	}


	public void faltaEnvidoCantado(Jugable jugadorQueCanto) {
	
        if(this.jugadorConDecision == jugadorQueCanto){
			
			Canto faltaEnvido = new FaltaEnvido();
			this.manejadorEnvidos.concatenarCanto(faltaEnvido);
			this.jugadorConDecision = this.getJugadorConDecision(); 
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
	}


	public void trucoCantado(Jugable jugadorQueCanto) {
        
		if(this.jugadorConDecision == jugadorQueCanto){
			
			Canto truco = new Truco();
			this.manejadorTruco.setNivelApuesta(truco);
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
	}


	public void reTrucoCantado(Jugable jugadorQueCanto) {
		
		if(this.jugadorConDecision == jugadorQueCanto){
			
			Canto reTruco = new ReTruco();
			this.manejadorTruco.setNivelApuesta(reTruco);
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
		
	}


	public void valeCuatroCantado(Jugable jugadorQueCanto) {

		if(this.jugadorConDecision == jugadorQueCanto){
			
			Canto valeCuatro = new ValeCuatro();
			this.manejadorTruco.setNivelApuesta(valeCuatro);
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
		
	}

	
	/*Se juega el envido*/
	public void jugadorAceptaVarianteEnvido(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
			
			int puntajeASumar = this.manejadorEnvidos.calcularPuntajeAcumulado();
			Jugable jugadorGanador = this.manejadorEnvidos.getGanador();
			jugadorGanador.sumarPuntos(puntajeASumar);
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }		
	}
	
	/*Se juega el truco*/
	public void jugadorAceptaVarianteTruco(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
			
		
			//comienzan a jugar cartas o bien se sube la apuesta 
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }		
	}
	


	
	public void jugadorRechazaVarianteEnvido(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
				
			this.jugadorConDecision = this.getJugadorConDecision();
			this.manejadorEnvidos.envidoNoQuerido();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}
	
	public void jugadorRechazaVarianteTruco(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
			
			this.manejadorTruco.trucoNoQuerido();
			this.rondaFinalizada();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}
	
	public Mesa getMesa() {
		return this.mesaACargo;
	}		
}
