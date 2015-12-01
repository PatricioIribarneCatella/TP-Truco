package algoritmosyprogramacion3.tp2.vista;

import java.util.Arrays;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaNuevaMesaDeSeis extends VistaNuevaMesa {

	private TextField textoJugador1;
	private TextField textoJugador2;
	private TextField textoJugador3;
	private TextField textoJugador4;
	private TextField textoJugador5;
	private TextField textoJugador6;
	private Label etiquetaEquipo2;
	
	public VistaNuevaMesaDeSeis(Vista vistaAnterior) {
		
		super(vistaAnterior);
		this.etiquetaJugadores.setText("Equipo 1");
		this.etiquetaEquipo2 = new Label("Equipo 2");
		this.etiquetaEquipo2.setTextFill(Color.WHITE);
		this.etiquetaEquipo2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		this.contenedorCentral.add(this.etiquetaEquipo2, 0, 5);
	}

	@Override
	protected boolean actualizarModelo() {
		
		String nombreMesa = this.textoMesa.getText();
		String nombreJugador1 = this.textoJugador1.getText();
		String nombreJugador2 = this.textoJugador2.getText();
		String nombreJugador3 = this.textoJugador3.getText();
		String nombreJugador4 = this.textoJugador4.getText();
		String nombreJugador5 = this.textoJugador5.getText();
		String nombreJugador6 = this.textoJugador6.getText();
		
		if (this.botonConFlor.isPressed()) {
			
			return this.modelo.nuevaMesaDeSeisConFlor(nombreMesa, Arrays.asList(nombreJugador1, nombreJugador2, nombreJugador3), Arrays.asList(nombreJugador4, nombreJugador5, nombreJugador6));
			
		} else {
			
			return this.modelo.nuevaMesaDeSeisSinFlor(nombreMesa, Arrays.asList(nombreJugador1, nombreJugador2, nombreJugador3), Arrays.asList(nombreJugador4, nombreJugador5, nombreJugador6));
		}
	}

	@Override
	protected boolean hayDatosCargados() {
		
		return (!this.textoMesa.getText().trim().equals("")
				&& !this.textoJugador1.getText().trim().equals("")
					&& !this.textoJugador2.getText().trim().equals("")
						&& !this.textoJugador3.getText().trim().equals("")
							&& !this.textoJugador4.getText().trim().equals("")
								&& !this.textoJugador5.getText().trim().equals("")
									&& !this.textoJugador6.getText().trim().equals(""));
	}

	@Override
	protected void setCantidadJugadores() {
		
		this.textoJugador1 = new TextField();
		this.textoJugador2 = new TextField();
		this.textoJugador3 = new TextField();
		this.textoJugador4 = new TextField();
		this.textoJugador5 = new TextField();
		this.textoJugador6 = new TextField();
		this.contenedorCentral.add(this.textoJugador1, 1, 2);
		this.contenedorCentral.add(this.textoJugador2, 1, 3);
		this.contenedorCentral.add(this.textoJugador3, 1, 4);
		this.contenedorCentral.add(this.textoJugador4, 1, 5);
		this.contenedorCentral.add(this.textoJugador5, 1, 6);
		this.contenedorCentral.add(this.textoJugador6, 1, 7);
	}
}
