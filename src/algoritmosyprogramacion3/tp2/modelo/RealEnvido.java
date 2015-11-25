package algoritmosyprogramacion3.tp2.modelo;

public class RealEnvido extends Evento {

	public RealEnvido() {
		this.puntosGanados = 3;
		this.puntosPorRechazo = 1;
	}

	@Override
	public Evento subirApuesta() {
		return new FaltaEnvido();
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
