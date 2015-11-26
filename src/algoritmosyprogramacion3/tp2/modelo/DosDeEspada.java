package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class DosDeEspada extends Dos {

	public DosDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/dos-de-espada.jpg", 100, 400, false, true);
	}
}
