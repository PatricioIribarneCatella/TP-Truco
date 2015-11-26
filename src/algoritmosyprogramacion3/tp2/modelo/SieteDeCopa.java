package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class SieteDeCopa extends SieteFalso {

	public SieteDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/siete-de-copa.jpg", 100, 400, false, true);
	}
}
