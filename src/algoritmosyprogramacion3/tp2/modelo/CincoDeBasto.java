package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CincoDeBasto extends Cinco {

	public CincoDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/cinco-de-basto.jpg", 100, 400, false, true);
	}
}
