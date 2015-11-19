package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

public class Moderador {
	
    private Jugador jugadorDeTurno;   
    private Jugador jugadorMano;
    private Mesa mesaACargo;
    private List<Jugador> jugadores;
    private RotacionStrategy criterioDeRotacion;
    
	
	public Moderador(Mesa unaMesa){
		
		this.jugadores = unaMesa.getJugadores();
		this.mesaACargo = unaMesa;
		this.jugadorDeTurno = this.jugadores.get(0);
		this.jugadorMano = this.jugadores.get(0); //Seteo por default que en toda partida el primer jugador es mano
	}
	

	public void setRotacionStrategy(RotacionStrategy criterioDeRotacion){
		
		this.criterioDeRotacion = criterioDeRotacion;
	}
	
     public void seJugoUnaCarta() {
	    	 
    	this.jugadorDeTurno = this.criterioDeRotacion.cambiarTurno(); 
     }
	    
	 public void rondaFinalizada(){
	   	
    	this.jugadorMano = this.criterioDeRotacion.rondaFinalizada();
    }
		 
	public Jugador getJugadorConTurno(){
	    	
		return this.jugadorDeTurno;
	}
		 
		 
	public Jugador getJugadorMano(){
		    	
		 return this.jugadorMano;
	 }
		 
	
}
