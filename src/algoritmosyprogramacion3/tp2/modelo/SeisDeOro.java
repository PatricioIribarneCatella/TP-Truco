package algoritmosyprogramacion3.tp2.modelo;

public class SeisDeOro extends Seis{
	
	public SeisDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Imagen("file:resources/imagenes/cartas/oro/seis-de-oro.jpg", 100, 400, false, true);	
	}
}
