package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.scene.layout.VBox;

public class ContenedorAccionesCantosComputadora extends ContenedorAccionesCantos {

	public ContenedorAccionesCantosComputadora(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	protected void cambiarTurnoDeDecision(VBox botones, String nombreJugador) {
		
		this.getChildren().addAll(botones.getChildren());
		// no cambia de turno gráficamente
	}
}
