package algoritmosyprogramacion3.tp2.modelo;

public abstract class Palo {

	protected String valor;
	
	public String getValor() {
		return this.valor;
	}
	
	public boolean compararCon(Palo palo) {
		
		if (palo.getValor().equals(this.valor)) return true;
		
		return false;
	}
}
