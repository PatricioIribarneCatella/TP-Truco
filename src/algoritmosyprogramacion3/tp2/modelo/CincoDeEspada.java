package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CincoDeEspada extends Cinco {

	public CincoDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/cinco-de-espada.jpg", 100, 400, false, true);
	}
}
