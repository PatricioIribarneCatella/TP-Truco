package algoritmosyprogramacion3.tp2.modelo;

public class CuatroDeBasto extends Cuatro {
	
	 public CuatroDeBasto() {
			
		super();
		this.palo = new Basto();
		this.imagen = new Imagen("file:resources/imagenes/cartas/basto/cuatro-de-basto.jpg", 75, 150, false, true);	
	}
}
