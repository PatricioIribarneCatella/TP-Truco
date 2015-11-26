package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CuatroDeBasto extends Cuatro {
	
	 public CuatroDeBasto() {
			
		super();
		this.palo = new Basto();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/cuatro-de-basto.jpg", 100, 400, false, true);	
	}
}
