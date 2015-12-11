package algoritmosyprogramacion3.tp2.vista;

import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaNuevaMesaDeDos extends VistaNuevaMesa {

	private TextField textoJugador1;
	private TextField textoJugador2;
	private Label etiquetaJugadorUnoNoCargado;
	private Label etiquetaJugadorDosNoCargado;
	
	public VistaNuevaMesaDeDos(VistaEleccionTipoDeMesa vistaAnterior) {
		
		super(vistaAnterior);
		this.etiquetaJugadores.setText("Jugadores");
	}

	@Override
	protected boolean actualizarModelo() {
		
		String nombreMesa = this.textoMesa.getText();
		String nombreJugador1 = this.textoJugador1.getText();
		String nombreJugador2 = this.textoJugador2.getText();
		
		if (this.seJuegaConFlor) {
			
			return this.modelo.nuevaMesaDeDosConFlor(nombreMesa, Arrays.asList(nombreJugador1, nombreJugador2));
			
		} else {
			
			return this.modelo.nuevaMesaDeDosSinFlor(nombreMesa, Arrays.asList(nombreJugador1, nombreJugador2));
		}
	}

	@Override
	protected boolean hayDatosCargados() {
		
		return (!this.textoMesa.getText().trim().equals("")
				&& !this.textoJugador1.getText().trim().equals("")
					&& !this.textoJugador2.getText().trim().equals(""));
	}

	private void setCaracteristicasEtiquetaJugadorNoCargado(Label etiqueta) {
		
		etiqueta.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		etiqueta.setTextFill(Color.RED);
		
		BackgroundFill fondoDeColorEtiqueta = new BackgroundFill(Color.WHITE, new CornerRadii(3), new Insets(0.0,0.0,0.0,0.0));
		etiqueta.setBackground(new Background(fondoDeColorEtiqueta));
	}
	
	@Override
	protected void setCantidadJugadores() {
		
		this.textoJugador1 = new TextField();
		this.textoJugador2 = new TextField();
		this.contenedorCentral.add(this.textoJugador1, 1, 2);
		this.contenedorCentral.add(textoJugador2, 1, 3);
		
		this.etiquetaJugadorUnoNoCargado = new Label();
		this.setCaracteristicasEtiquetaJugadorNoCargado(this.etiquetaJugadorUnoNoCargado);
		this.contenedorCentral.add(etiquetaJugadorUnoNoCargado, 2, 2);
		
		this.etiquetaJugadorDosNoCargado = new Label();
		this.setCaracteristicasEtiquetaJugadorNoCargado(this.etiquetaJugadorDosNoCargado);
		this.contenedorCentral.add(etiquetaJugadorDosNoCargado, 2, 3);
	}

	@Override
	protected Vista nuevaVistaDependiendoModalidad(Vista vistaAnterior) {
		return new VistaJuegoDeTrucoPorTurnos(vistaAnterior);
	}

	@Override
	protected void setMensajeInformacionDatosNoCargados() {
		
		this.etiquetaNombreMesaNoCargada.setText("");
		this.etiquetaJugadorUnoNoCargado.setText("");
		this.etiquetaJugadorDosNoCargado.setText("");
		
		if (this.textoMesa.getText().trim().equals("")) {
			this.etiquetaNombreMesaNoCargada.setText("Debe ingresar un nombre para la mesa");
		}
		
		if (this.textoJugador1.getText().trim().equals("")) {
			this.etiquetaJugadorUnoNoCargado.setText("Debe ingresar un nombre para el jugador 1");
		}
		
		if (this.textoJugador2.getText().trim().equals("")) {
			this.etiquetaJugadorDosNoCargado.setText("Debe ingresar un nombre para el jugador 2");
		}
	}
}
