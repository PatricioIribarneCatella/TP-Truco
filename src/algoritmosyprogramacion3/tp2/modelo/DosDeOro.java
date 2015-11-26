package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class DosDeOro extends Dos {

	public DosDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/dos-de-oro.jpg", 100, 400, false, true);
	}
}
