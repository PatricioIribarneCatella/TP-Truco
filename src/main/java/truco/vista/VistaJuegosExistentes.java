package truco.vista;

import java.util.Set;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class VistaJuegosExistentes implements Vista {

	private JuegoTruco modelo;
	private Stage stage;
	private Scene escena;
	private VBox contenedor;
	private Button botonVolver;
	private Vista vistaAnterior;
	
	public VistaJuegosExistentes(Vista vistaAnterior) {
		
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
		
		Image imagen = new Image("imagenes/fondos/fondo-verde.jpg", 800, 600, false, true);
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
															BackgroundRepeat.REPEAT,
															BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,
															BackgroundSize.DEFAULT);

		this.contenedor.setBackground(new Background(imagenDeFondo));
	}
	
	private void setCaracteristicasAlContenedorPrincipal() {
	
		Set<String> mesasDisponibles = this.modelo.getMesasDisponilbles();
		
		if (mesasDisponibles.isEmpty()) {
			
			Label etiqueta = new Label("(no hay mesas disponibles aún)");
			etiqueta.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			etiqueta.setTextFill(Color.WHITE);
			this.contenedor.getChildren().add(etiqueta);
			
		} else {
			
			for (String nombreMesa : mesasDisponibles) {
				
				Button botonMesa = new Button(nombreMesa);
				botonMesa.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
				botonMesa.setTextFill(Color.WHITE);
				
				BackgroundFill fondoDeColorBotonMesa = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
				botonMesa.setBackground(new Background(fondoDeColorBotonMesa));
				
				botonMesa.setOnMouseEntered(e -> {
					
					botonMesa.setScaleX(1.3);
					botonMesa.setScaleY(1.3);
				});
				
				botonMesa.setOnMouseExited(e -> {
					
					botonMesa.setScaleX(1);
					botonMesa.setScaleY(1);
				});
				
				botonMesa.setOnAction(e -> {
					
					Vista nuevaVista;
					
					this.modelo.cargarMesa(nombreMesa);
					
					if (this.modelo.mesaActualContraComputadora()) {
						
						nuevaVista = new VistaJuegoDeTrucoComputadora(this);
						
					} else {
						
						nuevaVista = new VistaJuegoDeTrucoPorTurnos(this);
					}
					nuevaVista.mostrar();
				});
				
				this.contenedor.getChildren().add(botonMesa);
			}
		}
		
		this.botonVolver = new Button("Volver");
		this.botonVolver.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		this.botonVolver.setTextFill(Color.BLACK);
		
		BackgroundFill fondoDeColorVolver = new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		this.botonVolver.setBackground(new Background(fondoDeColorVolver));
		
		this.botonVolver.setOnMouseEntered(e -> {
			
			this.botonVolver.setScaleX(1.2);
			this.botonVolver.setScaleY(1.2);
		});
		
		this.botonVolver.setOnMouseExited(e -> {
			
			this.botonVolver.setScaleX(1);
			this.botonVolver.setScaleY(1);
		});
		
		this.botonVolver.setOnAction(new BotonVolverEventHandler(this, this.vistaAnterior));
		
		this.contenedor.getChildren().add(botonVolver);
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
