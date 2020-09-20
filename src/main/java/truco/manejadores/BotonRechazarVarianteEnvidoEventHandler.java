package truco.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import truco.modelo.JuegoTruco;
import truco.vista.VistaJuegoDeTruco;

public class BotonRechazarVarianteEnvidoEventHandler implements EventHandler<ActionEvent> {

	private VistaJuegoDeTruco vista;
	
	public BotonRechazarVarianteEnvidoEventHandler(VistaJuegoDeTruco vista) {
		this.vista = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vista.getModelo();
		
		modelo.rechazarVarianteEnvidoPorJugador(modelo.getNombreJugadorConDecisionEnvido());
		this.vista.setMensajeInformacion("Se ha rechazado");
		this.vista.graficarSituacionVarianteEnvidoRechazada();
	}
}
