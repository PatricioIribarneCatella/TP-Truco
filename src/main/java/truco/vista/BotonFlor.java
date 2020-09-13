package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.manejadores.BotonFlorEventHandler;
import javafx.scene.Node;

public class BotonFlor extends BotonJuegoTruco {

	public BotonFlor() {
		this.setText("Flor");
	}

	public BotonFlor(String text) {
		super(text);
	}

	public BotonFlor(String text, Node graphic) {
		super(text, graphic);
	}

	@Override
	public void setVistaAlEventHandler(VistaJuegoDeTruco vista) {
		this.setOnAction(new BotonFlorEventHandler(vista));
	}
}
