package algoritmosyprogramacion3.tp2.modelo;

public class TresDeEspada extends Tres {

	public TresDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Imagen("file:resources/imagenes/cartas/espada/tres-de-espada.jpg", 100, 400, false, true);
	}
}
