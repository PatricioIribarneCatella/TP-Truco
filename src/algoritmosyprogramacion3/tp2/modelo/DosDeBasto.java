package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class DosDeBasto extends Dos {

	public DosDeBasto() {
	
		super();
		this.palo = new Basto();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/dos-de-basto.jpg", 100, 400, false, true);
	}
}
