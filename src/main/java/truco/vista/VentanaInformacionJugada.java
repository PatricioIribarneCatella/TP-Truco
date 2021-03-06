package truco.vista;

import java.util.Set;

import truco.modelo.JuegoTruco;

public abstract class VentanaInformacionJugada extends Ventana {

	public VentanaInformacionJugada(VistaJuegoDeTruco vista, JuegoTruco modelo) {		
		super(vista, modelo);
	}

	protected abstract String informacionParaSeguirJugando();

	@Override
	protected String getTextoEscena() {
		return "Resultado Jugada";
	}

	@Override
	protected Set<String> getNombresJugadoresGanadores() {
		return this.modelo.getEquipoGanadorTruco();
	}

	@Override
	protected String getPuntajeAcumulado() {
		return this.modelo.getPuntajeAcumuladoTrucoJugado();
	}

	@Override
	protected String getInformacionParaSeguirJugando() {
		return this.informacionParaSeguirJugando();
	}
}
