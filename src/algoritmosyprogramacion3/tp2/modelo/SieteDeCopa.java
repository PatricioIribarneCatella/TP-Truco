package algoritmosyprogramacion3.tp2.modelo;

public class SieteDeCopa extends SieteFalso {

	public SieteDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/siete-de-copa.jpg", 100, 400, false, true);
	}
}
