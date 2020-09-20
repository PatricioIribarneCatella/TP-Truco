package truco.modelo;

public class ReTrucoAceptado implements EstadoPartida {

	@Override
	public boolean esValidoParaJugarCarta() {
		return true;
	}

	@Override
	public boolean esValidoParaCantarTruco() {
		return false;
	}

	@Override
	public boolean esValidoParaCantarReTruco() {
		return false;
	}

	@Override
	public boolean esValidoParaCantarValeCuatro() {
		return true;
	}

	@Override
	public boolean esValidoParaCantarEnvido() {
		return false;
	}

	@Override
	public boolean esValidoParaCantarRealEnvido() {
		return false;
	}

	@Override
	public boolean esValidoParaCantarFaltaEnvido() {
		return false;
	}

	@Override
	public boolean esValidoParaCantarFlor() {
		return false;
	}

	@Override
	public boolean esValidoParaAceptar() {
		return false;
	}

	@Override
	public boolean esValidoParaRechazar() {
		return false;
	}
}
