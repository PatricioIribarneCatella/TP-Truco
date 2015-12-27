package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;

public class VentanaInformacionJugadaComputadora extends VentanaInformacionJugada {

	public VentanaInformacionJugadaComputadora(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	protected String informacionParaSeguirJugando() {
		return "Para continuar pulse el botón (Aceptar) y pulse el mazo para repartir las cartas";
	}
}
