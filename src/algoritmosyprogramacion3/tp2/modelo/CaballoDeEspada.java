package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CaballoDeEspada extends Caballo {

	public CaballoDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/once-de-espada.jpg", 100, 400, false, true);
	}
}
