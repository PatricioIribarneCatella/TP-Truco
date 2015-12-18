package algoritmosyprogramacion3.tp2.modelo;

public class PartidaContraComputadoraConFlor extends PartidaContraComputadora implements PartidaConFlor {

	public PartidaContraComputadoraConFlor(String nombrePartida, String nombreJugador) {
		super(nombrePartida, nombreJugador);
	}

	@Override
	protected boolean esPosibleCantarFlor() {
		return true;
	}
}
