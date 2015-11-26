package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class SeisDeOro extends Seis{
	
	public SeisDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/seis-de-oro.jpg", 100, 400, false, true);	
	}
}
