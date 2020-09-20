package truco.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import truco.excepciones.AccionInvalidaException;
import truco.excepciones.TurnoParaTomarDecisionEquivocadoException;
import truco.modelo.JuegoTruco;
import truco.vista.VistaJuegoDeTruco;

public class BotonValeCuatroEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonValeCuatroEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vista.getModelo();
		
		try {
			
			modelo.cantarValeCuatroPorJugador(modelo.getNombreJugadorConDecisionTruco());
			this.vista.setMensajeInformacion("Vale cuatro cantado");
			this.vista.graficarSituacionValeCuatro();
			
		} catch (AccionInvalidaException ex) {
			
			this.vista.setMensajeInformacion("No se puede cantar Vale cuatro en este momento");
			
		} catch (TurnoParaTomarDecisionEquivocadoException ex) {
			
			this.vista.setMensajeInformacion("No es su turno");
		}
	}
}
