package truco.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import truco.excepciones.AccionInvalidaException;
import truco.excepciones.JugadorSinFlorException;
import truco.excepciones.TurnoParaTomarDecisionEquivocadoException;
import truco.modelo.JuegoTruco;
import truco.vista.VistaJuegoDeTruco;

public class BotonFlorEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonFlorEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vista.getModelo();
		
		try {
			
			modelo.cantarFlorPorJugador(modelo.getNombreJugadorConTurno());
			this.vista.setMensajeInformacion("Flor cantada");
			this.vista.graficarSituacionFlor();
			
		} catch (AccionInvalidaException ex) {
			
			this.vista.setMensajeInformacion("No se puede cantar Flor en este momento");
			
		} catch (JugadorSinFlorException ex) {
			
			this.vista.setMensajeInformacion("No posee tres cartas del mismo palo");
			
		} catch (TurnoParaTomarDecisionEquivocadoException ex) {
			
			this.vista.setMensajeInformacion("No es su turno");
		}
	}
}
