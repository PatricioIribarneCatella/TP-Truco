package algoritmosyprogramacion3.tp2.modelo;

public class FaltaEnvido extends Canto {
	
	public FaltaEnvido() {
		this.puntosPorRechazo = 1;
	}

	@Override
	public Canto subirApuesta() {
		return null;
	}

	@Override
	public int getPuntosGanados(Equipo equipo) {
		return 30 - equipo.getPuntaje();
	}
	
	@Override
	public boolean esPosibleSubirLaApuesta() {
		return false;
	}
}
