package algoritmosyprogramacion3.tp2.modelo;

public class CaballoDeEspada extends Caballo {

	public CaballoDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Imagen("file:resources/imagenes/cartas/espada/once-de-espada.jpg", 75, 150, false, true);
	}
}
