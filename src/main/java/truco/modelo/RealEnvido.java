package truco.modelo;

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
	public int getPuntosGanados(Equipo equipo) {
		return this.puntosGanados;
	}
	
	@Override
	public boolean esPosibleSubirLaApuesta() {
		return true;
	}
}
