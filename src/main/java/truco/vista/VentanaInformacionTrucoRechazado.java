package algoritmosyprogramacion3.tp2.vista;

import java.util.Set;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;

public class VentanaInformacionTrucoRechazado extends Ventana {
	
	public VentanaInformacionTrucoRechazado(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		
		super(vista, modelo);
	}
	
	@Override
	protected String getTextoEscena() {
		return "Canto rechazado";
	}

	@Override
	protected Set<String> getNombresJugadoresGanadores() {
		return this.modelo.getEquipoGanadorTruco();
	}

	@Override
	protected String getPuntajeAcumulado() {
		return this.modelo.getPuntajeAcumuladoTrucoRechazado();
	}

	@Override
	protected String getInformacionParaSeguirJugando() {
		return "Para continuar pulse el botón (Aceptar)";
	}
}
