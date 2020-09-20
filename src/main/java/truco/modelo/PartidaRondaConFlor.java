package truco.modelo;

import java.util.List;

public class PartidaRondaConFlor extends PartidaRonda {

	public PartidaRondaConFlor(String nombrePartida, List<String> jugadoresEquipo1, List<String> jugadoresEquipo2) {
		super(nombrePartida, jugadoresEquipo1, jugadoresEquipo2);
	}

	@Override
	protected boolean esPosibleCantarFlor() {
		return true;
	}
}
