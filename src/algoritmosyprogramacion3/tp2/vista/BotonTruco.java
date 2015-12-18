package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.manejadores.BotonTrucoEventHandler;
import javafx.scene.Node;

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
