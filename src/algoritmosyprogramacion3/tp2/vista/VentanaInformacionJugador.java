package algoritmosyprogramacion3.tp2.vista;

import java.util.Observable;
import java.util.Observer;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VentanaInformacionJugador extends Application implements Observer {

	private JuegoTruco modelo;
	private String nombreJugador;
	private Label etiquetaCantidadPuntos;
	private Label etiquetaCantidadCartas;
	private Scene escena;
	
	public VentanaInformacionJugador(JuegoTruco modelo, String nombreJugador) {
		
		this.modelo = modelo;
		this.modelo.addObserver(this);
		this.nombreJugador = nombreJugador;
		this.initialize();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Informacion jugador");
		stage.setScene(escena);
		stage.show();
	}

	private void initialize() {
		
		GridPane contenedor = new GridPane();
		contenedor.setAlignment(Pos.CENTER);
		contenedor.setPadding(new Insets(10));
		contenedor.setHgap(10);
		contenedor.setVgap(10);
		
		BackgroundFill fondoDeColor = new BackgroundFill(Color.DARKGREEN, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		contenedor.setBackground(new Background(fondoDeColor));
		
		Label etiquetaNombre = new Label("Nombre: ");
		etiquetaNombre.setTextFill(Color.WHITE);
		Label etiquetaPuntos = new Label("Puntos: ");
		etiquetaPuntos.setTextFill(Color.WHITE);
		Label etiquetaCartas = new Label("N° Cartas en mano: ");
		etiquetaCartas.setTextFill(Color.WHITE);
		
		contenedor.add(etiquetaNombre, 0, 0);
		contenedor.add(etiquetaPuntos, 0, 1);
		contenedor.add(etiquetaCartas, 0, 2);
		
		Label etiquetaNombrejugador = new Label(this.nombreJugador);
		etiquetaNombrejugador.setTextFill(Color.WHITE);
		this.etiquetaCantidadPuntos = new Label(this.modelo.mostrarPuntosDeJugador(this.nombreJugador));
		this.etiquetaCantidadPuntos.setTextFill(Color.WHITE);
		this.etiquetaCantidadCartas = new Label(this.modelo.getCantidadCartasEnManoDeJugador(nombreJugador));
		this.etiquetaCantidadCartas.setTextFill(Color.WHITE);
		
		contenedor.add(etiquetaNombrejugador, 1, 0);
		contenedor.add(this.etiquetaCantidadPuntos, 1, 1);
		contenedor.add(this.etiquetaCantidadCartas, 1, 2);
		
		this.escena = new Scene(contenedor, 300, 100);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		this.etiquetaCantidadPuntos.setText(this.modelo.mostrarPuntosDeJugador(this.nombreJugador));
		this.etiquetaCantidadCartas.setText(this.modelo.getCantidadCartasEnManoDeJugador(nombreJugador));
	}
}
