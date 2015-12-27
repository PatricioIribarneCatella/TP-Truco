package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorCartasComputadora extends ContenedorCartas {

	public ContenedorCartasComputadora(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	public void cambiarTurno(String nombreJugador, VBox botones) {
		// no cambia de turnos gráficamente
	}

	@Override
	protected void mostrarInformacionJugada() {
		
		if (this.modelo.equipoGanoDosDeTres()) {
			
			VentanaInformacionJugada ventana = new VentanaInformacionJugadaComputadora(this.vista, this.modelo);
			
			try {
				ventana.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
