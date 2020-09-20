package truco.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import truco.modelo.JuegoTruco;
import truco.vista.VistaJuegoDeTruco;
import truco.excepciones.TurnoParaTomarDecisionEquivocadoException;

public class BotonAceptarRealEnvidoEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonAceptarRealEnvidoEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {

		JuegoTruco modelo = this.vista.getModelo();
		
		try {
			modelo.aceptarVarianteEnvidoPorJugador(modelo.getNombreJugadorConDecisionEnvido());
			this.vista.setMensajeInformacion("Real Envido aceptado");
			this.vista.graficarSituacionRealEnvidoAceptada();
			
		} catch (TurnoParaTomarDecisionEquivocadoException ex) {
			
			this.vista.setMensajeInformacion("Ya ha aceptado el Real Envido");
		}
	}
}
