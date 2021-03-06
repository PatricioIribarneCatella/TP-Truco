package truco.modelo;

public class Envido extends Canto {

	public Envido() {
		this.puntosGanados = 2;
		this.puntosPorRechazo = 1;
	}

	@Override
	public Canto subirApuesta() {
		return new RealEnvido();
	}

	@Override
	public int getPuntosGanados(Equipo equipo) {
		return this.puntosGanados;
	}

	@Override
	public boolean esPosibleSubirLaApuesta() {
		return true;
	}
}
