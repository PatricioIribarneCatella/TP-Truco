package algoritmosyprogramacion3.tp2.modelo;

public class DosDeBasto extends Dos {

	public DosDeBasto() {
	
		super();
		this.palo = new Basto();
		this.imagen = new Imagen("file:resources/imagenes/cartas/basto/dos-de-basto.jpg", 75, 150, false, true);
	}
}
