package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class SotaDeCopa extends Sota {

	public SotaDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/diez-de-copa.jpg", 100, 400, false, true);
	}
}
