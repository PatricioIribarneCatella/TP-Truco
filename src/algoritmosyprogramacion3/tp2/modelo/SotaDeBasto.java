package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class SotaDeBasto extends Sota {

	public SotaDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/diez-de-basto.jpg", 100, 400, false, true);
	}
}
