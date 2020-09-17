package truco.modelo;

public class Rechazar implements Respuesta {

	@Override
	public boolean involucraCambioDeTurno() {
		return false;
	}

	@Override
	public boolean involucraUnaRespuesta() {
		return true;
	}

	@Override
	public Respuesta getRespuesta() {
		return this;
	}

	@Override
	public boolean fuePositiva() {
		return false;
	}

	@Override
	public boolean esPosibleSubirLaApuesta() {
		return false;
	}

	@Override
	public Canto subirApuesta() {
		return null; // nunca se llame a este método desde esta clase
	}

	@Override
	public Canto getCanto() {
		return null; // nunca se llame a este método desde esta clase
	}
}
