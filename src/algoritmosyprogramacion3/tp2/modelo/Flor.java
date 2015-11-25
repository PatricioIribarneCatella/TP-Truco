package algoritmosyprogramacion3.tp2.modelo;

public class Flor extends Evento {

	public Flor() {
		this.puntosGanados = 4;
		this.puntosPorRechazo = 0;
	}

	@Override
	public Evento subirApuesta() {
		return null;
	}

	@Override
	public int getPuntosGanados(Jugable jugador) {
		return this.puntosGanados;
	}
	
	@Override
	public boolean esPosibleSubirLaApuesta() {
		return false;
	}
}
