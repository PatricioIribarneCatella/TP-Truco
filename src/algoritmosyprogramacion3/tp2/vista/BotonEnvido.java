package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.manejadores.BotonEnvidoEventHandler;
import javafx.scene.Node;

public class BotonEnvido extends BotonJuegoTruco {

	public BotonEnvido() {
		this.setText("Envido");
	}

	public BotonEnvido(String text) {
		super(text);
	}

	public BotonEnvido(String text, Node graphic) {
		super(text, graphic);
	}
	
	@Override
	public void setVistaAlEventHandler(VistaJuegoDeTruco vista) {
		this.setOnAction(new BotonEnvidoEventHandler(vista));
	}
}
