package truco.vista;

import javafx.scene.Node;
import javafx.scene.control.Button;

public abstract class BotonJuegoTruco extends Button {
	
	public BotonJuegoTruco() {
	}

	public BotonJuegoTruco(String text) {
		super(text);
	}

	public BotonJuegoTruco(String text, Node graphic) {
		super(text, graphic);
	}
	
	public abstract void setVistaAlEventHandler(VistaJuegoDeTruco vista);
}
