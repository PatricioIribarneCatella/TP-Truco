package algoritmosyprogramacion3.tp2.vista;

import java.util.Set;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;

public class VentanaInformacionFlorRechazada extends Ventana {
	
	public VentanaInformacionFlorRechazada(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		
		super(vista, modelo);
	}
	
	@Override
	protected String getTextoEscena() {
		return "Flor rechazada";
	}

	@Override
	protected Set<String> getNombresJugadoresGanadores() {
		return this.modelo.getEquipoGanadorFlor();
	}

	@Override
	protected String getPuntajeAcumulado() {
		return this.modelo.getPuntajeAcumuladoFlorRechazada();
	}

	@Override
	protected String getInformacionParaSeguirJugando() {
		return "Para continuar pulse el botón (Aceptar) e inicie su turno (Botón Iniciar turno)";
	}
}
