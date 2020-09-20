package truco.vista;

import javafx.scene.Node;

import truco.manejadores.BotonRealEnvidoEventHandler;

public class BotonRealEnvido extends BotonJuegoTruco {

	public BotonRealEnvido() {
		this.setText("Real Envido");
	}

	public BotonRealEnvido(String text) {
		super(text);
	}

	public BotonRealEnvido(String text, Node graphic) {
		super(text, graphic);
	}

	@Override
	public void setVistaAlEventHandler(VistaJuegoDeTruco vista) {
		this.setOnAction(new BotonRealEnvidoEventHandler(vista));
	}
}
