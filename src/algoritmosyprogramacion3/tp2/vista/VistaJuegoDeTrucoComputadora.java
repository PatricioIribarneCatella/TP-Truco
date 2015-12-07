package algoritmosyprogramacion3.tp2.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VistaJuegoDeTrucoComputadora extends VistaJuegoDeTruco {

	public VistaJuegoDeTrucoComputadora(Vista vistaAnterior) {
		super(vistaAnterior);
	}

	@Override
	protected void setBotonTerminarTurno() {
		// Esta vista no posee el boton terminar turno
	}

	@Override
	protected void setCaracteristicasAlContenedorInformacionJugadores() {
		
		Button botonComputadora = new Button("Información Computadora");
		
		botonComputadora.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonComputadora.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonInformacion = new BackgroundFill(Color.BROWN, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonComputadora.setBackground(new Background(fondoDeColorBotonInformacion));
		
		botonComputadora.setOnAction(e -> {
			
			VistaInformacionJugador vista = new VistaInformacionJugador(this.modelo, "Computadora");
			try {
				vista.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		this.contenedorInformacionJugadores.getChildren().add(botonComputadora);
	}
}
