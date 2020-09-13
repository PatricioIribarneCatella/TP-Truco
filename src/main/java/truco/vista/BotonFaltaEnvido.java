package truco.vista;

import javafx.scene.Node;

import truco.manejadores.BotonFaltaEnvidoEventHandler;

public class BotonFaltaEnvido extends BotonJuegoTruco {

	public BotonFaltaEnvido() {
		this.setText("Falta Envido");
	}

	public BotonFaltaEnvido(String text) {
		super(text);
	}

	public BotonFaltaEnvido(String text, Node graphic) {
		super(text, graphic);
	}

	@Override
	public void setVistaAlEventHandler(VistaJuegoDeTruco vista) {
		this.setOnAction(new BotonFaltaEnvidoEventHandler(vista));		
	}
}
