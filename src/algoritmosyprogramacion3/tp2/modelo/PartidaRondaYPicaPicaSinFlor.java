package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

public class PartidaRondaYPicaPicaSinFlor extends PartidaRondaYPicaPica implements PartidaSinFlor {

	public PartidaRondaYPicaPicaSinFlor(String nombrePartida, List<String> jugadoresEquipo1, List<String> jugadoresEquipo2) {
		super(nombrePartida, jugadoresEquipo1, jugadoresEquipo2);
	}

	@Override
	protected boolean esPosibleCantarFlor() {
		return false;
	}
}
