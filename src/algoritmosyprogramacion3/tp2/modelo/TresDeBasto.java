package algoritmosyprogramacion3.tp2.modelo;

public class TresDeBasto extends Tres {

	public TresDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Imagen("file:resources/imagenes/cartas/basto/tres-de-basto.jpg", 100, 400, false, true);
	}
}
