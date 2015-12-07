package algoritmosyprogramacion3.tp2.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaJuegoDeTrucoPorTurnos extends VistaJuegoDeTruco {

	public VistaJuegoDeTrucoPorTurnos(Vista vistaAnterior) {
		super(vistaAnterior);
	}

	@Override
	protected void setBotonTerminarTurno() {
		
		Button botonTerminarTurno = new Button("Terminar turno");
		botonTerminarTurno.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonTerminarTurno.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonTerminarTurno = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonTerminarTurno.setBackground(new Background(fondoDeColorBotonTerminarTurno));
		
		this.contenedorBotones.getChildren().add(botonTerminarTurno);
	}

	@Override
	protected void setCaracteristicasAlContenedorInformacionJugadores() {
		
	}
}
