package algoritmosyprogramacion3.tp2.vista;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.JugadorSinFlorException;
import algoritmosyprogramacion3.tp2.excepciones.PartidaSinFlorException;
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

public abstract class VistaJuegoDeTruco implements Vista, Observer {

	protected JuegoTruco modelo;
	protected Stage stage;
	protected Scene escena;
	protected BorderPane contenedor;
	protected HBox contenedorCartasJugadas;
	protected VBox contenedorInformacionJugadores;
	private Label etiquetaDatos;
	private GraficadorCartas graficadorCartas;
	protected Vista vistaAnterior;
	protected Label etiquetaNombreJugador;
	protected Label etiquetaPuntosJugador;
	protected VBox contenedorBotones;
	
	public VistaJuegoDeTruco(Vista vistaAnterior) {
		
		this.vistaAnterior = vistaAnterior;
		this.modelo = vistaAnterior.getModelo();
		this.stage = vistaAnterior.getStage();
		this.graficadorCartas = new GraficadorCartas();
		this.etiquetaDatos = new Label();
		this.modelo.addObserver(this);
		this.initialize();
	}
	
	private void initialize() {
		
		this.contenedor = new BorderPane();
		
		this.setContenedorPrincipal();
		
		this.setImagenDeFondo();
		
		this.modelo.repartirCartas();
		
		this.setCaracteristicasAlContenedorPrincipal();
		
		this.escena = new Scene(this.contenedor, 1300, 700);
	}
	
	private void setContenedorPrincipal() {
		
		this.contenedor.setPadding(new Insets(25));
	}

	private void setImagenDeFondo() {
		
		Image imagen = new Image("file:resources/imagenes/fondos/fondo-verde.jpg", 1300, 700, false, true);
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		this.contenedor.setBackground(new Background(imagenDeFondo));
	}
	
	protected void setMensajeInformacion(String mensaje) {
		
		this.etiquetaDatos.setText(mensaje);
		this.etiquetaDatos.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		this.etiquetaDatos.setTextFill(Color.web("#FFFFFF"));
	}
	
	private void setCaracteristicasAlContenedorCentro() {
		
		this.contenedorCartasJugadas = new HBox();
		this.contenedorCartasJugadas.setSpacing(80);
		this.contenedorCartasJugadas.setPadding(new Insets(20));
		this.contenedorCartasJugadas.setAlignment(Pos.CENTER);
		this.contenedor.setCenter(this.contenedorCartasJugadas);
	}
	
	private void setCaracteristicasAlContenedorDerecho() {
		
		// faltan hacer los cuadros donde se muestra la informacion de los jugadores
		
		this.contenedorInformacionJugadores = new VBox();
		this.contenedorInformacionJugadores.setSpacing(30);
		this.contenedorInformacionJugadores.setPadding(new Insets(20));
		this.contenedorInformacionJugadores.setAlignment(Pos.CENTER);
		this.contenedor.setRight(this.contenedorInformacionJugadores);
	}
	
	protected abstract void setBotonTerminarTurno();
	
