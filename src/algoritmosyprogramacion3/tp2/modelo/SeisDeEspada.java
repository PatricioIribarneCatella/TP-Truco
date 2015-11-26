package algoritmosyprogramacion3.tp2.modelo;

import javafx.scene.image.Image;

public class SeisDeEspada extends Seis {
	
	public SeisDeEspada() {
			
		super();
		this.palo = new Espada();
		this.imagen = new Image("file:resources/imagenes/cartas/basto/seis-de-espada.jpg", 100, 400, false, true);	
	}
}
