package truco.modelo;

import java.util.List;

public class PartidaRondaYPicaPicaConFlor extends PartidaRondaYPicaPica {

	public PartidaRondaYPicaPicaConFlor(String nombrePartida, List<String> jugadoresEquipo1, List<String> jugadoresEquipo2) {
		super(nombrePartida, jugadoresEquipo1, jugadoresEquipo2);
	}

	@Override
	protected boolean esPosibleCantarFlor() {
		return true;
	}
}
