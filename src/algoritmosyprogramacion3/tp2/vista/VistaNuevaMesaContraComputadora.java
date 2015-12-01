package algoritmosyprogramacion3.tp2.vista;

import javafx.scene.control.TextField;

public class VistaNuevaMesaContraComputadora extends VistaNuevaMesa {
	
	private TextField textoJugador;
	
	public VistaNuevaMesaContraComputadora(Vista vistaAnterior) {
		
		super(vistaAnterior);
		this.etiquetaJugadores.setText("Jugador");
	}

	@Override
	protected boolean actualizarModelo() {
		
		String nombreMesa = this.textoMesa.getText();
		String nombreJugador = this.textoJugador.getText();
		
		if (this.botonConFlor.isPressed()) {
			
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
	}
}
