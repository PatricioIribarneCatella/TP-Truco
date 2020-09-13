package algoritmosyprogramacion3.tp2.vista;

import java.util.Set;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;

public class VentanaInformacionEnvidoRechazado extends Ventana {

	public VentanaInformacionEnvidoRechazado(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);	
	}
	
	@Override
	protected String getTextoEscena() {
		return "Envido rechazado";
	}

	@Override
	protected Set<String> getNombresJugadoresGanadores() {
		return this.modelo.getEquipoGanadorEnvido();
	}

	@Override
	protected String getPuntajeAcumulado() {
		return this.modelo.getPuntajeAcumuladoEnvidoRechazado();
	}

	@Override
	protected String getInformacionParaSeguirJugando() {
		return "Para continuar pulse el botón (Aceptar) e inicie su turno (Botón Iniciar turno)";
	}
}
