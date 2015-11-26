package algoritmosyprogramacion3.tp2.modelo;

public class SeisDeCopa extends Seis {
	
	public SeisDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/seis-de-copa.jpg", 100, 400, false, true);	
	}
}
