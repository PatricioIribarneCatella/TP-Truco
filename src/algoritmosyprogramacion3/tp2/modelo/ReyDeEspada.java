package algoritmosyprogramacion3.tp2.modelo;

public class ReyDeEspada extends Rey {

	public ReyDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Imagen("file:resources/imagenes/cartas/espada/doce-de-espada.jpg", 75, 150, false, true);
	}
}
