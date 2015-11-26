package algoritmosyprogramacion3.tp2.modelo;

public class CuatroDeEspada extends Cuatro {
	
    public CuatroDeEspada() {
		
		super();
		this.palo = new Espada();
		this.imagen = new Imagen("file:resources/imagenes/cartas/espada/cuatro-de-espada.jpg", 100, 400, false, true);
	}
}
