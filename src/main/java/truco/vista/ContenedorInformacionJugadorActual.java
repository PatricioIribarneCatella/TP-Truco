package truco.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import truco.modelo.JuegoTruco;

public class ContenedorInformacionJugadorActual extends HBox {

	private VistaJuegoDeTruco vista;
	private JuegoTruco modelo;
	private Label etiquetaNombreJugador;
	private Label etiquetaPuntosJugador;
	
	public ContenedorInformacionJugadorActual(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.initialize();
	}
	
	private void initialize() {
		
		this.setConfiguracion();
		this.setElementos();
	}

	private void setConfiguracion() {
		
		this.setSpacing(250);
		this.setPadding(new Insets(20));
		this.setAlignment(Pos.TOP_CENTER);
	}

	private void setElementos() {
		
		this.etiquetaNombreJugador = new Label("Nombre: " + this.modelo.getNombreJugadorConTurno());
		this.etiquetaNombreJugador.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.etiquetaNombreJugador.setTextFill(Color.WHITE);
		
		this.etiquetaPuntosJugador = new Label("Puntos: " + this.modelo.mostrarPuntosDeJugador(this.modelo.getNombreJugadorConTurno()));
		this.etiquetaPuntosJugador.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
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
			
			VistaEleccionJuego nuevaVista = new VistaEleccionJuego(this.vista);
			nuevaVista.mostrar();
		});
		
		this.getChildren().addAll(contenedorEtiquetasJugador, botonVolverAlMenu);
	}
	
	public void setTextoNombreJugador(String nombrejugador) {
		this.etiquetaNombreJugador.setText(nombrejugador);
	}

	public void setTextoPuntosJugador(String puntos) {
		this.etiquetaPuntosJugador.setText(puntos);
	}
}
