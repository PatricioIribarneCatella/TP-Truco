package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

public class MesaSinFlor extends Mesa {

	public MesaSinFlor(List<Jugador> jugadores) {
		super(jugadores);
	}

	@Override
	public boolean seJuegaConFlor() {
		return false;
	}
}
