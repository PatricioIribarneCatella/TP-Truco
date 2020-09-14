package truco.vista;

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

import truco.modelo.JuegoTruco;
import truco.manejadores.BotonVolverEventHandler;

public class VistaEleccionTipoDeMesa implements Vista {

	private JuegoTruco modelo;
	private Stage stage;
	private Scene escena;
	private VBox contenedor;
	private Button botonVolver;
	private boolean conFlor;
	private VistaEleccionVarianteFlor vistaAnterior;
	
	public VistaEleccionTipoDeMesa(VistaEleccionVarianteFlor vistaAnterior) {
		
		this.vistaAnterior = vistaAnterior;
		this.conFlor = vistaAnterior.getSeJuegaConFlor();
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
		
		Image imagen = new Image("file:src/main/resources/imagenes/fondos/fondo-verde.jpg", 800, 600, false, true);
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
															BackgroundRepeat.REPEAT,
															BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,
															BackgroundSize.DEFAULT);

		this.contenedor.setBackground(new Background(imagenDeFondo));
	}
	
	private void setCaracteristicasAlContenedorPrincipal() {
		
		Button botonMesaComputadora = new Button("Mesa contra Computadora");
		botonMesaComputadora.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonMesaComputadora.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorComputadora = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonMesaComputadora.setBackground(new Background(fondoDeColorComputadora));
		
		botonMesaComputadora.setOnMouseEntered(e -> {
			
			botonMesaComputadora.setScaleX(1.3);
			botonMesaComputadora.setScaleY(1.3);
		});
		
		botonMesaComputadora.setOnMouseExited(e -> {
			
			botonMesaComputadora.setScaleX(1);
			botonMesaComputadora.setScaleY(1);
		});
		
		botonMesaComputadora.setOnAction(e -> {
			
			VistaNuevaMesaContraComputadora nuevaVista = new VistaNuevaMesaContraComputadora(this);
			nuevaVista.mostrar();
		});
		
		Button botonMesaDeDos = new Button("Mesa de Dos");
		botonMesaDeDos.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonMesaDeDos.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorMesaDos = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonMesaDeDos.setBackground(new Background(fondoDeColorMesaDos));
		
		botonMesaDeDos.setOnMouseEntered(e -> {
			
			botonMesaDeDos.setScaleX(1.3);
			botonMesaDeDos.setScaleY(1.3);
		});
		
		botonMesaDeDos.setOnMouseExited(e -> {
			
			botonMesaDeDos.setScaleX(1);
			botonMesaDeDos.setScaleY(1);
		});
		
		botonMesaDeDos.setOnAction(e -> {
			
			VistaNuevaMesaDeDos nuevaVista = new VistaNuevaMesaDeDos(this);
			nuevaVista.mostrar();
		});
		
		Button botonMesaDeCuatro = new Button("Mesa de Cuatro");
		botonMesaDeCuatro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonMesaDeCuatro.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorMesaCuatro = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonMesaDeCuatro.setBackground(new Background(fondoDeColorMesaCuatro));
		
		botonMesaDeCuatro.setOnMouseEntered(e -> {
			
			botonMesaDeCuatro.setScaleX(1.3);
			botonMesaDeCuatro.setScaleY(1.3);
		});
		
		botonMesaDeCuatro.setOnMouseExited(e -> {
			
			botonMesaDeCuatro.setScaleX(1);
			botonMesaDeCuatro.setScaleY(1);
		});
		
		botonMesaDeCuatro.setOnAction(e -> {
			
			VistaNuevaMesaDeCuatro nuevaVista = new VistaNuevaMesaDeCuatro(this);
			nuevaVista.mostrar();
		});
		
		Button botonMesaDeSeis = new Button("Mesa de Seis (Pica - Pica)");
		botonMesaDeSeis.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonMesaDeSeis.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorMesaSeis = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonMesaDeSeis.setBackground(new Background(fondoDeColorMesaSeis));
		
		botonMesaDeSeis.setOnMouseEntered(e -> {
			
			botonMesaDeSeis.setScaleX(1.3);
			botonMesaDeSeis.setScaleY(1.3);
		});
		
		botonMesaDeSeis.setOnMouseExited(e -> {
			
			botonMesaDeSeis.setScaleX(1);
			botonMesaDeSeis.setScaleY(1);
		});
		
		botonMesaDeSeis.setOnAction(e -> {
			
			VistaNuevaMesaDeSeis nuevaVista = new VistaNuevaMesaDeSeis(this);
			nuevaVista.mostrar();
		});
		
		this.botonVolver = new Button("Volver");
		this.botonVolver.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		this.botonVolver.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorVolver = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		this.botonVolver.setBackground(new Background(fondoDeColorVolver));
		
		this.botonVolver.setOnMouseEntered(e -> {
			
			this.botonVolver.setScaleX(1.3);
			this.botonVolver.setScaleY(1.3);
		});
		
		this.botonVolver.setOnMouseExited(e -> {
			
			this.botonVolver.setScaleX(1);
			this.botonVolver.setScaleY(1);
		});
		
		this.botonVolver.setOnAction(new BotonVolverEventHandler(this, this.vistaAnterior));
		
		this.contenedor.getChildren().addAll(botonMesaComputadora, botonMesaDeDos, botonMesaDeCuatro, botonMesaDeSeis, this.botonVolver);
	}
	
	@Override
	public void mostrar() {
		
		this.stage.setTitle("FonTruco");
		this.stage.setScene(this.escena);
		this.stage.show();
	}

	public VistaEleccionVarianteFlor getVistaAnterior() {
		return this.vistaAnterior;
	}
	
	public boolean seJuegaConFlor() {
		return this.conFlor;
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
