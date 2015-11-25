package algoritmosyprogramacion3.tp2.modelo;

public interface Evento {

	public abstract boolean involucraCambioDeTurno();
	
	public abstract boolean involucraUnaRespuesta();
	
	public abstract boolean esPosibleSubirLaApuesta();
	
	public abstract Respuesta getRespuesta();
	
	public abstract Canto getCanto();
	
	public abstract Canto subirApuesta();
}
