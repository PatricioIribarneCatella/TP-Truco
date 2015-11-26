package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class ReyDeCopa extends Rey {

	public ReyDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/doce-de-copa.jpg", 100, 400, false, true);
	}
}
