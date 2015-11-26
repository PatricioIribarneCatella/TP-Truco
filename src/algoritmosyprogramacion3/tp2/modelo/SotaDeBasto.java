package algoritmosyprogramacion3.tp2.modelo;

public class SotaDeBasto extends Sota {

	public SotaDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Imagen("file:resources/imagenes/cartas/basto/diez-de-basto.jpg", 100, 400, false, true);
	}
}
