package truco.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaNuevaMesaContraComputadora extends VistaNuevaMesa {
	
	private TextField textoJugador;
	private Label etiquetaJujadorNoCargado;
	
	public VistaNuevaMesaContraComputadora(VistaEleccionTipoDeMesa vistaAnterior) {
		
		super(vistaAnterior);
		this.etiquetaJugadores.setText("Jugador");
	}

	@Override
	protected boolean actualizarModelo() {
		
		String nombreMesa = this.textoMesa.getText();
		String nombreJugador = this.textoJugador.getText();
		
		if (this.seJuegaConFlor) {
			return this.modelo.nuevaMesaContraComputadoraConFlor(nombreMesa, nombreJugador);
		} else {
			return this.modelo.nuevaMesaContraComputadoraSinFlor(nombreMesa, nombreJugador);
		}
	}

	@Override
	protected boolean hayDatosCargados() {
		
		return (!this.textoMesa.getText().trim().equals("")
				&& !this.textoJugador.getText().trim().equals(""));
	}

	@Override
	protected void setCantidadJugadores() {
		
		this.textoJugador = new TextField();
		this.contenedorCentral.add(this.textoJugador, 1, 2);
		
		this.etiquetaJujadorNoCargado = new Label();
		this.etiquetaJujadorNoCargado.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		this.etiquetaJujadorNoCargado.setTextFill(Color.RED);
		
		BackgroundFill fondoDeColorEtiquetaDatosInvalidos = new BackgroundFill(Color.WHITE, new CornerRadii(3), new Insets(0.0,0.0,0.0,0.0));
		this.etiquetaJujadorNoCargado.setBackground(new Background(fondoDeColorEtiquetaDatosInvalidos));
		this.contenedorCentral.add(this.etiquetaJujadorNoCargado, 2, 2);
	}

	@Override
	protected Vista nuevaVistaDependiendoModalidad(Vista vistaAnterior) {
		return new VistaJuegoDeTrucoComputadora(vistaAnterior);
	}

	@Override
	protected void setMensajeInformacionDatosNoCargados() {
		
		this.etiquetaNombreMesaNoCargada.setText("");
		this.etiquetaJujadorNoCargado.setText("");
		
		if (this.textoMesa.getText().trim().equals("")) {
			this.etiquetaNombreMesaNoCargada.setText("Debe ingresar un nombre para la mesa");
			this.textoMesa.requestFocus();
		}
		
		if (this.textoJugador.getText().trim().equals("")) {
			this.etiquetaJujadorNoCargado.setText("Debe ingresar un nombre para el jugador");
			this.textoJugador.requestFocus();
		}
	}
}
