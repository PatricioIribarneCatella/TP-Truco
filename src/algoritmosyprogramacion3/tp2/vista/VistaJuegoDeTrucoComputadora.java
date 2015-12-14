package algoritmosyprogramacion3.tp2.vista;

import java.util.Observable;
import java.util.Observer;

import algoritmosyprogramacion3.tp2.modelo.PartidaContraComputadora;
import algoritmosyprogramacion3.tp2.modelo.Respuesta;
import algoritmosyprogramacion3.tp2.utilitarios.ObservableComputadora;
import algoritmosyprogramacion3.tp2.utilitarios.ObserverCantos;
import algoritmosyprogramacion3.tp2.utilitarios.ObserverCartas;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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
	protected void setCaracteristicasAlContenedorInformacionJugadores() {
		
		Button botonComputadora = new Button("Información Computadora");
		
		botonComputadora.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonComputadora.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonInformacion = new BackgroundFill(Color.BROWN, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonComputadora.setBackground(new Background(fondoDeColorBotonInformacion));
		
		botonComputadora.setOnMouseEntered(e -> {
			
			botonComputadora.setScaleX(1.2);
			botonComputadora.setScaleY(1.2);
		});
		
		botonComputadora.setOnMouseExited(e -> {
			
			botonComputadora.setScaleX(1);
			botonComputadora.setScaleY(1);
		});
		
		botonComputadora.setOnAction(e -> {
			
			VistaInformacionJugador vista = new VistaInformacionJugador(this.modelo, "Computadora");
			try {
				vista.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		this.contenedorInformacionJugadores.getChildren().add(botonComputadora);
	}

	@Override
	protected void cambiarTurno() {
		// no cambia de turno gráficamente
	}
	
	@Override
	public void updateCarta(ObservableComputadora o, Object arg) {
		
		Label etiqueta = new Label("Coputadora");
		etiqueta.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		etiqueta.setTextFill(Color.WHITE);
		
		etiqueta.setGraphic(new ImageView(this.getImagenCarta(this.modelo.getUltimaCartaJugada("Computadora"))));
		etiqueta.setContentDisplay(ContentDisplay.TOP);
		
		this.contenedorCartasJugadas.getChildren().add(etiqueta);
	}

	@Override
	public void updateCanto(ObservableComputadora o, Object arg) {
		
		Respuesta respuesta = (Respuesta) arg;
		
		if (respuesta.fuePositiva()) {
			
		} else {
			
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		this.etiquetaPuntosJugador.setText("Puntos: " + this.modelo.mostrarPuntosDeJugador(this.partida.getNombreJugador()));
	}
}
