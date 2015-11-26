package algoritmosyprogramacion3.tp2.modelo;

public class CincoDeEspada extends Cinco {

	public CincoDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Imagen("file:resources/imagenes/cartas/espada/cinco-de-espada.jpg", 100, 400, false, true);
	}
}
