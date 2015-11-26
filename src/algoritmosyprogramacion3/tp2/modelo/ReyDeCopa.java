package algoritmosyprogramacion3.tp2.modelo;

public class ReyDeCopa extends Rey {

	public ReyDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/doce-de-copa.jpg", 100, 400, false, true);
	}
}
