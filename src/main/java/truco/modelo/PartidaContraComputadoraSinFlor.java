package truco.modelo;

public class PartidaContraComputadoraSinFlor extends PartidaContraComputadora {

	public PartidaContraComputadoraSinFlor(String nombrePartida, String nombreJugador) {
		super(nombrePartida, nombreJugador);
	}

	@Override
	protected boolean esPosibleCantarFlor() {
		return false;
	}
}
