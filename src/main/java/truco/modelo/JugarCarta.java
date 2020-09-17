package truco.modelo;

public class JugarCarta implements Evento {

	@Override
	public boolean involucraCambioDeTurno() {
		return true;
	}

	@Override
	public boolean involucraUnaRespuesta() {
		return false;
	}

	@Override
	public boolean esPosibleSubirLaApuesta() {
		return false;
	}

	@Override
	public Respuesta getRespuesta() {
		return null; // nunca se llama a este metodo en esta clase
	}

	@Override
	public Canto getCanto() {
		return null; // nunca se llama a este metodo en esta clase
	}

	@Override
	public Canto subirApuesta() {
		return null; // nunca se llama a este metodo en esta clase
	}	
}
