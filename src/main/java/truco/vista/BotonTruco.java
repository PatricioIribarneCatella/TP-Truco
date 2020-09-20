package truco.vista;

import javafx.scene.Node;

import truco.manejadores.BotonTrucoEventHandler;

public class BotonTruco extends BotonJuegoTruco {

	public BotonTruco() {
		this.setText("Truco");
	}

	public BotonTruco(String text) {
		super(text);
	}

	public BotonTruco(String text, Node graphic) {
		super(text, graphic);
	}

	@Override
	public void setVistaAlEventHandler(VistaJuegoDeTruco vista) {
		this.setOnAction(new BotonTrucoEventHandler(vista));
	}
}
