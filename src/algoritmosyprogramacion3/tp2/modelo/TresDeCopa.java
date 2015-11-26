package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class TresDeCopa extends Tres {

	public TresDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/tres-de-copa.jpg", 100, 400, false, true);
	}
}
