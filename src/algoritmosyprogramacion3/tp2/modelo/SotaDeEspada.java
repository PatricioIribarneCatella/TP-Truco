package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class SotaDeEspada extends Sota {

	public SotaDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/diez-de-espada.jpg", 100, 400, false, true);
	}
}
