package algoritmosyprogramacion3.tp2.modelo;

public class CincoDeOro extends Cinco {

	public CincoDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Imagen("file:resources/imagenes/cartas/oro/cinco-de-oro.jpg", 75, 150, false, true);
	}
}
