package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CuatroDeEspada extends Cuatro {
	
    public CuatroDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/cuatro-de-espada.jpg", 100, 400, false, true);
	}
}
