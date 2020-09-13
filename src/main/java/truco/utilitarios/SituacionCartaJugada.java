package algoritmosyprogramacion3.tp2.utilitarios;

import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.scene.layout.VBox;

public class SituacionCartaJugada extends Situacion {

	private VistaJuegoDeTruco vista;
	
	public SituacionCartaJugada(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public VBox getBotones() {
		
		return GraficadorBotonesDeCantos.graficarSituacionCartaJugada(vista);
	}
}
