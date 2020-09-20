package truco.vista;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import truco.excepciones.AccionInvalidaException;
import truco.excepciones.TurnoEquivocadoException;
import truco.modelo.Carta;
import truco.modelo.JuegoTruco;
import truco.utilitarios.GraficadorCartas;
import truco.utilitarios.Situacion;

public abstract class ContenedorCartas extends HBox {

	protected VistaJuegoDeTruco vista;
	protected JuegoTruco modelo;
	private GraficadorCartas graficadorCartas;
	
	public ContenedorCartas(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.graficadorCartas = new GraficadorCartas();
		this.initialize();
	}
	
	private void initialize() {
		
		this.setConfiguracion();
		this.setElementos();
	}

	private void setConfiguracion() {
		
		this.setSpacing(15);
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
	}
	
	private void setElementos() {
		
		String nombreJugador = this.modelo.getNombreJugadorConTurno();
		List<Carta> listaCartas = this.modelo.getCartasJugador(nombreJugador);
		
		if (!listaCartas.isEmpty()) {
			
	 		this.graficarCartas(nombreJugador, listaCartas);
	 		
		} else {
			
			Label etiqueta = new Label("(Pulse el mazo para repartir las cartas y comenzar la partida)");
			etiqueta.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			etiqueta.setTextFill(Color.WHITE);
			this.getChildren().add(etiqueta);
		}
	}
	
	private Image getImagenCarta(Carta carta) {
		
		Imagen imagen = this.graficadorCartas.getImagen(carta);
		return new Image(imagen.getUrl(), imagen.getWidth(), imagen.getHeigth(), imagen.getPreserveRatio(), imagen.getSmooth());
	}

	public abstract void cambiarTurno(String nombreJugador, VBox botones);
	
	protected abstract void mostrarInformacionJugada();
	
	public void graficarCartas(String nombreJugador, List<Carta> cartas) {
		
		this.getChildren().clear();
		
		for (Carta carta : cartas) {
			
			Button botonCarta = new Button();
			botonCarta.setGraphic(new ImageView(this.getImagenCarta(carta)));
			botonCarta.setDefaultButton(true);
			botonCarta.setContentDisplay(ContentDisplay.CENTER);
			
			this.getChildren().add(botonCarta);
			
			botonCarta.setOnMouseEntered(e -> {
				
				botonCarta.setScaleX(1.3);
				botonCarta.setScaleY(1.3);
			});
			
			botonCarta.setOnMouseExited(e -> {
				
				botonCarta.setScaleX(1);
				botonCarta.setScaleY(1);
			});
			
			botonCarta.setOnAction(e -> {
				
				try {
				
					this.getChildren().remove(botonCarta);
					
					this.vista.graficarCartaJugada(carta, nombreJugador);
					
					this.modelo.jugarCartaDeJugador(nombreJugador, carta);
					
					this.vista.setSituacionActual(Situacion.situacionCartaJugada(vista));
					
					this.mostrarInformacionJugada();
					
					this.cambiarTurno(this.modelo.getNombreJugadorConTurno(), this.vista.getSituacionActual().getBotones());
					
				} catch (AccionInvalidaException ex) {
					
					this.vista.setMensajeInformacion("No es el momento de jugar una carta, pruebe otra acción");
					
				} catch (TurnoEquivocadoException ex) {
					
					this.vista.setMensajeInformacion("No es su turno");	
				}
			});
		}
	}
}
