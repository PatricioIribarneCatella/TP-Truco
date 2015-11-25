package algoritmosyprogramacion3.tp2.modelo;

public class ValeCuatro extends Canto {

	public ValeCuatro() {
		this.puntosGanados = 4;
		this.puntosPorRechazo = 3;
	}

	@Override
	public Canto subirApuesta() {
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
