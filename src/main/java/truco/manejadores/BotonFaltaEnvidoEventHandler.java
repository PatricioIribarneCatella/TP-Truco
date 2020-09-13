package truco.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import truco.excepciones.AccionInvalidaException;
import truco.excepciones.TurnoParaTomarDecisionEquivocadoException;
import truco.modelo.JuegoTruco;
import truco.vista.VistaJuegoDeTruco;

public class BotonFaltaEnvidoEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;

	public BotonFaltaEnvidoEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {

		JuegoTruco modelo = this.vista.getModelo();

		try {

			modelo.cantarFaltaEnvidoPorJugador(modelo.getNombreJugadorConDecisionEnvido());
			this.vista.setMensajeInformacion("Falta Envido cantado");
			this.vista.graficarSituacionFaltaEnvido();
			
		} catch (AccionInvalidaException ex) {

			this.vista.setMensajeInformacion("No se puede cantar Falta Envido en este momento");

		} catch (TurnoParaTomarDecisionEquivocadoException ex) {

			this.vista.setMensajeInformacion("No es su turno");
		}
	}
}
