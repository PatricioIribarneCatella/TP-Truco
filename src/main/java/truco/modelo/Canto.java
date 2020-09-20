package truco.modelo;

public abstract class Canto implements Evento {

	protected int puntosPorRechazo;
	protected int puntosGanados;
	
	public int getPuntosPorRechazo() {
		return this.puntosPorRechazo;
	}
	
	public abstract int getPuntosGanados(Equipo equipo);
	
	public abstract Canto subirApuesta();
	
	@Override
	public boolean involucraCambioDeTurno() {
		return false;
	}

	@Override
	public boolean involucraUnaRespuesta() {
		return false;
	}

	@Override
	public Canto getCanto() {
		return this;
	}
	
	@Override
	public Respuesta getRespuesta() {
		return null; // nunca se llama a este metodo desde esta clase
	}
}
