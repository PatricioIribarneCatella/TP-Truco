package algoritmosyprogramacion3.tp2.modelo;

public class CaballoDeBasto extends Caballo {

	public CaballoDeBasto() {
		
		super();
		this.palo = new Basto();
		this.imagen = new Imagen("file:resources/imagenes/cartas/basto/once-de-basto.jpg", 75, 150, false, true);
	}
}
