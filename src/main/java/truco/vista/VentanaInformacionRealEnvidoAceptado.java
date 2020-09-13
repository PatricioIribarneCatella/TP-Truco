package algoritmosyprogramacion3.tp2.vista;

import java.util.Set;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class VentanaInformacionRealEnvidoAceptado extends Ventana {
	
	public VentanaInformacionRealEnvidoAceptado(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		
		super(vista, modelo);
		
		Label etiquetaPuntos = new Label("Puntos envido: " + this.modelo.getPuntajeGanadorEnvido());
		etiquetaPuntos.setTextFill(Color.WHITE);
		
		contenedor.add(etiquetaPuntos, 0, 2);
	}

	@Override
	protected String getTextoEscena() {
		return "Resultado Real envido";
	}

	@Override
	protected Set<String> getNombresJugadoresGanadores() {
		return this.modelo.getEquipoGanadorEnvido();
	}

	@Override
	protected String getPuntajeAcumulado() {
		return this.modelo.getPuntajeAcumuladoEnvidoJugado();
	}

	@Override
	protected String getInformacionParaSeguirJugando() {
		return "Para continuar pulse el botón (Aceptar)";
	}
}
