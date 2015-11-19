package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;
import java.util.ListIterator;

public class StrategyRotacionEnRonda implements RotacionStrategy{

    private ListIterator<Jugador> iteradorTurno;
    private ListIterator<Jugador> iteradorMano;
    private List<Jugador> jugadores;
    
	public StrategyRotacionEnRonda(List<Jugador>jugadores){
		this.jugadores = jugadores;
		iteradorMano = this.jugadores.listIterator(1);
		iteradorTurno = this.jugadores.listIterator(1);//Arranco en 1 porque el jugador actual ya toma la primera posicion de la lista.
	}
	
	
    public Jugador cambiarTurno() {
		if(this.iteradorTurno.hasNext()){
	   		   
	       return (this.iteradorTurno.next());
	    }
    	else{
        	 this.iteradorTurno = this.jugadores.listIterator(); // vuelvo al comienzo
	    	 return (this.iteradorTurno.next());
	    }
	}



	
	public Jugador rondaFinalizada() {
		
		if(this.iteradorMano.hasNext()){
	   		   
	       	 return (this.iteradorMano.next());
	    }
   	    else{
       	 this.iteradorMano = this.jugadores.listIterator(); 
	    	 return (this.iteradorMano.next());
	    }
	}
	

}
