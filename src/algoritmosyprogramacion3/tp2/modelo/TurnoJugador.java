package algoritmosyprogramacion3.tp2.modelo;

public class TurnoJugador implements EstadoPartida {

	@Override
	public boolean esValidoParaJugarCarta() {
		return true;
	}

	@Override
	public boolean esValidoParaCantarTruco() {
		return true;
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
		return false;
	}

	@Override
	public boolean esValidoParaCantarFaltaEnvido() {
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

	@Override
	public boolean esValidoParaCantarFlor() {
		return true;
	}
}
