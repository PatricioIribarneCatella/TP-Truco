package algoritmosyprogramacion3.tp2.manejadores;

import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAceptarFaltaEnvidoEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonAceptarFaltaEnvidoEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vista.getModelo();
		
		try {
			modelo.aceptarVarianteEnvidoPorJugador(modelo.getNombreJugadorConDecisionEnvido());
			this.vista.setMensajeInformacion("Falta Envido aceptado");
			this.vista.graficarSituacionFaltaEnvidoAceptada();
			
		} catch (TurnoParaTomarDecisionEquivocadoException ex) {
			
			this.vista.setMensajeInformacion("Ya ha aceptado la Falta Envido");
		}
	}
}
