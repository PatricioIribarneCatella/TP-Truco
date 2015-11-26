package algoritmosyprogramacion3.tp2.manejadores;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.vista.Vista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVolverEventHandler implements EventHandler<ActionEvent> {

	private Vista vistaActual;
	private Vista vistaNueva;
	
	public BotonVolverEventHandler(Vista vistaActual, Vista vistaNueva) {
		
		this.vistaActual = vistaActual;
		this.vistaNueva = vistaNueva;
	}

	@Override
	public void handle(ActionEvent event) {
		
		JuegoTruco modelo = this.vistaActual.getModelo();
		this.vistaNueva.setModelo(modelo);
		this.vistaNueva.mostrar();
	}
}
