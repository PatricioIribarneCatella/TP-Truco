package algoritmosyprogramacion3.tp2.modelo;

public class SotaDeOro extends Sota {

	public SotaDeOro() {
		
		super();
		this.palo = new Oro();
		this.imagen = new Imagen("file:resources/imagenes/cartas/oro/diez-de-oro.jpg", 75, 150, false, true);
	}
}