	private void setCaracteristicasAlContenedorIzquierdo() {
		
		Button botonTruco = new Button("Truco");
		botonTruco.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonTruco.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonTruco = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonTruco.setBackground(new Background(fondoDeColorBotonTruco));
		
		botonTruco.setOnAction(e -> {
		
			try {
				this.modelo.cantarTrucoPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Truco cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Truco en este momento");
			}
		});
		
		Button botonReTruco = new Button("Re-Truco");
		botonReTruco.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonReTruco.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonReTruco = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonReTruco.setBackground(new Background(fondoDeColorBotonReTruco));
		
		botonReTruco.setOnAction(e -> {
			
			try {
				
				this.modelo.cantarReTrucoPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Re-Truco cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Re-Truco en este momento");
			}
		});
		
		Button botonValeCuatro = new Button("Vale Cuatro");
		botonValeCuatro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonValeCuatro.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonValeCuatro = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonValeCuatro.setBackground(new Background(fondoDeColorBotonValeCuatro));
		
		botonValeCuatro.setOnAction(e -> {
			
			try {
				
				this.modelo.cantarValeCuatroPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Vale cuatro cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Vale cuatro en este momento");
			}
		});
		
		Button botonEnvido = new Button("Envido");
		botonEnvido.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonEnvido.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonEnvido = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonEnvido.setBackground(new Background(fondoDeColorBotonEnvido));
		
		botonEnvido.setOnAction(e -> {
			
			try {
				
				this.modelo.cantarEnvidoPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Envido cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Envido en este momento");
			}
		});
		
		Button botonRealEnvido = new Button("Real Envido");
		botonRealEnvido.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonRealEnvido.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonRealEnvido = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonRealEnvido.setBackground(new Background(fondoDeColorBotonRealEnvido));
		
		botonRealEnvido.setOnAction(e -> {
			
			try {
				
				this.modelo.cantarRealEnvidoPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Real Envido cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Real Envido en este momento");
			}
		});
		
		Button botonFaltaEnvido = new Button("Falta Envido");
		botonFaltaEnvido.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonFaltaEnvido.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonFaltaEnvido = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonFaltaEnvido.setBackground(new Background(fondoDeColorBotonFaltaEnvido));
		
		botonFaltaEnvido.setOnAction(e -> {
			
			try {
				
				this.modelo.cantarFaltaEnvidoPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Falta Envido cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Falta Envido en este momento");
			}
		});
		
		Button botonFlor = new Button("Flor");
		botonFlor.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonFlor.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonFlor = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonFlor.setBackground(new Background(fondoDeColorBotonFlor));
		
		botonFlor.setOnAction(e -> {
			
			try {
				
				this.setMensajeInformacion("Flor cantada");
				this.modelo.cantarFlorPorJugador(this.modelo.getNombreJugadorActual());
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Flor en este momento");
				
			} catch (PartidaSinFlorException ex) {
				
				this.setMensajeInformacion("La partida se está jugando sin Flor");
				
			} catch (JugadorSinFlorException ex) {
				
				this.setMensajeInformacion("No posee tres cartas del mismo palo");
			}
		});
		
		this.setBotonTerminarTurno();
		
		this.contenedorBotones = new VBox(botonTruco, botonReTruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor);
		this.contenedorBotones.setSpacing(15);
		this.contenedorBotones.setPadding(new Insets(20));
		this.contenedorBotones.setAlignment(Pos.CENTER);
		this.contenedor.setLeft(this.contenedorBotones);
	}

	private void setCaracteristicasAlContenedorSuperior() {
		
		this.etiquetaNombreJugador = new Label("Nombre: " + this.modelo.getNombreJugadorActual());
		this.etiquetaNombreJugador.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		this.etiquetaNombreJugador.setTextFill(Color.WHITE);
		
		this.etiquetaPuntosJugador = new Label("Puntos: " + this.modelo.mostrarPuntosDeJugador(this.modelo.getNombreJugadorActual()));
		this.etiquetaPuntosJugador.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		this.etiquetaPuntosJugador.setTextFill(Color.WHITE);
		
		HBox contenedorEtiquetasJugador = new HBox(this.etiquetaNombreJugador, this.etiquetaPuntosJugador);
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
			botonCarta.setContentDisplay(ContentDisplay.CENTER);
			
			botonCarta.setOnAction(e -> {
				// se va de la mano del jugador y aparece en el centro de la pantalla
			});
			
			contenedorCartas.getChildren().add(botonCarta);
		}
		
		VBox contenedorInferior = new VBox(this.etiquetaDatos, contenedorCartas);
		contenedorInferior.setSpacing(10);
		contenedorInferior.setPadding(new Insets(10));
		contenedorInferior.setAlignment(Pos.CENTER);
		this.contenedor.setBottom(contenedorInferior);
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
		
		this.etiquetaDatos.setText("");
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

	@Override
	public void update(Observable o, Object arg) {
		
		this.etiquetaNombreJugador.setText("Nombre: " + this.modelo.getNombreJugadorActual());
		this.etiquetaPuntosJugador.setText("Puntos: " + this.modelo.mostrarPuntosDeJugador(this.modelo.getNombreJugadorActual()));
		// faltan actualizar los cuadors de informacion de los jugadores
	}
}
