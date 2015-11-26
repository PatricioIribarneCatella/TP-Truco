package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class DosDeCopa extends Dos {

	public DosDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/dos-de-copa.jpg", 100, 400, false, true);
	}
}
