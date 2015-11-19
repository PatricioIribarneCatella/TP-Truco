package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StrategyRotacionPicaPica implements RotacionStrategy {

	private ListIterator<Jugador> iteradorTurno;
    private ListIterator<Jugador> iteradorMano;
    private List<Jugador> jugadores;
	
	public StrategyRotacionPicaPica(List<Jugador>jugadores){
		this.jugadores = jugadores;
		iteradorMano = this.jugadores.listIterator(1);
		iteradorTurno = this.jugadores.listIterator(1);//Arranco en 1 porque el jugador actual ya toma la primera posicion de la lista.
	}
	
	@Override
	public Jugador cambiarTurno() {
      		
		return null;
	}


	public Jugador rondaFinalizada() {

        return null;
	}

	
	

}
