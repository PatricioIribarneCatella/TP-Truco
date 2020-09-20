package truco.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import truco.excepciones.AccionInvalidaException;
import truco.excepciones.TurnoParaTomarDecisionEquivocadoException;
import truco.modelo.JuegoTruco;
import truco.vista.VistaJuegoDeTruco;

public class BotonRealEnvidoEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonRealEnvidoEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vista.getModelo();
		
		try {
			
			modelo.cantarRealEnvidoPorJugador(modelo.getNombreJugadorConDecisionEnvido());
			this.vista.setMensajeInformacion("Real Envido cantado");
			this.vista.graficarSituacionRealEnvido();
			
		} catch (AccionInvalidaException ex) {
			
			this.vista.setMensajeInformacion("No se puede cantar Real Envido en este momento");
			
		} catch (TurnoParaTomarDecisionEquivocadoException ex) {
			
			this.vista.setMensajeInformacion("No es su turno");
		}
	}
}
