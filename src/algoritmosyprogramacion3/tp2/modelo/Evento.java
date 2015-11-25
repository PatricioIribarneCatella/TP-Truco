package algoritmosyprogramacion3.tp2.modelo;

public abstract class Evento implements Respuesta{

	protected int puntosPorRechazo;
	protected int puntosGanados;
	
	public int getPuntosPorRechazo() {
		return this.puntosPorRechazo;
	}
	
	public abstract int getPuntosGanados(Jugable jugador);
	
	public abstract Evento subirApuesta();
	
	public abstract boolean esPosibleSubirLaApuesta();
	
	@Override
	public boolean involucraCambioDeTurno() {
		return false;
	}
}