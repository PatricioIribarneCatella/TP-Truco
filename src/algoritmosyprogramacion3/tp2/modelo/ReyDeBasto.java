package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class ReyDeBasto extends Rey {

	public ReyDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/doce-de-basto.jpg", 100, 400, false, true);
	}
}
