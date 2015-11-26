package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class UnoDeCopa extends UnoFalso{
	
	public UnoDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/uno-de-copa.jpg", 100, 400, false, true);	
	}
}
