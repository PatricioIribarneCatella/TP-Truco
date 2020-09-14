package truco.vista;

import java.util.Observable;
import java.util.Observer;

import truco.modelo.Carta;
import truco.modelo.Respuesta;
import truco.modelo.PartidaContraComputadora;
import truco.utilitarios.ObserverCantos;
import truco.utilitarios.ObserverCartas;
import truco.utilitarios.ObservableComputadora;

public class VistaJuegoDeTrucoComputadora extends VistaJuegoDeTruco implements ObserverCartas, ObserverCantos, Observer {

	private PartidaContraComputadora partida;
	
	public VistaJuegoDeTrucoComputadora(Vista vistaAnterior) {
		
		super(vistaAnterior);
		this.modelo.addObserver(this);
		this.partida = (PartidaContraComputadora) this.modelo.getPartida();
		partida.getComputadora().addObserverParaCartas(this);
		partida.getComputadora().addObserverParaCantos(this);
	}
	
	@Override
	public void updateCarta(ObservableComputadora o, Object arg) {
		
		Carta carta = (Carta) arg;
		
		this.contenedorCartasJugadas.graficarCartaJugada(carta, "Computadora");
	}

	@Override
	public void updateCanto(ObservableComputadora o, Object arg) {
		
		Respuesta respuesta = (Respuesta) arg;
		
		if (respuesta.fuePositiva()) {
			setMensajeInformacion("Aceptado");
		} else {
			setMensajeInformacion("Rechazado");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		setTextoPuntosJugador("Puntos: " + this.modelo.mostrarPuntosDeJugador(this.partida.getNombreJugador()));
	}

	@Override
	protected void setCaracteristicasAlContenedorInformacionJugadores() {
		
		this.contenedorInformacionJugadores = new ContenedorInformacionJugadoresYMazoComputadora(this, this.modelo);
	}
	
	@Override
	protected void setCaracteristicasAlContenedorCartas() {
		
		this.contenedorCartas = new ContenedorCartasComputadora(this, this.modelo);
	}

	@Override
	protected void setCaracteristicasAlContenedorBotonesDeCantos() {
		
		this.contenedorBotones = new ContenedorAccionesCantosComputadora(this, this.modelo);
	}
}
