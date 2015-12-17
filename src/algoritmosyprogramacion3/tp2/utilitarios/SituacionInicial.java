package algoritmosyprogramacion3.tp2.utilitarios;

import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.scene.layout.VBox;

public class SituacionInicial extends Situacion {

	private VistaJuegoDeTruco vista;
	
	public SituacionInicial(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public VBox getBotones() {
		return GraficadorBotonesDeCantos.graficarSituacionInicial(this.vista.getModelo().seJuegaConFlor(), vista);
	}
}
