package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StrategyRotacionPicaPica implements RotacionStrategy {

	
    private ListIterator<List<Jugador>> iteradorPareja;
    private List<List<Jugador>> parejas;
    private List<Jugador> primerPareja;
    private List<Jugador> segundaPareja;
    private List<Jugador> terceraPareja;
    private List<Jugador> parejaActual;
    private RotacionStrategy rotacionEnRonda;
    private List<Jugador> todosLosJugadores;
	
	public StrategyRotacionPicaPica(List<Jugador>jugadores){
		
		todosLosJugadores = jugadores;
		this.primerPareja = new LinkedList<Jugador>();
		this.segundaPareja = new LinkedList<Jugador>();
		this.terceraPareja = new LinkedList<Jugador>();
		this.parejas = new LinkedList<List<Jugador>>();
		
		//jugador 1 vs jugador 4
		this.primerPareja.add(jugadores.get(0));
		this.primerPareja.add(jugadores.get(3));
		
		//jugador 2 vs jugador 5
		this.segundaPareja.add(jugadores.get(1));
		this.segundaPareja.add(jugadores.get(4));
		
		//jugador 3 vs jugador 6
		this.terceraPareja.add(jugadores.get(2));
		this.terceraPareja.add(jugadores.get(5));	
		
		this.parejas.add(primerPareja);
		this.parejas.add(segundaPareja);
		this.parejas.add(terceraPareja);
		this.parejaActual = primerPareja;
		this.iteradorPareja = this.parejas.listIterator(1);
	
		this.rotacionEnRonda = new StrategyRotacionEnRonda(parejaActual);
	}
	
	@Override
	public Jugador getJugadorConTurno() {
      		
		return this.rotacionEnRonda.getJugadorConTurno();
	}


	public Jugador getSiguienteJugadorMano() {

        if(this.iteradorPareja.hasNext()){
        	
        	this.parejaActual = iteradorPareja.next();
        	this.rotacionEnRonda = new StrategyRotacionEnRonda(parejaActual);
        	return (this.rotacionEnRonda.getJugadorConTurno());//devuelvo el nuevo jugador mano que en definitiva es el que tiene el siguiente turno 
        }
        this.rotacionEnRonda = new StrategyRotacionEnRonda(todosLosJugadores);
        return this.rotacionEnRonda.getSiguienteJugadorMano();
	}

}
