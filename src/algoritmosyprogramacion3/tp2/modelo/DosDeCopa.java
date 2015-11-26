package algoritmosyprogramacion3.tp2.modelo;

public class DosDeCopa extends Dos {

	public DosDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/dos-de-copa.jpg", 100, 400, false, true);
	}
}
