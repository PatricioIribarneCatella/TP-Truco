package algoritmosyprogramacion3.tp2.modelo;

public class SotaDeCopa extends Sota {

	public SotaDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/diez-de-copa.jpg", 100, 400, false, true);
	}
}
