package algoritmosyprogramacion3.tp2.vista;

import java.util.Set;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Ventana {

	protected GridPane contenedor;
	protected JuegoTruco modelo;
	private VistaJuegoDeTruco vista;
	private Scene escena;
	private Stage stage;
	
	public Ventana(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		
		this.vista = vista;
		this.modelo = modelo;
		this.stage = new Stage();
		this.initialize();
	}
	
	private void initialize() {
		
		contenedor = new GridPane();
		contenedor.setAlignment(Pos.CENTER);
		contenedor.setPadding(new Insets(10));
		contenedor.setHgap(10);
		contenedor.setVgap(10);
		
		BackgroundFill fondoDeColor = new BackgroundFill(Color.DARKGREEN, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		contenedor.setBackground(new Background(fondoDeColor));
		
		Text textoEscena = new Text(this.getTextoEscena());
		textoEscena.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		contenedor.add(textoEscena, 0, 0, 2, 1);
		
		Set<String> nombres = this.getNombresJugadoresGanadores();
		
		StringBuilder texto = new StringBuilder();
		
		for (String nombre : nombres) {
			texto.append(nombre);
			texto.append(" ");
		}
		
		Label etiquetaNombre = new Label("Equipo compuesto por: " + texto.toString());
		etiquetaNombre.setTextFill(Color.WHITE);
		Label etiquetaPuntosGanados = new Label("Puntos ganados: " + this.getPuntajeAcumulado());
		etiquetaPuntosGanados.setTextFill(Color.WHITE);
		
		contenedor.add(etiquetaNombre, 0, 1);
		contenedor.add(etiquetaPuntosGanados, 0, 3);
		
		Label etiquetaContinuar = new Label(this.getInformacionParaSeguirJugando());
		etiquetaContinuar.setTextFill(Color.GRAY);
		
		contenedor.add(etiquetaContinuar, 0, 5);
		etiquetaContinuar.setTextFill(Color.WHITE);
		etiquetaContinuar.setWrapText(true);
		
		Button botonAceptar = new Button("Aceptar");
		
		botonAceptar.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		botonAceptar.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonInformacion = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonAceptar.setBackground(new Background(fondoDeColorBotonInformacion));
		
		botonAceptar.setOnMouseEntered(e1 -> {
			
			botonAceptar.setScaleX(1.2);
			botonAceptar.setScaleY(1.2);
		});
		
		botonAceptar.setOnMouseExited(e2 -> {
			
			botonAceptar.setScaleX(1);
			botonAceptar.setScaleY(1);
		});
		
		botonAceptar.setOnAction(e -> {
			
			this.vista.setMensajeInformacion("");
			this.stage.close();
		});
		
		contenedor.add(botonAceptar, 0, 7);
		
		this.escena = new Scene(contenedor, 600, 400);
	}
	
	protected abstract String getTextoEscena();
	
	protected abstract Set<String> getNombresJugadoresGanadores();
	
	protected abstract String getPuntajeAcumulado();
	
	protected abstract String getInformacionParaSeguirJugando();
	
	public void mostrar() {
		
		this.stage.setScene(this.escena);
		this.stage.show();
	}
}
