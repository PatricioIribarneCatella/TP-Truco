package truco.utilitarios;

import javafx.scene.layout.VBox;

import truco.vista.VistaJuegoDeTruco;

public class SituacionCartaJugada extends Situacion {

	private VistaJuegoDeTruco vista;
	
	public SituacionCartaJugada(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public VBox getBotones() {
		
		return GraficadorBotonesDeCantos.graficarSituacionCartaJugada(vista);
	}
}
