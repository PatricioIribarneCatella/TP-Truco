package algoritmosyprogramacion3.tp2.modelo;

public class CincoDeCopa extends Cinco {

	public CincoDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/cinco-de-copa.jpg", 100, 400, false, true);
	}
}
