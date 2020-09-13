package truco.vista;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import truco.modelo.Carta;
import truco.modelo.JuegoTruco;
import truco.utilitarios.GraficadorCartas;
import truco.utilitarios.NombreJugadorCarta;

public class ContenedorCartasJugadas extends HBox {

	private JuegoTruco modelo;
	private GraficadorCartas graficadorCartas;
	
	public ContenedorCartasJugadas(JuegoTruco modelo) {
		this.modelo = modelo;
		this.graficadorCartas = new GraficadorCartas();
		this.initialize();
	}
	
	private void initialize() {
		
		this.setConfiguracion();
		this.setElementos();
	}

	private void setConfiguracion() {
		
		this.setSpacing(30);
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
	}

	private Image getImagenCarta(Carta carta) {
		
		Imagen imagen = this.graficadorCartas.getImagen(carta);
		return new Image(imagen.getUrl(), imagen.getWidth(), imagen.getHeigth(), imagen.getPreserveRatio(), imagen.getSmooth());
	}
	
	private void setElementos() {
		
		List<NombreJugadorCarta> cartasJugadores = this.modelo.getCartasYaJugadas();
		
		if (!cartasJugadores.isEmpty()) {
			
			for (NombreJugadorCarta nombreJugadorCarta : cartasJugadores) {
				
				Label etiqueta = new Label(nombreJugadorCarta.getNombreJugador());
				etiqueta.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
				etiqueta.setTextFill(Color.WHITE);
				
				etiqueta.setGraphic(new ImageView(this.getImagenCarta(nombreJugadorCarta.getCarta())));
				etiqueta.setContentDisplay(ContentDisplay.TOP);
				
				this.getChildren().add(etiqueta);
			}
		}
	}
	
	public void graficarCartaJugada(Carta carta, String nombreJugador) {
		
		Label etiquetaCarta = new Label(nombreJugador);
		etiquetaCarta.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		etiquetaCarta.setTextFill(Color.WHITE);
		
		etiquetaCarta.setGraphic(new ImageView(this.getImagenCarta(carta)));
		etiquetaCarta.setContentDisplay(ContentDisplay.TOP);
		
		this.getChildren().add(etiquetaCarta);
	}

	public void limmpiarCartas() {
		this.getChildren().clear();
	}
}
