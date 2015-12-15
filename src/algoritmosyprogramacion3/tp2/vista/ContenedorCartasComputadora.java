package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;

public class ContenedorCartasComputadora extends ContenedorCartas {

	public ContenedorCartasComputadora(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	protected void cambiarTurno() {
		// no cambia de turnos gráficamente
	}
}
