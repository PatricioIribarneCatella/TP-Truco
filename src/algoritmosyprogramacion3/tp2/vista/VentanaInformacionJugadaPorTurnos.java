package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;

public class VentanaInformacionJugadaPorTurnos extends VentanaInformacionJugada {

	public VentanaInformacionJugadaPorTurnos(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	protected String informacionParaSeguirJugando() {
		return "Para continuar pulse el botón (Aceptar), inicie su turno (Boton Iniciar turno) y pulse el mazo para repartir las cartas";
	}
}
