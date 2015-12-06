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

public class VistaEleccionVarianteFlor implements Vista {

	private JuegoTruco modelo;
	private Stage stage;
	private Scene escena;
	private VBox contenedor;
	private Vista vistaAnterior;
	private boolean conFlor;
	
	public VistaEleccionVarianteFlor(Vista vistaAnterior) {
		
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
		
		this.escena = new Scene(this.contenedor, 1300, 700);
	}

	private void setContenedorPrincipal() {
		
		this.contenedor.setAlignment(Pos.CENTER);
		this.contenedor.setSpacing(20);
		this.contenedor.setPadding(new Insets(25));
	}
	
	private void setImagenDeFondo() {
		
		Image imagen = new Image("file:resources/imagenes/fondos/fondo-verde.jpg", 1300, 700, false, true);
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		this.contenedor.setBackground(new Background(imagenDeFondo));
	}
	
	private void setCaracteristicasAlContenedorPrincipal() {
		
		Button botonConFlor = new Button("Con Flor");
		botonConFlor.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorConFlor = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonConFlor.setBackground(new Background(fondoDeColorConFlor));
		
		botonConFlor.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonConFlor.setAlignment(Pos.TOP_CENTER);
		
		botonConFlor.setOnAction(e -> {
			
			this.conFlor = true;
			VistaEleccionTipoDeMesa nuevaVista = new VistaEleccionTipoDeMesa(this);
			nuevaVista.mostrar();
		});
		
		Button botonSinFlor = new Button("Sin Flor");
		botonSinFlor.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorSinFlor = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonSinFlor.setBackground(new Background(fondoDeColorSinFlor));
		
		botonSinFlor.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonSinFlor.setAlignment(Pos.TOP_CENTER);
		
		botonSinFlor.setOnAction(e -> {
			
			this.conFlor = false;
			VistaEleccionTipoDeMesa nuevaVista = new VistaEleccionTipoDeMesa(this);
			nuevaVista.mostrar();
		});
		
		this.contenedor.getChildren().addAll(botonConFlor, botonSinFlor);
	}
	
	@Override
	public void mostrar() {
		
		this.stage.setTitle("FonTruco");
		this.stage.setScene(this.escena);
		this.stage.show();
	}

	public boolean getSeJuegaConFlor() {
		return this.conFlor;
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
}
