package algoritmosyprogramacion3.tp2.modelo;

public class DosDeEspada extends Dos {

	public DosDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Imagen("file:resources/imagenes/cartas/espada/dos-de-espada.jpg", 100, 400, false, true);
	}
}
