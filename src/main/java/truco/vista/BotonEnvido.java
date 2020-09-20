package truco.vista;

import javafx.scene.Node;

import truco.manejadores.BotonEnvidoEventHandler;

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
