package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CincoDeCopa extends Cinco {

	public CincoDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/cinco-de-copa.jpg", 100, 400, false, true);
	}
}
