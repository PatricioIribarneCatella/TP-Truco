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
    private int cantidadDeCartasDeLaJugada;
    
    
	
	public Moderador(Mesa unaMesa){

		this.mazo = new  Mazo();
		this.mesaACargo = unaMesa;
		this.jugadores = this.mesaACargo.getJugadores();
		this.jugadorConTurno = this.jugadores.get(0);
		this.jugadorMano = this.jugadores.get(0); //Seteo por default que en toda partida el primer jugador es mano
		this.jugadorConDecision = this.jugadores.get(0);
		this.manejadorEnvidos = new ManejadorEnvidos();
		this.manejadorTruco = new ManejadorTruco();
		this.cantidadDeCartasDeLaJugada = 0;
	}
	
	
	public void setRotacionStrategy(RotacionStrategy criterioDeRotacion){
		
		this.criterioDeRotacion = criterioDeRotacion;
		this.jugadorConTurno = this.criterioDeRotacion.getJugadorConTurno();
		this.jugadorConDecision = this.criterioDeRotacion.getJugadorConDecision();
		this.manejadorTruco.setJugadoresEnfrentados(this.criterioDeRotacion.getJugadoresEnfrentados());
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
		
		for (Jugable jugador : this.jugadores) {
			jugador.recibirCarta(listaCartas.get(indiceCarta));
			indiceCarta++;
		}
	}
	
     public void seJugoUnaCarta() {
	    	 
    	this.cantidadDeCartasDeLaJugada++;
    	this.jugadorConTurno = this.criterioDeRotacion.getJugadorConTurno(); 
    	List<Jugable> jugadoresEnfrentados = this.criterioDeRotacion.getJugadoresEnfrentados();
    	
    	if(!this.manejadorTruco.trucoCantado()){ // porque las decisiones cambian de alguna forma de comportamiento una vez cantado el truco
    		this.jugadorConDecision = this.criterioDeRotacion.getJugadorConDecision();
    	}
    	
    	if(this.cantidadDeCartasDeLaJugada == jugadoresEnfrentados.size()){
    		
    		this.cantidadDeCartasDeLaJugada = 0;
    		Jugada nuevaJugada = new Jugada();
    		this.manejadorTruco.resolverJugada(nuevaJugada);
    		if(this.manejadorTruco.alguienGanoDosDeTres()){

    			int puntajeASumar = this.manejadorTruco.getPuntajePorGanar();
    			Equipo equipoGanador = this.manejadorTruco.getGanador();
    			this.partidaEnCurso.sumarPuntos(equipoGanador,puntajeASumar);
    			this.rondaFinalizada();
    		}
    	}
    	
     }
	    
	 public void rondaFinalizada(){
	   	
    	this.jugadorMano = this.criterioDeRotacion.getSiguienteJugadorMano();
    	this.jugadorConTurno = this.jugadorMano;
    	this.jugadorConDecision = this.jugadorConTurno;
    	this.manejadorTruco.nuevaRonda();
    	this.manejadorTruco.setJugadoresEnfrentados(this.criterioDeRotacion.getJugadoresEnfrentados()); //puede que quede en null hasta que en el pica pica cambie el strategy
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
			
			this.manejadorEnvidos.setJugadoresEnfrentados(this.criterioDeRotacion.getJugadoresEnfrentados());
			int puntajeASumar = this.manejadorEnvidos.calcularPuntajeAcumulado();
			Jugable jugadorGanador = this.manejadorEnvidos.getGanador();
			this.partidaEnCurso.sumarPuntos(jugadorGanador.getEquipo(),puntajeASumar);
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }		
	}
	
	
	
	/*Se juega el truco*/
	public void jugadorAceptaVarianteTruco(Jugable jugadorQueResponde) {

		if(!(this.jugadorConDecision == jugadorQueResponde)){
		
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }		
		// caso contrario simplemente se siguen jugando cartas o subiendo apuestas
	}
	

	
	public void jugadorRechazaVarianteEnvido(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
				
			this.jugadorConDecision = this.getJugadorConDecision();
			int puntajeASumar = this.manejadorEnvidos.calcularPuntajeAcumuladoPorRechazo();
			this.manejadorEnvidos.envidoNoQuerido();
			this.partidaEnCurso.sumarPuntos(jugadorConDecision.getEquipo(),puntajeASumar);
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}

	
	public void jugadorRechazaVarianteTruco(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
			
			this.manejadorTruco.trucoNoQuerido();
			this.rondaFinalizada();
			//falta sumar el puntaje al jugador correspondiente
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}
	
	public Mesa getMesa() {
		return this.mesaACargo;
	}		
}
