package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class ReyDeEspada extends Rey {

	public ReyDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/doce-de-espada.jpg", 100, 400, false, true);
	}
}
