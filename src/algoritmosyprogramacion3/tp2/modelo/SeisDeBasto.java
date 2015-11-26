package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class SeisDeBasto extends Seis {

	public SeisDeBasto() {
			
		super();
		this.palo = new Basto();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/seis-de-basto.jpg", 100, 400, false, true);
	}
}
