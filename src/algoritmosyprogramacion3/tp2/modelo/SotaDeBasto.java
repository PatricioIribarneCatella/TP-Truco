package algoritmosyprogramacion3.tp2.modelo;

public class SotaDeBasto extends Sota {

	public SotaDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Imagen("file:resources/imagenes/cartas/basto/diez-de-basto.jpg", 75, 150, false, true);
	}
}
