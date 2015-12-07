package algoritmosyprogramacion3.tp2.vista;

import java.util.Observable;
import java.util.Observer;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VistaInformacionJugador extends Application implements Observer {

	private JuegoTruco modelo;
	private String nombreJugador;
	private Label etiquetaCantidadPuntos;
	private Label etiquetaCantidadCartas;
	
	public VistaInformacionJugador(JuegoTruco modelo, String nombreJugador) {
		
		this.modelo = modelo;
		this.nombreJugador = nombreJugador;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		GridPane contenedor = new GridPane();
		contenedor.setAlignment(Pos.CENTER);
		contenedor.setPadding(new Insets(10));
		contenedor.setHgap(10);
		contenedor.setVgap(10);
		
		Label etiquetaNombre = new Label("Nombre: ");
		Label etiquetaPuntos = new Label("Puntos: ");
		Label etiquetaCartas = new Label("N° Cartas en mano: ");
		
		contenedor.add(etiquetaNombre, 0, 0);
		contenedor.add(etiquetaPuntos, 0, 1);
		contenedor.add(etiquetaCartas, 0, 2);
		
		Label etiquetaNombrejugador = new Label(this.nombreJugador);
		this.etiquetaCantidadPuntos = new Label(this.modelo.mostrarPuntosDeJugador(this.nombreJugador));
		this.etiquetaCantidadCartas = new Label(this.modelo.getCantidadCartasEnManoDeJugador(nombreJugador));
		
		contenedor.add(etiquetaNombrejugador, 1, 0);
		contenedor.add(this.etiquetaCantidadPuntos, 1, 1);
		contenedor.add(this.etiquetaCantidadCartas, 1, 2);
		
		Scene escena = new Scene(contenedor, 300, 100);
		
		stage.setTitle("Informacion jugador");
		stage.setScene(escena);
		stage.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		
		this.etiquetaCantidadPuntos.setText(this.modelo.mostrarPuntosDeJugador(this.nombreJugador));
		this.etiquetaCantidadCartas.setText(this.modelo.getCantidadCartasEnManoDeJugador(nombreJugador));
	}
}
