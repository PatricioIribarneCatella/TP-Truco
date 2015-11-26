package algoritmosyprogramacion3.tp2.modelo;

public class CaballoDeCopa extends Caballo {

	public CaballoDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/once-de-copa.jpg", 100, 400, false, true);
	}
}
