package algoritmosyprogramacion3.tp2.utilitarios;

import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.scene.layout.VBox;

public class SituacionPostEnvido extends Situacion {

	private VistaJuegoDeTruco vista;
	
	public SituacionPostEnvido(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public VBox getBotones() {
		
		return GraficadorBotonesDeCantos.graficarSituacionEnvidoAceptada(vista);
	}
}
