package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.utilitarios.GraficadorBotonesDeCantos;
import algoritmosyprogramacion3.tp2.utilitarios.Situacion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class ContenedorInformacionJugadoresYMazo extends VBox {

	protected VistaJuegoDeTruco vista;
	protected JuegoTruco modelo;
	
	public ContenedorInformacionJugadoresYMazo(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.initialize();
	}
	
	private void initialize() {
		
		this.setConfiguracion();
		this.setElementos();
	}

	private void setConfiguracion() {
		
		this.setSpacing(10);
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.TOP_CENTER);
	}

	protected abstract void setCaracteristicasAlContenedorInformacionJugadores();
	
	private void setElementos() {
		
		this.setCaracteristicasAlContenedorInformacionJugadores();
		
		Button botonRepartirCartas = new Button("Mazo");
		botonRepartirCartas.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		botonRepartirCartas.setTextFill(Color.BLACK);
		
		Image imagenCartaReverso = new Image("file:resources/imagenes/cartas/naipes.PNG", 75, 150, false, true);
		botonRepartirCartas.setGraphic(new ImageView(imagenCartaReverso));
		botonRepartirCartas.setDefaultButton(true);
		botonRepartirCartas.setContentDisplay(ContentDisplay.TOP);
		
		botonRepartirCartas.setTooltip(new Tooltip("Reparte las cartas"));
		
		botonRepartirCartas.setOnMouseEntered(e -> {
			
			botonRepartirCartas.setScaleX(1.1);
			botonRepartirCartas.setScaleY(1.1);
		});
		
		botonRepartirCartas.setOnMouseExited(e -> {
			
			botonRepartirCartas.setScaleX(1);
			botonRepartirCartas.setScaleY(1);
		});
		
		botonRepartirCartas.setOnAction(e -> {
			
			this.modelo.repartirCartas();
			
			String nombreJugador = this.modelo.getNombreJugadorConTurno();
			
			this.vista.limpiarCartasJugadas();
			this.vista.limpiarBotones();
			
			this.vista.setSituacionActual(Situacion.situacionInicial(this.vista));
			this.vista.graficarBotones(GraficadorBotonesDeCantos.graficarSituacionInicial(this.modelo.getPartida(), this.vista));
			this.vista.graficarCartas(nombreJugador, this.modelo.getCartasJugador(nombreJugador));
		});
		
		this.getChildren().add(botonRepartirCartas);
	}
}
