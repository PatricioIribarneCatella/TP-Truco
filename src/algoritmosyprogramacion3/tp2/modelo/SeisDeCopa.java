package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class SeisDeCopa extends Seis {
	
	public SeisDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/seis-de-copa.jpg", 100, 400, false, true);	
	}
}
