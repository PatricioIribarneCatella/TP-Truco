package algoritmosyprogramacion3.tp2.manejadores;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
		this.vista.graficarSituacionVarianteTrucoRechazada();
	}
}
