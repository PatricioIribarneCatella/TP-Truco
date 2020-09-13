package truco.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import truco.modelo.JuegoTruco;
import truco.vista.VistaJuegoDeTruco;

public class BotonRechazarVarianteTrucoEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonRechazarVarianteTrucoEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vista.getModelo();
		
		modelo.rechazarVarianteTrucoPorJugador(modelo.getNombreJugadorConDecisionTruco());
		this.vista.setMensajeInformacion("Se ha rechazado");
		this.vista.graficarSituacionVarianteTrucoRechazada();
	}
}
