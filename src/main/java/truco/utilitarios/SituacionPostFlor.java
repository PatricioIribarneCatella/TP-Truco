package algoritmosyprogramacion3.tp2.utilitarios;

import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.scene.layout.VBox;

public class SituacionPostFlor extends Situacion {

	private VistaJuegoDeTruco vista;
	
	public SituacionPostFlor(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public VBox getBotones() {
		return GraficadorBotonesDeCantos.graficarSituacionFlorAceptada(vista);
	}
}
