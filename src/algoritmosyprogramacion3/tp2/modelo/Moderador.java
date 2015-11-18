package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;
import java.util.ListIterator;

import algoritmosyprogramacion3.tp2.excepciones.PartidaSinFlorException;



public class Moderador {
	
	private boolean partidaConFlor;
    private Jugador jugadorDeTurno;   
    private Jugador jugadorMano;
    private Mesa mesaACargo;
    private List<Jugador> jugadores;
    private ListIterator<Jugador> iteradorTurno;
    private ListIterator<Jugador> iteradorMano;
    
	
	public Moderador(Mesa unaMesa,boolean conFlor){
		
		this.partidaConFlor = conFlor;
		this.jugadores = unaMesa.getJugadores();
		this.mesaACargo = unaMesa;
		iteradorMano = this.jugadores.listIterator();
		iteradorTurno = this.jugadores.listIterator();
		this.jugadorDeTurno = this.iteradorTurno.next();
		this.jugadorMano = this.iteradorMano.next(); //Seteo por default que en toda partida el primer jugador es mano
	}
	
	public boolean seJuegaConFlor(){
		
		if(!this.partidaConFlor){
			throw new PartidaSinFlorException();
		}
		return true;
	}

	
	
	    public void cambiarTurno() {
	    	
	    	if(this.iteradorTurno.hasNext()){
	   		   
		       	this.jugadorDeTurno =  this.iteradorTurno.next();
		    }
	    	else{
	        	 this.iteradorTurno = this.jugadores.listIterator(); // vuelvo al comienzo
		    	 this.jugadorDeTurno = this.iteradorTurno.next();
		    }
		    
		 }
	    
	    public void finalizarRonda(){
	    	
	    	
	    }
		 
		 public Jugador getJugadorConTurno(){
	    	
			 return this.jugadorDeTurno;
		 }
		 
	    
		 public boolean cantarFlor(){
	    	
			 if(!this.partidaConFlor) {
				 
				 throw new PartidaSinFlorException();
			 }
			 return (this.jugadorDeTurno.cantarFlor());
		 }
	
	
	
}
