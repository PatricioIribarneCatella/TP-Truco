package algoritmosyprogramacion3.tp2.modelo;

public class RealEnvido extends Canto {

	public RealEnvido() {
		this.puntosGanados = 3;
		this.puntosPorRechazo = 1;
	}

	@Override
	public Canto subirApuesta() {
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
