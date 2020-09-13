package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.scene.layout.VBox;

public class ContenedorAccionesCantosPorTurnos extends ContenedorAccionesCantos {

	public ContenedorAccionesCantosPorTurnos(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	protected void cambiarTurnoDeDecision(VBox botones, String nombreJugador) {
		
		this.vista.cambiarTurno(nombreJugador, botones);
	}
}
