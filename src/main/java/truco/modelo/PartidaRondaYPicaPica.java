package truco.modelo;

import java.util.List;

public abstract class PartidaRondaYPicaPica extends PartidaPorTurnos {

	private Equipo equipo1;
	private Equipo equipo2;
	private ManejadorRotacion manejoDeRotacion;
	
	public PartidaRondaYPicaPica(String nombrePartida, List<String> jugadoresEquipo1, List<String> jugadoresEquipo2) {
		super(nombrePartida, jugadoresEquipo1, jugadoresEquipo2);
	}

	@Override
	protected void setConfiguracionDeLaRotacion(List<Jugable> jugadores, Equipo equipo1, Equipo equipo2) {
		
		this.manejoDeRotacion = new ManejadorRotacion(jugadores);
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	@Override
	protected void verificarEstrategiaDeRotacion() {
		
		this.manejoDeRotacion.verificarEstrategiaDeRotacion(this.equipo1, this.equipo2);
		RotacionStrategy rotacion = this.manejoDeRotacion.getRotacion();
		this.moderador.setRotacionStrategy(rotacion);
	}
}
