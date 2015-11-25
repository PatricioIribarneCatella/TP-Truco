package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

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
		this.jugadorConDecision = this.jugadorConTurno;
	}
	
	
	public void setRotacionStrategy(RotacionStrategy criterioDeRotacion){
		
		this.criterioDeRotacion = criterioDeRotacion;
		this.jugadorConTurno = this.criterioDeRotacion.getJugadorConTurno();
		this.jugadorConDecision = this.criterioDeRotacion.getJugadorConDecision();
	}
	
	public void setPartida(Partida unaPartida){
		
		this.partidaEnCurso = unaPartida;
	}
	
	public void aceptar(){
		
		this.partidaEnCurso.aceptar();
	}
	
	public void rechazar(){
		
		this.partidaEnCurso.rechazar();
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



	public void envidoCantado() {

		this.partidaEnCurso.cantarEnvido();
	}
}
