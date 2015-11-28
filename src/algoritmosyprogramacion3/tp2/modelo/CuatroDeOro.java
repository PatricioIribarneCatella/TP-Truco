package algoritmosyprogramacion3.tp2.modelo;

public class CuatroDeOro extends Cuatro{
	
	public CuatroDeOro() {
			
		super();
		this.palo = new Oro();
		this.imagen = new Imagen("file:resources/imagenes/cartas/oro/cuatro-de-oro.jpg", 75, 150, false, true);
	}
}
