package truco.vista;

import javafx.scene.layout.VBox;

import truco.modelo.JuegoTruco;

public class ContenedorAccionesCantosComputadora extends ContenedorAccionesCantos {

	public ContenedorAccionesCantosComputadora(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	protected void cambiarTurnoDeDecision(VBox botones, String nombreJugador) {
		
		this.getChildren().addAll(botones.getChildren());
		// no cambia de turno gráficamente
	}
}
