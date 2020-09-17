package truco.modelo;

import java.util.List;
import java.util.ListIterator;

public class StrategyRotacionEnRonda implements RotacionStrategy{

    private ListIterator<Jugable> iteradorTurno;
    private ListIterator<Jugable> iteradorDecision; //para el envido
    private ListIterator<Jugable> iteradorDecisionTruco;
    private List<Jugable> jugadores;
    
	public StrategyRotacionEnRonda(List<Jugable>jugadores){
		this.jugadores = jugadores;
		iteradorTurno = this.jugadores.listIterator();
		iteradorDecision = this.jugadores.listIterator();
		iteradorDecisionTruco = this.jugadores.listIterator();
	}
	
    public Jugable getJugadorConTurno() {
		if(this.iteradorTurno.hasNext()){
	   		   
	       return (this.iteradorTurno.next());
	    }
    	else{
        	 this.iteradorTurno = this.jugadores.listIterator(); // vuelvo al comienzo
	    	 return (this.iteradorTurno.next());
	    }
	}

	public Jugable getSiguienteJugadorMano() {
		
		this.cambiarOrdenJugadores();
	    return (this.jugadores.get(0));
	}
	
	/*Coloca el primer jugador al final de la lista y corre los demas a la izquierda*/
	private void cambiarOrdenJugadores(){
		Jugable primerJugador = this.jugadores.remove(0);
		this.jugadores.add(primerJugador);
		this.iteradorTurno = this.jugadores.listIterator();
		this.iteradorDecision = this.jugadores.listIterator();
		this.iteradorDecisionTruco = this.jugadores.listIterator();
	}

	public Jugable getJugadorConDecision() {
		
		if(this.iteradorDecision.hasNext()){
	   		   
		       return (this.iteradorDecision.next());
		    }
	    	else{
	        	 this.iteradorDecision = this.jugadores.listIterator(); 
		    	 return (this.iteradorDecision.next());
		    }
	}
	
    public Jugable getJugadorConDecisionTruco() {
		
		if(this.iteradorDecisionTruco.hasNext()){
	   		   
		       return (this.iteradorDecisionTruco.next());
		    }
	    	else{
	        	 this.iteradorDecisionTruco = this.jugadores.listIterator(); 
		    	 return (this.iteradorDecisionTruco.next());
		    }
	}
	

	public List<Jugable> getJugadoresEnfrentados() {
		
		return this.jugadores;
	}

	@Override
	public RotacionStrategy getProximaRotacion() {
		return new StrategyRotacionPicaPica(this.jugadores);
	}

	@Override
	public boolean rotacionCompleta() {
		return true;
	}
}
