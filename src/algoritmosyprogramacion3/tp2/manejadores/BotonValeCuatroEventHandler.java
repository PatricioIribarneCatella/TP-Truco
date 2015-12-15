package algoritmosyprogramacion3.tp2.manejadores;

import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
