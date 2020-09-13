package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.manejadores.BotonFaltaEnvidoEventHandler;
import javafx.scene.Node;

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
