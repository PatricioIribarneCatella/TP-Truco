package algoritmosyprogramacion3.tp2.vista;

public class VistaJuegoDeTrucoPorTurnos extends VistaJuegoDeTruco {

	public VistaJuegoDeTrucoPorTurnos(Vista vistaAnterior) {
		super(vistaAnterior);
	}
	
	@Override
	protected void setCaracteristicasAlContenedorInformacionJugadores() {
		
		this.contenedorInformacionJugadores = new ContenedorInformacionJugadoresYMazoPorTurnos(this, this.modelo);
	}

	@Override
	protected void setCaracteristicasAlContenedorCartas() {
		
		this.contenedorCartas = new ContenedorCartasPorTurnos(this, this.modelo);
	}
}
