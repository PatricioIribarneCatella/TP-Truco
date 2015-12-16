package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.scene.layout.VBox;

public class ContenedorCartasComputadora extends ContenedorCartas {

	public ContenedorCartasComputadora(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	public void cambiarTurno(String nombreJugador, VBox botones) {
		// no cambia de turnos gráficamente
	}
}
