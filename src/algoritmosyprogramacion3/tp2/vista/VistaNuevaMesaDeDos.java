package algoritmosyprogramacion3.tp2.vista;

import java.util.Arrays;

import javafx.scene.control.TextField;

public class VistaNuevaMesaDeDos extends VistaNuevaMesa {

	private TextField textoJugador1;
	private TextField textoJugador2;
	
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

	@Override
	protected void setCantidadJugadores() {
		
		this.textoJugador1 = new TextField();
		this.textoJugador2 = new TextField();
		this.contenedorCentral.add(this.textoJugador1, 1, 2);
		this.contenedorCentral.add(textoJugador2, 1, 3);
	}

	@Override
	protected Vista nuevaVistaDependiendoModalidad(Vista vistaAnterior) {
		return new VistaJuegoDeTrucoPorTurnos(vistaAnterior);
	}
}
