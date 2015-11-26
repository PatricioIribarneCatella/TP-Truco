package algoritmosyprogramacion3.tp2.modelo;

public class ReyDeBasto extends Rey {

	public ReyDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Imagen("file:resources/imagenes/cartas/basto/doce-de-basto.jpg", 100, 400, false, true);
	}
}
