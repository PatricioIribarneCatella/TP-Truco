package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class TresDeBasto extends Tres {

	public TresDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/tres-de-basto.jpg", 100, 400, false, true);
	}
}
