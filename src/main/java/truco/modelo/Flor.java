package truco.modelo;

public class Flor extends Canto {
	
	public Flor() {
		this.puntosGanados = 3;
		this.puntosPorRechazo = 3;
	}

	@Override
	public Canto subirApuesta() {
		return null;
	}

	@Override
	public int getPuntosGanados(Equipo equipo) {
		return this.puntosGanados;
	}
	
	@Override
	public boolean esPosibleSubirLaApuesta() {
		return false;
	}
}
