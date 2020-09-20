package truco.utilitarios;

import javafx.scene.layout.VBox;

import truco.vista.VistaJuegoDeTruco;

public class SituacionInicial extends Situacion {

	private VistaJuegoDeTruco vista;
	
	public SituacionInicial(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public VBox getBotones() {
		return GraficadorBotonesDeCantos.graficarSituacionInicial(this.vista.getModelo().getPartida(), vista);
	}
}
