package truco.utilitarios;

import javafx.scene.layout.VBox;

import truco.vista.VistaJuegoDeTruco;

public class SituacionPostFlor extends Situacion {

	private VistaJuegoDeTruco vista;
	
	public SituacionPostFlor(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public VBox getBotones() {
		return GraficadorBotonesDeCantos.graficarSituacionFlorAceptada(vista);
	}
}
