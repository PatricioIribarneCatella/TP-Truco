package algoritmosyprogramacion3.tp2.vista;

import java.util.Set;

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

public class ContenedorInformacionJugadoresYMazoPorTurnos extends ContenedorInformacionJugadoresYMazo {

	public ContenedorInformacionJugadoresYMazoPorTurnos(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	protected void setCaracteristicasAlContenedorInformacionJugadores() {
		
		Set<String> nombres = this.modelo.getNombresDeJugadores();
		
		for (String nombre : nombres) {
			
			Button botonNombreJugador = new Button("Información Jugador: " + nombre);
			
			botonNombreJugador.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
			botonNombreJugador.setTextFill(Color.WHITE);
			
			BackgroundFill fondoDeColorBotonInformacion = new BackgroundFill(Color.BROWN, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
			botonNombreJugador.setBackground(new Background(fondoDeColorBotonInformacion));
			
			botonNombreJugador.setOnMouseEntered(e -> {
				
				botonNombreJugador.setScaleX(1.2);
				botonNombreJugador.setScaleY(1.2);
			});
			
			botonNombreJugador.setOnMouseExited(e -> {
				
				botonNombreJugador.setScaleX(1);
				botonNombreJugador.setScaleY(1);
			});
			
			botonNombreJugador.setOnAction(e -> {
				
				VentanaInformacionJugador vista = new VentanaInformacionJugador(this.modelo, nombre);
				try {
					vista.start(new Stage());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
			this.getChildren().add(botonNombreJugador);
		}
	}
}
