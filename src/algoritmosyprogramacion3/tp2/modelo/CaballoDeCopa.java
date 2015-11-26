package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class CaballoDeCopa extends Caballo {

	public CaballoDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/once-de-copa.jpg", 100, 400, false, true);
	}
}
