package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

public class Moderador {
	
	
	private Jugable contrincante;
    private Jugador jugadorDeTurno;   
    private Jugador jugadorMano;
    private Mesa mesaACargo;
    private List<Jugador> jugadores;
    private Mazo mazo;
    private RotacionStrategy criterioDeRotacion;
    
    
	
	public Moderador(Mesa unaMesa){

		this.mazo = new  Mazo();
		this.mesaACargo = unaMesa;
		this.jugadores = this.mesaACargo.getJugadores();
		this.jugadorDeTurno = this.jugadores.get(0);
		this.jugadorMano = this.jugadores.get(0); //Seteo por default que en toda partida el primer jugador es mano
	}
	
	
	
	public void Aceptar(){
		
	}
	
	public void rechazar(){
		
	    /*if(this.jugadaCantada.terminaLaRonda()){
	    	this.rondaFinalizada();
	    }
	    	    
    	//sumo los puntajes correspondientes
	    this.contrincante.sumarPuntos(this.jugadaCantada.getPuntosPorRechazo());*/
	}
	
	public void repartirCartas(){
		
	   for(int i = 0;i<3 ;i++){
		   
	  	  for(Jugador unJugador:this.jugadores){
		 		
		    	unJugador.recibirCarta(this.mazo.darCarta());	
			
		  }
	   }

	}

	public void setRotacionStrategy(RotacionStrategy criterioDeRotacion){
		
		this.criterioDeRotacion = criterioDeRotacion;
		this.jugadorDeTurno = this.criterioDeRotacion.getJugadorConTurno();
	}
	
     public void seJugoUnaCarta() {
	    	 
    	this.jugadorDeTurno = this.criterioDeRotacion.getJugadorConTurno(); 
     }
	    
	 public void rondaFinalizada(){
	   	
    	this.jugadorMano = this.criterioDeRotacion.getSiguienteJugadorMano();
    	this.jugadorDeTurno = this.jugadorMano;
    }
		 
	public Jugador getJugadorConTurno(){
	    	
		return this.jugadorDeTurno;
	}
		 
		 
	public Jugador getJugadorMano(){
		    	
		 return this.jugadorMano;
	 }



	public void canteEnvido() {

	}



	public void cambiarTurno() {
		
		this.jugadorDeTurno = this.criterioDeRotacion.getJugadorConTurno(); 
	}
}
