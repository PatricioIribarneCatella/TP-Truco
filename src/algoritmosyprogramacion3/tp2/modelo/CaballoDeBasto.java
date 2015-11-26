package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CaballoDeBasto extends Caballo {

	public CaballoDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/once-de-basto.jpg", 100, 400, false, true);
	}
}
