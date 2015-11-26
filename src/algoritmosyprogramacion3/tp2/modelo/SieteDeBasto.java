package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class SieteDeBasto extends SieteFalso {

	public SieteDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/siete-de-basto.jpg", 100, 400, false, true);
	}
}
