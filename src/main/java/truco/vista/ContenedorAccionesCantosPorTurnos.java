package truco.vista;

import javafx.scene.layout.VBox;

import truco.modelo.JuegoTruco;

public class ContenedorAccionesCantosPorTurnos extends ContenedorAccionesCantos {

	public ContenedorAccionesCantosPorTurnos(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	protected void cambiarTurnoDeDecision(VBox botones, String nombreJugador) {
		
		this.vista.cambiarTurno(nombreJugador, botones);
	}
}
