package truco.modelo;

public class Truco extends Canto {

	public Truco() {
		this.puntosGanados = 2;
		this.puntosPorRechazo = 1;
	}

	@Override
	public Canto subirApuesta() {
		return new ReTruco();
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
