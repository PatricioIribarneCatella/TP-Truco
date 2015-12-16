package algoritmosyprogramacion3.tp2.vista;

import java.util.List;

import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.utilitarios.GraficadorCartas;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public abstract class VistaJuegoDeTruco implements Vista {

	protected JuegoTruco modelo;
	protected Stage stage;
	protected Scene escena;
	protected BorderPane contenedor;
	private Label etiquetaDatos;
	private GraficadorCartas graficadorCartas;
	protected Label etiquetaNombreJugador;
	protected Label etiquetaPuntosJugador;
	protected ContenedorCartasJugadas contenedorCartasJugadas;
	protected ContenedorInformacionJugadoresYMazo contenedorInformacionJugadores;
	protected ContenedorAccionesCantos contenedorBotones;
	protected ContenedorCartas contenedorCartas;
	private ContenedorInformacionJugadorActual contenedorSuperior;
	protected Vista vistaAnterior;

	
	public VistaJuegoDeTruco(Vista vistaAnterior) {
		
		this.vistaAnterior = vistaAnterior;
		this.modelo = vistaAnterior.getModelo();
		this.stage = vistaAnterior.getStage();
		this.graficadorCartas = new GraficadorCartas();
		this.etiquetaDatos = new Label();
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
	
	public void setMensajeInformacion(String mensaje) {
		
		this.etiquetaDatos.setText(mensaje);
		this.etiquetaDatos.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		this.etiquetaDatos.setTextFill(Color.web("#FFFFFF"));
	}
	
	protected Image getImagenCarta(Carta carta) {
		
		Imagen imagen = this.graficadorCartas.getImagen(carta);
		return new Image(imagen.getUrl(), imagen.getWidth(), imagen.getHeigth(), imagen.getPreserveRatio(), imagen.getSmooth());
	}
	
	private void setCaracteristicasAlContenedorCentro() {
		
		this.contenedorCartasJugadas = new ContenedorCartasJugadas(this.modelo);
		
		this.contenedor.setCenter(this.contenedorCartasJugadas);
	}
	
	protected abstract void setCaracteristicasAlContenedorInformacionJugadores();
	
	private void setCaracteristicasAlContenedorDerecho() {
		
		this.setCaracteristicasAlContenedorInformacionJugadores();
		
		this.contenedor.setRight(this.contenedorInformacionJugadores);
	}
	
	private void setCaracteristicasAlContenedorIzquierdo() {
		
		this.contenedorBotones = new ContenedorAccionesCantos(this, this.modelo);
		this.contenedor.setLeft(this.contenedorBotones);
	}

	private void setCaracteristicasAlContenedorSuperior() {
				
		this.contenedorSuperior = new ContenedorInformacionJugadorActual(this, this.modelo);
		this.contenedor.setTop(contenedorSuperior);
	}
	
	protected abstract void setCaracteristicasAlContenedorCartas();
	
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

	public void setTextoNombreJugador(String nombreJugador) {
		// TODO Auto-generated method stub
		
	}

	public void setTextoPuntosJugador(String puntos) {
		// TODO Auto-generated method stub
		
	}
	
	public void graficarCartas(String nombreJugador, List<Carta> cartas) {
		
		this.contenedorCartas.graficarCartas(nombreJugador, cartas);
	}
	
	public void graficarCartaJugada(Carta carta, String nombreJugador) {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionTruco() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionReTruco() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionValeCuatro() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionFlor() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionEnvido() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionFaltaEnvido() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionRealEnvido() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionTrucoAceptado() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionReTrucoAceptado() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionValeCuatroAceptado() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionEnvidoAceptada() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionFlorAceptada() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionFaltaEnvidoAceptada() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionRealEnvidoAceptada() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionFlorRechazada() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionVarianteEnvidoRechazada() {
		// TODO Auto-generated method stub
		
	}

	public void graficarSituacionVarianteTrucoRechazada() {
		// TODO Auto-generated method stub
		
	}
}
