package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.manejadores.BotonVolverEventHandler;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public abstract class VistaNuevaMesa implements Vista {

	protected JuegoTruco modelo;
	protected Stage stage;
	protected Scene escena;
	protected BorderPane contenedor;
	protected GridPane contenedorCentral;
	protected Button botonVolver;
	private Label etiquetaDatosInvalidos;
	protected TextField textoMesa;
	protected RadioButton botonConFlor;
	protected RadioButton botonSinFlor;
	protected Label etiquetaJugadores;
	protected Vista vistaAnterior;
	
	public VistaNuevaMesa(Vista vistaAnterior) {
		
		this.vistaAnterior = vistaAnterior;
		this.modelo = vistaAnterior.getModelo();
		this.stage = vistaAnterior.getStage();
		this.initialize();
	}
	
	private void initialize() {
		
		this.contenedor = new BorderPane();
		
		this.setContenedorPrincipal();
		
		this.setImagenDeFondo();
		
		this.setCaracteristicasAlContenedorPrincipal();
		
		this.escena = new Scene(this.contenedor, 1300, 700);
	}
	
	private void setContenedorPrincipal() {
		
		this.contenedor.setPadding(new Insets(25));
	}

	private void setImagenDeFondo() {
		
		Image imagen = new Image("file:resources/imagenes/fondos/fondo-verde.jpg", 1300, 700, false, true);
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		this.contenedor.setBackground(new Background(imagenDeFondo));
	}
	
	protected abstract boolean actualizarModelo();

	protected abstract boolean hayDatosCargados();
	
	protected abstract void setCantidadJugadores();
	
	protected abstract Vista nuevaVistaDependiendoModalidad(Vista vistaAnterior);
	
	protected void setMensajeInformacionInvalida(String mensaje) {
		
		this.etiquetaDatosInvalidos.setText(mensaje);
		this.etiquetaDatosInvalidos.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.etiquetaDatosInvalidos.setTextFill(Color.web("#FF0000"));
		this.textoMesa.requestFocus();
	}
	
	protected void setCaracteristicasAlContenedorCentro() {
		
		this.contenedorCentral = new GridPane();
		this.contenedorCentral.setHgap(10);
		this.contenedorCentral.setVgap(10);
		this.contenedorCentral.setPadding(new Insets(25));
		this.contenedorCentral.setAlignment(Pos.CENTER);
		
		this.etiquetaDatosInvalidos = new Label();
		this.contenedorCentral.add(this.etiquetaDatosInvalidos, 0, 0, 2, 1);
		
		Label etiquetaMesa = new Label("Nombre mesa");
		etiquetaMesa.setTextFill(Color.WHITE);
		etiquetaMesa.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		this.contenedorCentral.add(etiquetaMesa, 0, 1);
		
		this.etiquetaJugadores = new Label();
		this.etiquetaJugadores.setTextFill(Color.WHITE);
		this.etiquetaJugadores.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		this.contenedorCentral.add(this.etiquetaJugadores, 0, 2);
		
		this.textoMesa = new TextField();
		this.contenedorCentral.add(this.textoMesa, 1, 1);
		
		this.setCantidadJugadores();
		
		this.contenedor.setCenter(this.contenedorCentral);
	}
	
	private void setCaracteristicasAlContenedorSuperior() {
		
		this.botonConFlor = new RadioButton("Con Flor");
		this.botonConFlor.setTextFill(Color.WHITE);
		this.botonConFlor.setOnMouseClicked(e -> {
			
			if (this.botonSinFlor.isPressed()) this.setMensajeInformacionInvalida("Solo puede seleccionar una opción");
		});
		
		this.botonSinFlor = new RadioButton("Sin Flor");
		this.botonSinFlor.setTextFill(Color.WHITE);
		this.botonSinFlor.setOnMouseClicked(e -> {
			
			if (this.botonConFlor.isPressed()) this.setMensajeInformacionInvalida("Solo puede seleccionar una opción");
		});
		
		HBox contendorSuperior = new HBox(this.botonConFlor, this.botonSinFlor);
		contendorSuperior.setAlignment(Pos.CENTER);
		contendorSuperior.setSpacing(50);
		this.contenedor.setTop(contendorSuperior);
	}
	
	private void setCaracteristicasAlContenedorInferior() {
		
		Button botonCrear = new Button("Crear");
		botonCrear.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		botonCrear.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonCrear = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonCrear.setBackground(new Background(fondoDeColorBotonCrear));
		
		botonCrear.setOnAction(e -> {
			
			if (!this.hayDatosCargados()) {
				
				this.setMensajeInformacionInvalida("Debe ingresar un texto");
				
			} else {
				
				if (this.actualizarModelo()) {
					Vista nuevaVista = this.nuevaVistaDependiendoModalidad(this);
					nuevaVista.mostrar();
				} else {
					this.setMensajeInformacionInvalida("El nombre de la mesa ya existe");
				}
			}
		});
		
		this.botonVolver = new Button("Volver");
		this.botonVolver.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.botonVolver.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorVolver = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		this.botonVolver.setBackground(new Background(fondoDeColorVolver));
		
		this.botonVolver.setOnAction(new BotonVolverEventHandler(this, this.vistaAnterior));
		
		HBox contendorInferior = new HBox(this.botonVolver, botonCrear);
		contendorInferior.setSpacing(200);
		contendorInferior.setAlignment(Pos.CENTER);
		this.contenedor.setBottom(contendorInferior);
	}

	private void setCaracteristicasAlContenedorPrincipal() {
		
		this.setCaracteristicasAlContenedorSuperior();
		this.setCaracteristicasAlContenedorInferior();
		this.setCaracteristicasAlContenedorCentro();
	}
	
	@Override
	public void mostrar() {
		
		this.etiquetaDatosInvalidos.setText("");
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
