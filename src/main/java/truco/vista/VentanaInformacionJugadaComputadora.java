package truco.vista;

import truco.modelo.JuegoTruco;

public class VentanaInformacionJugadaComputadora extends VentanaInformacionJugada {

	public VentanaInformacionJugadaComputadora(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	protected String informacionParaSeguirJugando() {
		return "Para continuar pulse el botón (Aceptar) y pulse el mazo para repartir las cartas";
	}
}
