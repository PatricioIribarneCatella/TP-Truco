package truco.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import truco.excepciones.TurnoParaTomarDecisionEquivocadoException;
import truco.modelo.JuegoTruco;
import truco.vista.VistaJuegoDeTruco;

public class BotonAceptarFlorEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonAceptarFlorEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vista.getModelo();
		
		try {
			modelo.aceptarFlorPorJugador(modelo.getNombreJugadorConDecisionEnvido());
			this.vista.setMensajeInformacion("Flor aceptada");
			this.vista.graficarSituacionFlorAceptada();
			
		} catch (TurnoParaTomarDecisionEquivocadoException ex) {
			
			this.vista.setMensajeInformacion("Ya ha aceptado la Flor");
		}
	}
}
