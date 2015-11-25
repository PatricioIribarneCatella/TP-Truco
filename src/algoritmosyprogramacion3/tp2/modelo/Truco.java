package algoritmosyprogramacion3.tp2.modelo;

public class Truco extends Evento {

	public Truco() {
		this.puntosGanados = 2;
		this.puntosPorRechazo = 1;
	}

	@Override
	public Evento subirApuesta() {
		return new ReTruco();
	}

	@Override
	public int getPuntosGanados(Jugable jugador) {
		return this.puntosGanados;
	}
	
	@Override
	public boolean esPosibleSubirLaApuesta() {
		return true;
	}
}
