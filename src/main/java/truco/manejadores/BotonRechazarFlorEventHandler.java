package truco.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import truco.modelo.JuegoTruco;
import truco.vista.VistaJuegoDeTruco;

public class BotonRechazarFlorEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonRechazarFlorEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vista.getModelo();
		
		modelo.rechazarFlorPorJugador(modelo.getNombreJugadorConDecisionFlor());
		this.vista.setMensajeInformacion("Flor rechazada");
		this.vista.graficarSituacionFlorRechazada();
	}
}
