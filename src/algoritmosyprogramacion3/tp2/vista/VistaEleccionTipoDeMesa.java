package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.manejadores.BotonVolverEventHandler;
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

public class VistaEleccionTipoDeMesa implements Vista {

	private JuegoTruco modelo;
	private Stage stage;
	private Scene escena;
	private VBox contenedor;
	private Button botonVolver;
	private Vista vistaAnterior;
	
	public VistaEleccionTipoDeMesa(Vista vistaAnterior) {
		
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
		
		this.escena = new Scene(this.contenedor, 1000, 600);
	}
	
	private void setContenedorPrincipal() {
		
		this.contenedor.setAlignment(Pos.CENTER);
		this.contenedor.setSpacing(25);
		this.contenedor.setPadding(new Insets(25));
	}

	private void setImagenDeFondo() {
		
		Image imagen = new Image("file:resources/imagenes/fondos/fondo-verde.jpg", 1000, 600, false, true);
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		this.contenedor.setBackground(new Background(imagenDeFondo));
	}
	
	private void setCaracteristicasAlContenedorPrincipal() {
		
		Button botonMesaComputadora = new Button("Mesa contra Computadora");
		botonMesaComputadora.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonMesaComputadora.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorComputadora = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonMesaComputadora.setBackground(new Background(fondoDeColorComputadora));
		
		botonMesaComputadora.setOnAction(e -> {
			
			VistaNuevaMesaContraComputadora nuevaVista = new VistaNuevaMesaContraComputadora(this);
			nuevaVista.mostrar();
		});
		
		Button botonMesaDeDos = new Button("Mesa de Dos");
		botonMesaDeDos.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonMesaDeDos.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorMesaDos = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonMesaDeDos.setBackground(new Background(fondoDeColorMesaDos));
		
		botonMesaDeDos.setOnAction(e -> {
			
			VistaNuevaMesaDeDos nuevaVista = new VistaNuevaMesaDeDos(this);
			nuevaVista.mostrar();
		});
		
		Button botonMesaDeCuatro = new Button("Mesa de Cuatro");
		botonMesaDeCuatro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonMesaDeCuatro.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorMesaCuatro = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonMesaDeCuatro.setBackground(new Background(fondoDeColorMesaCuatro));
		
		botonMesaDeCuatro.setOnAction(e -> {
			
			VistaNuevaMesaDeCuatro nuevaVista = new VistaNuevaMesaDeCuatro(this);
			nuevaVista.mostrar();
		});
		
		Button botonMesaDeSeis = new Button("Mesa de Seis (Pica - Pica)");
		botonMesaDeSeis.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonMesaDeSeis.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorMesaSeis = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonMesaDeSeis.setBackground(new Background(fondoDeColorMesaSeis));
		
		botonMesaDeSeis.setOnAction(e -> {
			
			VistaNuevaMesaDeSeis nuevaVista = new VistaNuevaMesaDeSeis(this);
			nuevaVista.mostrar();
		});
		
		this.botonVolver = new Button("Volver");
		this.botonVolver.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.botonVolver.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorVolver = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		this.botonVolver.setBackground(new Background(fondoDeColorVolver));
		
		this.botonVolver.setOnAction(new BotonVolverEventHandler(this, this.vistaAnterior));
		
		this.contenedor.getChildren().addAll(botonMesaComputadora, botonMesaDeDos, botonMesaDeCuatro, botonMesaDeSeis, this.botonVolver);
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
