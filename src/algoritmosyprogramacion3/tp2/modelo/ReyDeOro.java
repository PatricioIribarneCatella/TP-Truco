package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class ReyDeOro extends Rey {

	public ReyDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/doce-de-oro.jpg", 100, 400, false, true);
	}
}
