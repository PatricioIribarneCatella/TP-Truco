package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorInformacionJugadoresYMazoComputadora extends ContenedorInformacionJugadoresYMazo {

	public ContenedorInformacionJugadoresYMazoComputadora(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	protected void setCaracteristicasAlContenedorInformacionJugadores() {

		Button botonComputadora = new Button("Información Computadora");
		
		botonComputadora.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonComputadora.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBotonInformacion = new BackgroundFill(Color.BROWN, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonComputadora.setBackground(new Background(fondoDeColorBotonInformacion));
		
		botonComputadora.setOnMouseEntered(e -> {
			
			botonComputadora.setScaleX(1.2);
			botonComputadora.setScaleY(1.2);
		});
		
		botonComputadora.setOnMouseExited(e -> {
			
			botonComputadora.setScaleX(1);
			botonComputadora.setScaleY(1);
		});
		
		botonComputadora.setOnAction(e -> {
			
			VentanaInformacionJugador vista = new VentanaInformacionJugador(this.modelo, "Computadora");
			try {
				vista.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		this.getChildren().add(botonComputadora);
	}
}
