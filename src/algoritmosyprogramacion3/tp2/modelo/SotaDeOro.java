package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class SotaDeOro extends Sota {

	public SotaDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/diez-de-oro.jpg", 100, 400, false, true);
	}
}
