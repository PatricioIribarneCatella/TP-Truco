package algoritmosyprogramacion3.tp2.vista;

import java.util.List;

import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VistaJuegoDeTruco implements Vista {

	protected JuegoTruco modelo;
	protected Stage stage;
	protected Scene escena;
	protected BorderPane contenedor;
	protected HBox contenedorCartasJugadas;
	protected VBox contenedorInformacionJugadores;
	private Label etiquetaDatosInvalidos;
	private GraficadorCartas graficadorCartas;
	protected Vista vistaAnterior;
	
	public VistaJuegoDeTruco(Vista vistaAnterior) {
		
		this.vistaAnterior = vistaAnterior;
		this.modelo = vistaAnterior.getModelo();
		this.stage = vistaAnterior.getStage();
		this.graficadorCartas = new GraficadorCartas();
		this.initialize();
	}
	
	private void initialize() {
		
		this.contenedor = new BorderPane();
		
		this.setContenedorPrincipal();
		
		this.setImagenDeFondo();
		
		this.setCaracteristicasAlContenedorPrincipal();
		
		this.modelo.repartirCartas();
		
		this.escena = new Scene(this.contenedor, 1000, 600);
	}
	
	private void setContenedorPrincipal() {
		
		this.contenedor.setPadding(new Insets(25));
	}

	private void setImagenDeFondo() {
		
		Image imagen = new Image("file:resources/imagenes/fondos/fondo-verde.jpg", 1000, 600, false, true);
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		this.contenedor.setBackground(new Background(imagenDeFondo));
	}
	
	protected void setMensajeInformacionInvalida(String mensaje) {
		
		this.etiquetaDatosInvalidos.setText(mensaje);
		this.etiquetaDatosInvalidos.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.etiquetaDatosInvalidos.setTextFill(Color.web("#FF0000"));
	}
	
	private void setCaracteristicasAlContenedorCentro() {
		
		this.contenedorCartasJugadas = new HBox();
		this.contenedorCartasJugadas.setSpacing(80);
		this.contenedorCartasJugadas.setPadding(new Insets(20));
		this.contenedorCartasJugadas.setAlignment(Pos.CENTER);
		this.contenedor.setCenter(this.contenedorCartasJugadas);
	}
	
	private void setCaracteristicasAlContenedorDerecho() {
		
		this.contenedorInformacionJugadores = new VBox();
		this.contenedorInformacionJugadores.setSpacing(30);
		this.contenedorInformacionJugadores.setPadding(new Insets(20));
		this.contenedorInformacionJugadores.setAlignment(Pos.CENTER);
		this.contenedor.setRight(this.contenedorInformacionJugadores);
	}
	
	private void setCaracteristicasAlContenedorIzquierdo() {
		
		// faltan los manejadores
		
		Button botonTruco = new Button("Truco");
		botonTruco.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonTruco.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonTruco = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonTruco.setBackground(new Background(fondoDeColorBotonTruco));
		
		
		Button botonReTruco = new Button("Re Truco");
		botonReTruco.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonReTruco.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonReTruco = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonReTruco.setBackground(new Background(fondoDeColorBotonReTruco));
		
		
		Button botonValeCuatro = new Button("Vale Cuatro");
		botonValeCuatro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonValeCuatro.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonValeCuatro = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonValeCuatro.setBackground(new Background(fondoDeColorBotonValeCuatro));
		
		
		Button botonEnvido = new Button("Envido");
		botonEnvido.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonEnvido.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonEnvido = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonEnvido.setBackground(new Background(fondoDeColorBotonEnvido));
		
		
		Button botonRealEnvido = new Button("Real Envido");
		botonRealEnvido.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonRealEnvido.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonRealEnvido = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonRealEnvido.setBackground(new Background(fondoDeColorBotonRealEnvido));
		
		
		Button botonFaltaEnvido = new Button("Falta Envido");
		botonFaltaEnvido.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonFaltaEnvido.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonFaltaEnvido = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonFaltaEnvido.setBackground(new Background(fondoDeColorBotonFaltaEnvido));
		
		
		Button botonFlor = new Button("Flor");
		botonFlor.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonFlor.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonFlor = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonFlor.setBackground(new Background(fondoDeColorBotonFlor));
		
		
		Button botonTerminarTurno = new Button("Terminar turno");
		botonTerminarTurno.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonTerminarTurno.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonTerminarTurno = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonTerminarTurno.setBackground(new Background(fondoDeColorBotonTerminarTurno));
		
		
		VBox contenedorBotones = new VBox(botonTruco, botonReTruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonTerminarTurno);
		contenedorBotones.setSpacing(15);
		contenedorBotones.setPadding(new Insets(20));
		contenedorBotones.setAlignment(Pos.CENTER);
		this.contenedor.setLeft(contenedorBotones);
	}

	private void setCaracteristicasAlContenedorSuperior() {
		
		Label etiquetaNombreJugador = new Label("Nombre: " + this.modelo.getNombreJugadorActual());
		etiquetaNombreJugador.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		etiquetaNombreJugador.setTextFill(Color.WHITE);
		
		Label etiquetaPuntosJugador = new Label("Puntos: " + this.modelo.mostrarPuntosDeJugador(this.modelo.getNombreJugadorActual()));
		etiquetaPuntosJugador.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		etiquetaPuntosJugador.setTextFill(Color.WHITE);
		
		HBox contenedorEtiquetasJugador = new HBox(etiquetaNombreJugador, etiquetaPuntosJugador);
		contenedorEtiquetasJugador.setSpacing(15);
		contenedorEtiquetasJugador.setPadding(new Insets(10));
		
		Button botonVolverAlMenu = new Button("Volver al menu principal");
		botonVolverAlMenu.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		botonVolverAlMenu.setTextFill(Color.BLACK);
		
		BackgroundFill fondoDeColorBotonVolverAlMenu = new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonVolverAlMenu.setBackground(new Background(fondoDeColorBotonVolverAlMenu));
		
		botonVolverAlMenu.setOnAction(e -> {
			
			VistaEleccionJuego nuevaVista = new VistaEleccionJuego(this);
			nuevaVista.mostrar();
		});
		
		HBox contenedorSuperior = new HBox(contenedorEtiquetasJugador, botonVolverAlMenu);
		contenedorSuperior.setSpacing(250);
		contenedorSuperior.setPadding(new Insets(20));
		contenedorSuperior.setAlignment(Pos.TOP_CENTER);
		this.contenedor.setTop(contenedorSuperior);
	}
	
	private void setCaracteristicasAlContenedorInferior() {
		
		HBox contenedorCartas = new HBox();
		contenedorCartas.setSpacing(15);
		contenedorCartas.setPadding(new Insets(10));
		contenedorCartas.setAlignment(Pos.CENTER);
		
		List<Carta> listaCartas = this.modelo.getCartasJugadorConTurno();
		
		for (Carta carta : listaCartas) {
			
			Imagen imagen = this.graficadorCartas.getImagen(carta);
			
			Image imagenCarta = new Image(imagen.getUrl(), imagen.getWidth(), imagen.getHeigth(), imagen.getPreserveRatio(), imagen.getSmooth());
			
			Button botonCarta = new Button();
			botonCarta.setGraphic(new ImageView(imagenCarta));
			botonCarta.setDefaultButton(true);
			botonCarta.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			
			contenedorCartas.getChildren().add(botonCarta);
		}
		
		this.contenedor.setBottom(contenedorCartas);
	}

	private void setCaracteristicasAlContenedorPrincipal() {
		
		this.setCaracteristicasAlContenedorSuperior();
		this.setCaracteristicasAlContenedorInferior();
		this.setCaracteristicasAlContenedorCentro();
		this.setCaracteristicasAlContenedorDerecho();
		this.setCaracteristicasAlContenedorIzquierdo();
	}

	@Override
	public void mostrar() {
		
		//this.etiquetaDatosInvalidos.setText("");
		this.stage.setTitle("FonTruco");
		this.stage.setScene(this.escena);
		this.stage.show();
	}

	public Vista getVistaAnterior() {
		return this.vistaAnterior;
	}
	
	@Override
	public Stage getStage() {
		return this.stage;
	}

	@Override
	public JuegoTruco getModelo() {
		return this.modelo;
	}

	@Override
	public void setModelo(JuegoTruco modelo) {
		this.modelo = modelo;
	}
}
