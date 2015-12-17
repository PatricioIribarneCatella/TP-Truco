package algoritmosyprogramacion3.tp2.utilitarios;

import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.scene.layout.VBox;

public abstract class Situacion {

	public static Situacion situacionInicial(VistaJuegoDeTruco vista) {
		return new SituacionInicial(vista);
	}

	public static Situacion situacionPostEnvido(VistaJuegoDeTruco vista) {
		return new SituacionPostEnvido(vista);
	}
	
	public static Situacion situacionPostFlor(VistaJuegoDeTruco vista) {
		return new SituacionPostFlor(vista);
	}
	
	public abstract  VBox getBotones();
}
