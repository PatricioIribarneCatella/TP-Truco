package algoritmosyprogramacion3.tp2.modelo;

public class Aceptar implements Respuesta {

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
		return true;
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
