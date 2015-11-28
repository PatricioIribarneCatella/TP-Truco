package algoritmosyprogramacion3.tp2.modelo;

public class CaballoDeOro extends Caballo {

	public CaballoDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Imagen("file:resources/imagenes/cartas/oro/once-de-oro.jpg", 75, 150, false, true);
	}
}
