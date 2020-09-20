package truco.modelo;

import java.util.List;

public abstract class PartidaRonda extends PartidaPorTurnos {

	public PartidaRonda(String nombrePartida, List<String> jugadoresEquipo1, List<String> jugadoresEquipo2) {
		super(nombrePartida, jugadoresEquipo1, jugadoresEquipo2);
	}

	@Override
	protected void verificarEstrategiaDeRotacion() {
		// No verifica ninguna estrategia ya que la ronda es la única que hay
	}

	@Override
	protected void setConfiguracionDeLaRotacion(List<Jugable> jugadores, Equipo equipo1, Equipo equipo2) {
		// no se configura ya que solo hay una modalidad que es la de jugar en ronda
	}
}
