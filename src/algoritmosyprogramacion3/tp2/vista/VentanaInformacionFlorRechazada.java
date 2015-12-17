package algoritmosyprogramacion3.tp2.vista;

import java.util.Set;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.application.Application;
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

public class VentanaInformacionFlorRechazada extends Application {

	private JuegoTruco modelo;
	private VistaJuegoDeTruco vista;
	private Scene escena;
	private Stage stage;
	
	public VentanaInformacionFlorRechazada(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		
		this.vista = vista;
		this.modelo = modelo;
		this.initialize();
	}

	private void initialize() {
		
		GridPane contenedor = new GridPane();
		contenedor.setAlignment(Pos.CENTER);
		contenedor.setPadding(new Insets(10));
		contenedor.setHgap(10);
		contenedor.setVgap(10);
		
		BackgroundFill fondoDeColor = new BackgroundFill(Color.DARKGREEN, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		contenedor.setBackground(new Background(fondoDeColor));
		
		Text textoEscena = new Text("Flor rechazada");
		textoEscena.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		contenedor.add(textoEscena, 0, 0, 2, 1);
		
		Label etiquetaNombre = new Label("Equipo compuesto por: ");
		etiquetaNombre.setTextFill(Color.WHITE);
		Label etiquetaPuntosGanados = new Label("Puntos ganados: " + this.modelo.getPuntajeAcumuladoFlorRechazada());
		etiquetaPuntosGanados.setTextFill(Color.WHITE);
		
	
		contenedor.add(etiquetaNombre, 0, 1);
		contenedor.add(etiquetaPuntosGanados, 0, 2);
		
		Label etiquetaNombresEquipo = new Label();
		etiquetaNombresEquipo.setTextFill(Color.WHITE);
		
		Set<String> nombres = this.modelo.getEquipoGanadorFlor();
		
		StringBuilder texto = new StringBuilder();
		
		for (String nombre : nombres) {
			texto.append(nombre);
			texto.append("  ");
		}
		
		etiquetaNombresEquipo.setText(texto.toString());
		
		contenedor.add(etiquetaNombresEquipo, 1, 1);
		
		Label etiquetaContinuar = new Label("Para continuar pulse el botón (Aceptar) e inicie su turno (Botón Iniciar turno)");
		etiquetaContinuar.setTextFill(Color.WHITE);
		etiquetaContinuar.setWrapText(true);
		
		contenedor.add(etiquetaContinuar, 0, 5);
		
		Button botonAceptar = new Button("Aceptar");
		
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
		
		this.escena = new Scene(contenedor, 300, 100);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
	
		this.stage = stage;
		
		this.stage.setTitle("Informacion Flor");
		this.stage.setScene(this.escena);
		this.stage.show();
	}
	
}
