package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CincoDeOro extends Cinco {

	public CincoDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/cinco-de-oro.jpg", 100, 400, false, true);
	}
}
