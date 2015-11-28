package algoritmosyprogramacion3.tp2.modelo;

public class UnoDeOro extends UnoFalso{
	
	public UnoDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Imagen("file:resources/imagenes/cartas/oro/uno-de-oro.jpg", 75, 150, false, true);	
	}
}
