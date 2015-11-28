package algoritmosyprogramacion3.tp2.modelo;

public class DosDeOro extends Dos {

	public DosDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Imagen("file:resources/imagenes/cartas/oro/dos-de-oro.jpg", 75, 150, false, true);
	}
}
