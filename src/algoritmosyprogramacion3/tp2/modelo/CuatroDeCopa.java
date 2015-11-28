package algoritmosyprogramacion3.tp2.modelo;

public class CuatroDeCopa extends Cuatro{
 	
	  public CuatroDeCopa() {
 			
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/cuatro-de-copa.jpg", 75, 150, false, true);	
 	}
}
