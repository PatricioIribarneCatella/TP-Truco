package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.manejadores.BotonRealEnvidoEventHandler;
import javafx.scene.Node;

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
