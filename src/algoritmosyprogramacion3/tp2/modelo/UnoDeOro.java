package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class UnoDeOro extends UnoFalso{
	
	public UnoDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/uno-de-oro.jpg", 100, 400, false, true);	
	}
}
