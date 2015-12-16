package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ContenedorCartasPorTurnos extends ContenedorCartas {

	public ContenedorCartasPorTurnos(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		super(vista, modelo);
	}

	@Override
	public void cambiarTurno(String nombreJugador, VBox botones) {
		
		this.vista.setTextoNombreJugador("");
		this.vista.setTextoPuntosJugador("");
		this.vista.limpiarBotones();
		
		this.getChildren().clear();
		
		Button botonIniciarTurno = new Button("Iniciar turno: " + nombreJugador);
		botonIniciarTurno.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		botonIniciarTurno.setTextFill(Color.BLACK);
		
		BackgroundFill fondoDeColorBotonInformacion = new BackgroundFill(Color.LIME, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonIniciarTurno.setBackground(new Background(fondoDeColorBotonInformacion));
		
		botonIniciarTurno.setOnMouseEntered(e1 -> {
			
			botonIniciarTurno.setScaleX(1.2);
			botonIniciarTurno.setScaleY(1.2);
		});
		
		botonIniciarTurno.setOnMouseExited(e2 -> {
			
			botonIniciarTurno.setScaleX(1);
			botonIniciarTurno.setScaleY(1);
		});
		
		botonIniciarTurno.setOnAction(e3 -> {
			
			this.vista.setTextoNombreJugador("Nombre: " + nombreJugador);
			this.vista.setTextoPuntosJugador("Puntos: " + this.modelo.mostrarPuntosDeJugador(nombreJugador));
			
			this.getChildren().clear();
			
			this.graficarCartas(nombreJugador, this.modelo.getCartasJugador(nombreJugador));
			this.vista.graficarBotones(botones);
		});
		
		this.getChildren().add(botonIniciarTurno);
	}
}
