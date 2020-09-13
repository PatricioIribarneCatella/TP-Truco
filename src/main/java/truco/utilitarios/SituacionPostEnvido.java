package truco.utilitarios;

import javafx.scene.layout.VBox;

import truco.vista.VistaJuegoDeTruco;

public class SituacionPostEnvido extends Situacion {

	private VistaJuegoDeTruco vista;

	public SituacionPostEnvido(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public VBox getBotones() {
		return GraficadorBotonesDeCantos.graficarSituacionEnvidoAceptada(vista);
	}
}
