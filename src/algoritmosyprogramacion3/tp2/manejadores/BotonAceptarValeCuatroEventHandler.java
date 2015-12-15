package algoritmosyprogramacion3.tp2.manejadores;

import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
