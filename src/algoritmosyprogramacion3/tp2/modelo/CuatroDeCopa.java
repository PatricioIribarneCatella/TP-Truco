package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CuatroDeCopa extends Cuatro{
 	
	  public CuatroDeCopa() {
 			
		super();
		this.palo = new Copa();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/cuatro-de-copa.jpg", 100, 400, false, true);	
 	}
}
