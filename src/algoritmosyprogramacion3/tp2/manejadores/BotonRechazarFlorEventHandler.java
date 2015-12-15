package algoritmosyprogramacion3.tp2.manejadores;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonRechazarFlorEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonRechazarFlorEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vista.getModelo();
		
		modelo.rechazarFlorPorJugador(modelo.getNombreJugadorConDecisionFlor());
		this.vista.setMensajeInformacion("Flor rechazada");
		this.vista.graficarSituacionFlorRechazada();
	}
}
