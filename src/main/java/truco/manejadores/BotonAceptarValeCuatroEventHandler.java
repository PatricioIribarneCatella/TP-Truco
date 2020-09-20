package truco.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import truco.excepciones.TurnoParaTomarDecisionEquivocadoException;
import truco.modelo.JuegoTruco;
import truco.vista.VistaJuegoDeTruco;

public class BotonAceptarValeCuatroEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonAceptarValeCuatroEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vista.getModelo();
		
		try {
			modelo.aceptarValeCuatroPorJugador(modelo.getNombreJugadorConDecisionTruco());
			this.vista.setMensajeInformacion("Truco aceptado");
			this.vista.graficarSituacionValeCuatroAceptado();
			
		} catch (TurnoParaTomarDecisionEquivocadoException ex) {
			
			this.vista.setMensajeInformacion("Ya ha aceptado el Vale Cuatro");
		}
	}
}
