package algoritmosyprogramacion3.tp2.vista;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.excepciones.CartaYaJugadaException;
import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.JugadorSinFlorException;
import algoritmosyprogramacion3.tp2.excepciones.PartidaSinFlorException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
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
	protected HBox contenedorCartas;
	
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
	
	private Image getImagenCarta(Carta carta) {
		
		Imagen imagen = this.graficadorCartas.getImagen(carta);
		return new Image(imagen.getUrl(), imagen.getWidth(), imagen.getHeigth(), imagen.getPreserveRatio(), imagen.getSmooth());
	}
	
	private void graficarCartas(List<Carta> cartas) {
		
		Button botonCarta1 = new Button();
		botonCarta1.setGraphic(new ImageView(this.getImagenCarta(cartas.get(0))));
		botonCarta1.setDefaultButton(true);
		botonCarta1.setContentDisplay(ContentDisplay.CENTER);
		
		this.contenedorCartas.getChildren().add(botonCarta1);
		
		botonCarta1.setOnMouseEntered(e -> {
			
			botonCarta1.setScaleX(1.3);
			botonCarta1.setScaleY(1.3);
		});
		
		botonCarta1.setOnMouseExited(e -> {
			
			botonCarta1.setScaleX(1);
			botonCarta1.setScaleY(1);
		});
		
		botonCarta1.setOnAction(e -> {
			
			try {
			
				this.modelo.jugarPrimerCartaDeJugador(this.modelo.getNombreJugadorActual());
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No es el momento de jugar una carta, pruebe otra acción");
				
			} catch (TurnoEquivocadoException ex) {
				
				this.setMensajeInformacion("No es su turno");
				
			} catch (CartaYaJugadaException ex) {
				
				this.setMensajeInformacion("Esta carta ya ha sido jugada, intente jugar otra");
			}
			
			this.contenedorCartas.getChildren().remove(botonCarta1);
			Label etiquetaCarta = new Label();
			etiquetaCarta.setGraphic(new ImageView(this.getImagenCarta(cartas.get(0))));
			this.contenedorCartasJugadas.getChildren().add(etiquetaCarta);
		});
		
		Button botonCarta2 = new Button();
		botonCarta2.setGraphic(new ImageView(this.getImagenCarta(cartas.get(1))));
		botonCarta2.setDefaultButton(true);
		botonCarta2.setContentDisplay(ContentDisplay.CENTER);
		
		this.contenedorCartas.getChildren().add(botonCarta2);
		
		botonCarta2.setOnMouseEntered(e -> {
			
			botonCarta2.setScaleX(1.3);
			botonCarta2.setScaleY(1.3);
		});
		
		botonCarta2.setOnMouseExited(e -> {
			
			botonCarta2.setScaleX(1);
			botonCarta2.setScaleY(1);
		});
		
		botonCarta2.setOnAction(e -> {
			
			try {
				
				this.modelo.jugarSegundaCartaDeJugador(this.modelo.getNombreJugadorActual());
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No es el momento de jugar una carta, pruebe otra acción");
				
			} catch (TurnoEquivocadoException ex) {
				
				this.setMensajeInformacion("No es su turno");
				
			} catch (CartaYaJugadaException ex) {
				
				this.setMensajeInformacion("Esta carta ya ha sido jugada, intente jugar otra");
			}
			
			this.contenedorCartas.getChildren().remove(botonCarta2);
			Label etiquetaCarta = new Label();
			etiquetaCarta.setGraphic(new ImageView(this.getImagenCarta(cartas.get(1))));
			this.contenedorCartasJugadas.getChildren().add(etiquetaCarta);
		});
		
		Button botonCarta3 = new Button();
		botonCarta3.setGraphic(new ImageView(this.getImagenCarta(cartas.get(2))));
		botonCarta3.setDefaultButton(true);
		botonCarta3.setContentDisplay(ContentDisplay.CENTER);
		
		this.contenedorCartas.getChildren().add(botonCarta3);
		
		botonCarta3.setOnMouseEntered(e -> {
			
			botonCarta3.setScaleX(1.3);
			botonCarta3.setScaleY(1.3);
		});
		
		botonCarta3.setOnMouseExited(e -> {
			
			botonCarta3.setScaleX(1);
			botonCarta3.setScaleY(1);
		});
		
		botonCarta3.setOnAction(e -> {
			
			try {
				
				this.modelo.jugarTercerCartaDeJugador(this.modelo.getNombreJugadorActual());
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No es el momento de jugar una carta, pruebe otra acción");
				
			} catch (TurnoEquivocadoException ex) {
				
				this.setMensajeInformacion("No es su turno");
				
			} catch (CartaYaJugadaException ex) {
				
				this.setMensajeInformacion("Esta carta ya ha sido jugada, intente jugar otra");
			}
			
			this.contenedorCartas.getChildren().remove(botonCarta3);
			Label etiquetaCarta = new Label();
			etiquetaCarta.setGraphic(new ImageView(this.getImagenCarta(cartas.get(2))));
			this.contenedorCartasJugadas.getChildren().add(etiquetaCarta);
		});
	}
	
	private void setCaracteristicasAlContenedorCentro() {
		
		this.contenedorCartasJugadas = new HBox();
		this.contenedorCartasJugadas.setSpacing(30);
		this.contenedorCartasJugadas.setPadding(new Insets(10));
		this.contenedorCartasJugadas.setAlignment(Pos.CENTER);
		this.contenedor.setCenter(this.contenedorCartasJugadas);
	}
	
	protected abstract void setCaracteristicasAlContenedorInformacionJugadores();
	
	private void setCaracteristicasAlContenedorDerecho() {
		
		this.contenedorInformacionJugadores = new VBox();
		this.contenedorInformacionJugadores.setSpacing(10);
		this.contenedorInformacionJugadores.setPadding(new Insets(10));
		this.contenedorInformacionJugadores.setAlignment(Pos.TOP_CENTER);
		
		this.setCaracteristicasAlContenedorInformacionJugadores();
		
		Button botonRepartirCartas = new Button();
		
		Image imagenCartaReverso = new Image("file:resources/imagenes/cartas/naipes.PNG", 75, 150, false, true);
		botonRepartirCartas.setGraphic(new ImageView(imagenCartaReverso));
		botonRepartirCartas.setDefaultButton(true);
		botonRepartirCartas.setContentDisplay(ContentDisplay.CENTER);
		
		botonRepartirCartas.setTooltip(new Tooltip("Reparte cartas"));
		
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
		});
		
		this.contenedorInformacionJugadores.getChildren().add(botonRepartirCartas);
		
		this.contenedor.setRight(this.contenedorInformacionJugadores);
	}
	
	protected abstract void setBotonTerminarTurno();
	
	private void setCaracteristicasAlContenedorIzquierdo() {
		
		this.contenedorBotones = new VBox();
		
		Button botonTruco = new Button("Truco");
		botonTruco.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonTruco.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonTruco = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonTruco.setBackground(new Background(fondoDeColorBotonTruco));
		
		botonTruco.setOnMouseEntered(e -> {
			
			botonTruco.setScaleX(1.2);
			botonTruco.setScaleY(1.2);
		});
		
		botonTruco.setOnMouseExited(e -> {
			
			botonTruco.setScaleX(1);
			botonTruco.setScaleY(1);
		});
		
		botonTruco.setOnAction(e -> {
		
			try {
				this.modelo.cantarTrucoPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Truco cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Truco en este momento");
				
			} catch (TurnoParaTomarDecisionEquivocadoException ex) {
				
				this.setMensajeInformacion("No es su turno");
			}
		});
		
		Button botonReTruco = new Button("Re-Truco");
		botonReTruco.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonReTruco.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonReTruco = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonReTruco.setBackground(new Background(fondoDeColorBotonReTruco));
		
		botonReTruco.setOnMouseEntered(e -> {
			
			botonReTruco.setScaleX(1.2);
			botonReTruco.setScaleY(1.2);
		});
		
		botonReTruco.setOnMouseExited(e -> {
			
			botonReTruco.setScaleX(1);
			botonReTruco.setScaleY(1);
		});
		
		botonReTruco.setOnAction(e -> {
			
			try {
				
				this.modelo.cantarReTrucoPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Re-Truco cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Re-Truco en este momento");
				
			} catch (TurnoParaTomarDecisionEquivocadoException ex) {
				
				this.setMensajeInformacion("No es su turno");
			}
		});
		
		Button botonValeCuatro = new Button("Vale Cuatro");
		botonValeCuatro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonValeCuatro.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonValeCuatro = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonValeCuatro.setBackground(new Background(fondoDeColorBotonValeCuatro));
		
		botonValeCuatro.setOnMouseEntered(e -> {
			
			botonValeCuatro.setScaleX(1.2);
			botonValeCuatro.setScaleY(1.2);
		});
		
		botonValeCuatro.setOnMouseExited(e -> {
			
			botonValeCuatro.setScaleX(1);
			botonValeCuatro.setScaleY(1);
		});
		
		botonValeCuatro.setOnAction(e -> {
			
			try {
				
				this.modelo.cantarValeCuatroPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Vale cuatro cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Vale cuatro en este momento");
				
			} catch (TurnoParaTomarDecisionEquivocadoException ex) {
				
				this.setMensajeInformacion("No es su turno");
			}
		});
		
		Button botonEnvido = new Button("Envido");
		botonEnvido.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonEnvido.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonEnvido = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonEnvido.setBackground(new Background(fondoDeColorBotonEnvido));
		
		botonEnvido.setOnMouseEntered(e -> {
			
			botonEnvido.setScaleX(1.2);
			botonEnvido.setScaleY(1.2);
		});
		
		botonEnvido.setOnMouseExited(e -> {
			
			botonEnvido.setScaleX(1);
			botonEnvido.setScaleY(1);
		});
		
		botonEnvido.setOnAction(e -> {
			
			try {
				
				this.modelo.cantarEnvidoPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Envido cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Envido en este momento");
				
			} catch (TurnoParaTomarDecisionEquivocadoException ex) {
				
				this.setMensajeInformacion("No es su turno");
			}
		});
		
		Button botonRealEnvido = new Button("Real Envido");
		botonRealEnvido.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonRealEnvido.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonRealEnvido = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonRealEnvido.setBackground(new Background(fondoDeColorBotonRealEnvido));
		
		botonRealEnvido.setOnMouseEntered(e -> {
			
			botonRealEnvido.setScaleX(1.2);
			botonRealEnvido.setScaleY(1.2);
		});
		
		botonRealEnvido.setOnMouseExited(e -> {
			
			botonRealEnvido.setScaleX(1);
			botonRealEnvido.setScaleY(1);
		});
		
		botonRealEnvido.setOnAction(e -> {
			
			try {
				
				this.modelo.cantarRealEnvidoPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Real Envido cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Real Envido en este momento");
				
			} catch (TurnoParaTomarDecisionEquivocadoException ex) {
				
				this.setMensajeInformacion("No es su turno");
			}
		});
		
		Button botonFaltaEnvido = new Button("Falta Envido");
		botonFaltaEnvido.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonFaltaEnvido.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonFaltaEnvido = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonFaltaEnvido.setBackground(new Background(fondoDeColorBotonFaltaEnvido));
		
		botonFaltaEnvido.setOnMouseEntered(e -> {
			
			botonFaltaEnvido.setScaleX(1.2);
			botonFaltaEnvido.setScaleY(1.2);
		});
		
		botonFaltaEnvido.setOnMouseExited(e -> {
			
			botonFaltaEnvido.setScaleX(1);
			botonFaltaEnvido.setScaleY(1);
		});
		
		botonFaltaEnvido.setOnAction(e -> {
			
			try {
				
				this.modelo.cantarFaltaEnvidoPorJugador(this.modelo.getNombreJugadorActual());
				this.setMensajeInformacion("Falta Envido cantado");
				
			} catch (AccionInvalidaException ex) {
				
				this.setMensajeInformacion("No se puede cantar Falta Envido en este momento");
				
			} catch (TurnoParaTomarDecisionEquivocadoException ex) {
				
				this.setMensajeInformacion("No es su turno");
			}
		});
		
		Button botonFlor = new Button("Flor");
		botonFlor.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonFlor.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonFlor = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonFlor.setBackground(new Background(fondoDeColorBotonFlor));
		
		botonFlor.setOnMouseEntered(e -> {
			
			botonFlor.setScaleX(1.2);
			botonFlor.setScaleY(1.2);
		});
		
		botonFlor.setOnMouseExited(e -> {
			
			botonFlor.setScaleX(1);
			botonFlor.setScaleY(1);
		});
		
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
				
			} catch (TurnoParaTomarDecisionEquivocadoException ex) {
				
				this.setMensajeInformacion("No es su turno");
			}
		});
		
		this.contenedorBotones.getChildren().addAll(botonTruco, botonReTruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor);
		this.setBotonTerminarTurno();
		
		this.contenedorBotones.setSpacing(15);
		this.contenedorBotones.setPadding(new Insets(10));
		this.contenedorBotones.setAlignment(Pos.TOP_CENTER);
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
		contenedorEtiquetasJugador.setAlignment(Pos.CENTER_LEFT);
		
		Button botonVolverAlMenu = new Button("Volver al menu principal");
		botonVolverAlMenu.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		botonVolverAlMenu.setTextFill(Color.BLACK);
		
		BackgroundFill fondoDeColorBotonVolverAlMenu = new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonVolverAlMenu.setBackground(new Background(fondoDeColorBotonVolverAlMenu));
		
		botonVolverAlMenu.setOnMouseEntered(e -> {
			
			botonVolverAlMenu.setScaleX(1.2);
			botonVolverAlMenu.setScaleY(1.2);
		});
		
		botonVolverAlMenu.setOnMouseExited(e -> {
			
			botonVolverAlMenu.setScaleX(1);
			botonVolverAlMenu.setScaleY(1);
		});
		
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
	
	private void setCaracteristicasAlContenedorCartas() {
		
		this.contenedorCartas = new HBox();
		this.contenedorCartas.setSpacing(15);
		this.contenedorCartas.setPadding(new Insets(10));
		this.contenedorCartas.setAlignment(Pos.CENTER);
		
		List<Carta> listaCartas = this.modelo.getCartasJugadorConTurno();
		
		if (!listaCartas.isEmpty()) {
			
	 		this.graficarCartas(listaCartas);
		}
	}
	
	private void setCaracteristicasAlContenedorInferior() {
		
		this.setCaracteristicasAlContenedorCartas();
		
		VBox contenedorInferior = new VBox(this.etiquetaDatos, this.contenedorCartas);
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
		this.graficarCartas(this.modelo.getCartasJugadorConTurno());
	}
}
