package algoritmosyprogramacion3.tp2.modelo;

public abstract class Palo {

	protected String valor;
	
	public static Palo ORO = new Oro();
	public static Palo BASTO = new Basto();
	public static Palo COPA = new Copa();
	public static Palo ESPADA = new Espada();
	
	public static boolean compararPalos(Palo palo1, Palo palo2) {
		return palo1.getValor().equals(palo2.getValor());
	}
	
	public String getValor() {
		return this.valor;
	}
}
