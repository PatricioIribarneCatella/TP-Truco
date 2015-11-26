package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class VistaInicio implements Vista {

	private JuegoTruco modelo;
	private Stage stage;
	private Scene escena;
	private VBox contenedor;
	
	public VistaInicio(JuegoTruco modelo, Stage stage) {
		
		this.modelo = modelo;
		this.stage = stage;
		this.initialize();
	}

	private void initialize() {
		
		this.contenedor = new VBox();
		
		this.setContenedorPrincipal();
		
		this.setImagenDeFondo();
		
		this.setCaracteristicasAlContenedorPrincipal();
		
		this.escena = new Scene(this.contenedor, 1000, 600);
	}
	
	private void setContenedorPrincipal() {
		
		this.contenedor.setAlignment(Pos.CENTER);
		this.contenedor.setSpacing(20);
		this.contenedor.setPadding(new Insets(25));
	}
	
	private void setImagenDeFondo() {
		
		Image imagen = new Image("file:resources/imagenes/fondo-con-cartas-1.jpg", 1000, 600, false, true);
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		this.contenedor.setBackground(new Background(imagenDeFondo));
	}
	
	private HBox setCaracateristicasAlContendorBotonJugar() {
		
		HBox contenedor = new HBox();
		
		contenedor.setAlignment(Pos.CENTER);
		contenedor.setSpacing(20);
		contenedor.setPadding(new Insets(10, 10, 80, 10));
		
		return contenedor;
	}
	
	private void setCaracteristicasAlContenedorPrincipal() {
		
		Button botonJugar = new Button("Jugar");
		botonJugar.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColor = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonJugar.setBackground(new Background(fondoDeColor));
		
		botonJugar.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonJugar.setAlignment(Pos.TOP_CENTER);
		botonJugar.setMaxSize(100, 30);
		
		HBox contenedorBotonJugar = this.setCaracateristicasAlContendorBotonJugar();
		contenedorBotonJugar.getChildren().add(botonJugar);
		
		this.contenedor.getChildren().add(contenedorBotonJugar);
	}

	@Override
	public void mostrar() {
		
		this.stage.setTitle("FonTruco");
		this.stage.setScene(this.escena);
		this.stage.show();
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
