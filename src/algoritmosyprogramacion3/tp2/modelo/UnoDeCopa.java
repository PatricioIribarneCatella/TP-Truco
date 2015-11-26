package algoritmosyprogramacion3.tp2.modelo;

public class UnoDeCopa extends UnoFalso{
	
	public UnoDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/uno-de-copa.jpg", 100, 400, false, true);	
	}
}
