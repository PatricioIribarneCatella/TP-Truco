package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class TresDeOro extends Tres {

	public TresDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/tres-de-oro.jpg", 100, 400, false, true);
	}
}
