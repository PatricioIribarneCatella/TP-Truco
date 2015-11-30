package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

public class ManejadorTruco {
	
	private List<Jugable> jugadores;
	private Canto nivelDeApuesta; // puede ser truco, re truco o vale 4
	private Jugable ganador;
	private Mesa mesa;
	
	public ManejadorTruco(Mesa unaMesa){
		
		this.mesa = unaMesa;
		this.setJugadoresEnfrentados(this.mesa.getJugadores()); // pensando en el pica pica
	    this.jugadores = unaMesa.getJugadores();   
	}

	
	public void setJugadoresEnfrentados(List<Jugable> jugadoresEnfrentados){
		
		this.jugadores = jugadoresEnfrentados;
	}
	
	
	
	public void setNivelApuesta(Canto unCanto) {
			
		this.nivelDeApuesta = unCanto;
	}
	
	public int getPuntajePorGanar(){
		
		return this.nivelDeApuesta.getPuntosGanados(this.ganador);
	}
	
	public int getPuntajePorRechazar(){
		
		return this.nivelDeApuesta.getPuntosPorRechazo();
	}
	

	public void trucoNoQuerido() {
		
		this.nivelDeApuesta = null;
	}
	
	public boolean trucoCantado(){
		
		return this.nivelDeApuesta != null;
	}

}
