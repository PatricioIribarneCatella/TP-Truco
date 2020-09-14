package truco.vista;

import java.util.Set;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import truco.modelo.JuegoTruco;

public class VentanaInformacionFlorAceptada extends Ventana {

	public VentanaInformacionFlorAceptada(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		
		super(vista, modelo);

		Label etiquetaPuntos = new Label("Puntos envido: " + this.modelo.getPuntajeGanadorFlor());
		etiquetaPuntos.setTextFill(Color.WHITE);

		contenedor.add(etiquetaPuntos, 0, 2);
	}

	@Override
	protected String getTextoEscena() {
		return "Resultado Contra flor";
	}

	@Override
	protected Set<String> getNombresJugadoresGanadores() {
		return this.modelo.getEquipoGanadorFlor();
	}

	@Override
	protected String getPuntajeAcumulado() {
		return this.modelo.getPuntajeAcumuladoFlorJugada();
	}

	@Override
	protected String getInformacionParaSeguirJugando() {
		return "Para continuar pulse el botón (Aceptar) e inicie su turno (Botón Iniciar turno)";
	}
}
