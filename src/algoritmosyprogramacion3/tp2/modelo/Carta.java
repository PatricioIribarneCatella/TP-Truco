package algoritmosyprogramacion3.tp2.modelo;

public abstract class Carta {

	private Palo palo;
	
	public Palo getPalo() {
		return this.palo;
	}

	public abstract int getValorFlor();
	
	public abstract int getValorEnvido();
}
