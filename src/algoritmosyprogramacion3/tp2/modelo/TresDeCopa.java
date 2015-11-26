package algoritmosyprogramacion3.tp2.modelo;

public class TresDeCopa extends Tres {

	public TresDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/tres-de-copa.jpg", 100, 400, false, true);
	}
}
