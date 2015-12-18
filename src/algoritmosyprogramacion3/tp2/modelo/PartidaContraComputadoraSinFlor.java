package algoritmosyprogramacion3.tp2.modelo;

public class PartidaContraComputadoraSinFlor extends PartidaContraComputadora implements PartidaSinFlor {

	public PartidaContraComputadoraSinFlor(String nombrePartida, String nombreJugador) {
		super(nombrePartida, nombreJugador);
	}

	@Override
	protected boolean esPosibleCantarFlor() {
		return false;
	}
}
