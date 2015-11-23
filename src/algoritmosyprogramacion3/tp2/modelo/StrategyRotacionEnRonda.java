package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;
import java.util.ListIterator;

public class StrategyRotacionEnRonda implements RotacionStrategy{

    private ListIterator<Jugador> iteradorTurno;
    private List<Jugador> jugadores;
    
	public StrategyRotacionEnRonda(List<Jugador>jugadores){
		this.jugadores = jugadores;
		iteradorTurno = this.jugadores.listIterator(0);
	}
	
	
    public Jugador getJugadorConTurno() {
		if(this.iteradorTurno.hasNext()){
	   		   
	       return (this.iteradorTurno.next());
	    }
    	else{
        	 this.iteradorTurno = this.jugadores.listIterator(); // vuelvo al comienzo
	    	 return (this.iteradorTurno.next());
	    }
	}



	public Jugador getSiguienteJugadorMano() {
		
		this.cambiarOrdenJugadores();
	    return (this.jugadores.get(0));
	}
	
	/*Coloca el primer jugador al final de la lista y corre los demas a la izquierda*/
	private void cambiarOrdenJugadores(){
		Jugador primerJugador = this.jugadores.remove(0);
		this.jugadores.add(primerJugador);
		this.iteradorTurno = this.jugadores.listIterator();
	}
	

}
