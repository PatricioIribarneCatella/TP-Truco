package algoritmosyprogramacion3.tp2.modelo;

public class Envido extends Evento {

	public Envido() {
		this.puntosGanados = 2;
		this.puntosPorRechazo = 1;
	}

	@Override
	public Evento subirApuesta() {
		return new RealEnvido();
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
