package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class TresDeEspada extends Tres {

	public TresDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/tres-de-espada.jpg", 100, 400, false, true);
	}
}
