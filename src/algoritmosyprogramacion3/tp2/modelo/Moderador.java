package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

import algoritmosyprogramacion3.tp2.excepciones.CantidadDeEnvidosMaximosSuperadaException;
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
    
    
	
	public Moderador(Mesa unaMesa){

		this.mazo = new  Mazo();
		this.mesaACargo = unaMesa;
		this.jugadores = this.mesaACargo.getJugadores();
		this.jugadorConTurno = this.jugadores.get(0);
		this.jugadorMano = this.jugadores.get(0); //Seteo por default que en toda partida el primer jugador es mano
		this.jugadorConDecision = this.jugadores.get(0);
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

	
     public void seJugoUnaCarta() {
	    	 
    	this.jugadorConTurno = this.criterioDeRotacion.getJugadorConTurno(); 
     }
	    
	 public void rondaFinalizada(){
	   	
    	this.jugadorMano = this.criterioDeRotacion.getSiguienteJugadorMano();
    	this.jugadorConTurno = this.jugadorMano;
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
	

	public void envidoCantado(Jugable jugadorQueCanto) {
       
		if(this.jugadorConDecision == jugadorQueCanto){
			
			try{
				
				this.partidaEnCurso.cantarEnvido();
			}
			catch(CantidadDeEnvidosMaximosSuperadaException e){
			
				throw new CantidadDeEnvidosMaximosSuperadaException();
			}
			
			this.jugadorConDecision = this.getJugadorConDecision(); // ahora el que decide si acepta o no es otro.
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
		
	}



	public void realEnvidoCantado(Jugable jugadorQueCanto) {
		
		if(this.jugadorConDecision == jugadorQueCanto){
			
			this.partidaEnCurso.cantarRealEnvido();		
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}


	public void faltaEnvidoCantado(Jugable jugadorQueCanto) {
	
		if(this.jugadorConDecision == jugadorQueCanto){
			
			this.partidaEnCurso.cantarFaltaEnvido();	
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
	}


	public void trucoCantado(Jugable jugadorQueCanto) {
        
		if(this.jugadorConDecision == jugadorQueCanto){
			
			this.partidaEnCurso.cantarTruco();		
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
	}


	public void reTrucoCantado(Jugable jugadorQueCanto) {
		
		if(this.jugadorConDecision == jugadorQueCanto){
			
			this.partidaEnCurso.cantarReTruco();	
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
		
	}


	public void valeCuatroCantado(Jugable jugadorQueCanto) {

		if(this.jugadorConDecision == jugadorQueCanto){
			
			this.partidaEnCurso.cantarValeCuatro();	
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
		
	}


	public void jugadorAcepta(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
			
			this.partidaEnCurso.aceptar();	
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }		
	}
	
	
	
	
	public void jugadorRechazaVarianteEnvido(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
			
			this.partidaEnCurso.rechazarVarianteDeEnvido();		
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}
	
	public void jugadorRechazaVarianteTruco(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
			
			this.partidaEnCurso.rechazarVarianteDeTruco();	
			this.jugadorConDecision = this.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}
}
