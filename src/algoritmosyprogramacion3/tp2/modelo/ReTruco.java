package algoritmosyprogramacion3.tp2.modelo;

public class ReTruco extends Canto {

	public ReTruco() {
		this.puntosGanados = 3;
		this.puntosPorRechazo = 2;
	}

	@Override
	public Canto subirApuesta() {
		return new ValeCuatro();
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
