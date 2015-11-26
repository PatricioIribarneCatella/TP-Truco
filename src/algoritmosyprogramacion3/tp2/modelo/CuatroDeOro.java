package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CuatroDeOro extends Cuatro{
	
	public CuatroDeOro() {
			
		super();
		this.palo = new Oro();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/cuatro-de-oro.jpg", 100, 400, false, true);
	}
}
