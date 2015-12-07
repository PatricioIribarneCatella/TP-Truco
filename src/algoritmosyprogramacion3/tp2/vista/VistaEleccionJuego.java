package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VistaEleccionJuego implements Vista {

	private JuegoTruco modelo;
	private Stage stage;
	private Scene escena;
	private VBox contenedor;
	private Button botonVolver;
	private Vista vistaAnterior;
	
	public VistaEleccionJuego(Vista vistaAnterior) {
		
		this.vistaAnterior = vistaAnterior;
		this.modelo = vistaAnterior.getModelo();
		this.stage = vistaAnterior.getStage();
		this.initialize();
	}
	
	private void initialize() {
		
		this.contenedor = new VBox();
		
		this.setContenedorPrincipal();
		
		this.setImagenDeFondo();
		
		this.setCaracteristicasAlContenedorPrincipal();
		
		this.escena = new Scene(this.contenedor, 800, 600);
	}
	
	private void setContenedorPrincipal() {
		
		this.contenedor.setAlignment(Pos.CENTER);
		this.contenedor.setSpacing(25);
		this.contenedor.setPadding(new Insets(25));
	}

	private void setImagenDeFondo() {
		
		Image imagen = new Image("file:resources/imagenes/fondos/fondo-verde.jpg", 800, 600, false, true);
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		this.contenedor.setBackground(new Background(imagenDeFondo));
	}
	
	private void setCaracteristicasAlContenedorPrincipal() {
		
		Button botonJuegosExistentes = new Button("Juegos existentes");
		botonJuegosExistentes.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonJuegosExistentes.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorJuegosExistentes = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonJuegosExistentes.setBackground(new Background(fondoDeColorJuegosExistentes));
		
		botonJuegosExistentes.setOnAction(e -> {
			
			VistaJuegosExistentes nuevaVista = new VistaJuegosExistentes(this);
			nuevaVista.mostrar();
		});
		
		Button botonNuevoJuego = new Button("Nuevo juego");
		botonNuevoJuego.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonNuevoJuego.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorNuevoJuego = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonNuevoJuego.setBackground(new Background(fondoDeColorNuevoJuego));
		
		botonNuevoJuego.setOnAction(e -> {
			
			VistaEleccionVarianteFlor nuevaVista = new VistaEleccionVarianteFlor(this);
			nuevaVista.mostrar();
		});
		
		this.contenedor.getChildren().addAll(botonJuegosExistentes, botonNuevoJuego);
	}
	
	@Override
	public void mostrar() {
		
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
	
	public Button getBotonVolver() {
		return this.botonVolver;
	}
}
