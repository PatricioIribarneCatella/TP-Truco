package algoritmosyprogramacion3.tp2.modelo;

public class PartidaContraComputadoraConFlor extends PartidaContraComputadora {

	public PartidaContraComputadoraConFlor(String nombrePartida, String nombreJugador) {
		super(nombrePartida, nombreJugador);
	}

	@Override
	protected boolean esPosibleCantarFlor() {
		return true;
	}
}
