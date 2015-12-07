package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StrategyRotacionPicaPica implements RotacionStrategy {

	
    private ListIterator<List<Jugable>> iteradorPareja;
    private List<List<Jugable>> parejas;
    private List<Jugable> primerPareja;
    private List<Jugable> segundaPareja;
    private List<Jugable> terceraPareja;
    private List<Jugable> parejaActual;
    private RotacionStrategy rotacionEnRonda;
    private List<Jugable> todosLosJugadores;
    private boolean todasLasParejasJugaron;
	
	public StrategyRotacionPicaPica(List<Jugable>jugadores){
		
		this.todasLasParejasJugaron = false;
		todosLosJugadores = jugadores;
		this.primerPareja = new LinkedList<Jugable>();
		this.segundaPareja = new LinkedList<Jugable>();
		this.terceraPareja = new LinkedList<Jugable>();
		this.parejas = new LinkedList<List<Jugable>>();
		
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
	public Jugable getJugadorConTurno() {
      		
		return this.rotacionEnRonda.getJugadorConTurno();
	}


	public Jugable getSiguienteJugadorMano() {

        if(this.iteradorPareja.hasNext()){
        	
        	this.parejaActual = iteradorPareja.next();
        	this.rotacionEnRonda = new StrategyRotacionEnRonda(parejaActual);
        	return (parejaActual.get(0));//devuelvo el nuevo jugador mano que en definitiva siempre queda al principio de esta lista
        }
        this.rotacionEnRonda = new StrategyRotacionEnRonda(todosLosJugadores);
        this.todasLasParejasJugaron = true;
        return this.rotacionEnRonda.getSiguienteJugadorMano();
	}

	
	public Jugable getJugadorConDecision() {
		
		return this.rotacionEnRonda.getJugadorConDecision();
	}

	
    public Jugable getJugadorConDecisionTruco() {
		
    	return this.rotacionEnRonda.getJugadorConDecisionTruco();
	}
    
	public List<Jugable> getJugadoresEnfrentados() {
		return this.parejaActual;
	}
	
	@Override
	public RotacionStrategy getProximaRotacion() {
		return new StrategyRotacionEnRonda(this.todosLosJugadores);
	}

	@Override
	public boolean rotacionCompleta() {

		return todasLasParejasJugaron;	 
	}
}
