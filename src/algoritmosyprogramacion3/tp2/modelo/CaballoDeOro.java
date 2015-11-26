package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CaballoDeOro extends Caballo {

	public CaballoDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/once-de-oro.jpg", 100, 400, false, true);
	}
}
