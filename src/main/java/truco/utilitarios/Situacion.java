package truco.utilitarios;

import javafx.scene.layout.VBox;

import truco.vista.VistaJuegoDeTruco;

public abstract class Situacion {

	public static Situacion situacionInicial(VistaJuegoDeTruco vista) {
		return new SituacionInicial(vista);
	}

	public static Situacion situacionCartaJugada(VistaJuegoDeTruco vista) {
		return new SituacionCartaJugada(vista);
	}

	public static Situacion situacionPostEnvido(VistaJuegoDeTruco vista) {
		return new SituacionPostEnvido(vista);
	}

	public static Situacion situacionPostFlor(VistaJuegoDeTruco vista) {
		return new SituacionPostFlor(vista);
	}

	public abstract VBox getBotones();
}
