package algoritmosyprogramacion3.tp2.modelo;

public class SieteDeBasto extends SieteFalso {

	public SieteDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Imagen("file:resources/imagenes/cartas/basto/siete-de-basto.jpg", 75, 150, false, true);
	}
}
