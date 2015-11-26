package algoritmosyprogramacion3.tp2.modelo;

public class SeisDeBasto extends Seis {

	public SeisDeBasto() {
			
		super();
		this.palo = new Basto();
		this.imagen = new Imagen("file:resources/imagenes/cartas/basto/seis-de-basto.jpg", 100, 400, false, true);
	}
}
