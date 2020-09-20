package truco.vista;

import javafx.scene.layout.VBox;

import truco.modelo.JuegoTruco;

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
			
			ventana.mostrar();
		}
	}
}
