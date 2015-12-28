package algoritmosyprogramacion3.tp2.vista;

import java.util.Observable;
import java.util.Observer;

import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.PartidaContraComputadora;
import algoritmosyprogramacion3.tp2.modelo.Respuesta;
import algoritmosyprogramacion3.tp2.utilitarios.ObservableComputadora;
import algoritmosyprogramacion3.tp2.utilitarios.ObserverCantos;
import algoritmosyprogramacion3.tp2.utilitarios.ObserverCartas;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
		
		Label etiqueta = new Label("Coputadora");
		etiqueta.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		etiqueta.setTextFill(Color.WHITE);
		
		etiqueta.setGraphic(new ImageView(this.getImagenCarta(carta)));
		etiqueta.setContentDisplay(ContentDisplay.TOP);
		
		this.contenedorCartasJugadas.getChildren().add(etiqueta);
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
