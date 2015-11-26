package algoritmosyprogramacion3.tp2.modelo;

public class SeisDeEspada extends Seis {
	
	public SeisDeEspada() {
			
		super();
		this.palo = new Espada();
		this.imagen = new Imagen("file:resources/imagenes/cartas/espada/seis-de-espada.jpg", 100, 400, false, true);	
	}
}
