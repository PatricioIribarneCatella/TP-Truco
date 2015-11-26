package algoritmosyprogramacion3.tp2.modelo;

public class TresDeOro extends Tres {

	public TresDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Imagen("file:resources/imagenes/cartas/oro/tres-de-oro.jpg", 100, 400, false, true);
	}
}
