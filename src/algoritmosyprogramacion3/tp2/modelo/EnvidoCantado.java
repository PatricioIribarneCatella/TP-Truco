package algoritmosyprogramacion3.tp2.modelo;

public class EnvidoCantado implements EstadoPartida {

	@Override
	public boolean esValidoParaJugarCarta() {
		return false;
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
		return false;
	}

	@Override
	public boolean esValidoParaCantarEnvido() {
		return true;
	}

	@Override
	public boolean esValidoParaCantarRealEnvido() {
		return true;
	}

	@Override
	public boolean esValidoParaCantarFaltaEnvido() {
		return true;
	}

	@Override
	public boolean esValidoParaAceptar() {
		return true;
	}

	@Override
	public boolean esValidoParaRechazar() {
		return true;
	}
}
