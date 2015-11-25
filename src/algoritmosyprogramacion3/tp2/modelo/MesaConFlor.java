package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

public class MesaConFlor extends Mesa {
	
	public MesaConFlor(List<Jugable> jugadores) {
		super(jugadores);
	}

	@Override
	public boolean seJuegaConFlor() {
		return true;
	}
}
