package algoritmosyprogramacion3.tp2.modelo;

public class SeisDeCopa extends Seis {
	
	public SeisDeCopa() {
		
		super();
		this.palo = new Copa();
		this.imagen = new Imagen("file:resources/imagenes/cartas/copa/seis-de-copa.jpg", 75, 150, false, true);	
	}
}
