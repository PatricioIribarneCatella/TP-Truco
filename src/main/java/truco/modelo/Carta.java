package algoritmosyprogramacion3.tp2.modelo;

public abstract class Carta {

	protected Palo palo;
	protected String valorComoString;
	protected int valorEnvido;
	protected int valorFlor;
	protected LugarCarta lugar;
	
	public Carta() {
		
		this.lugar = new EnMazo();
	}
	
	public boolean estaEnUnLugarValidoParaSerJugada() {
		
		return this.lugar.sosValidoParaQueSeJuegueLaCarta();
	}
	
	public Palo getPalo() {
		return this.palo;
	}

	public int getValorFlor() {
		return this.valorFlor;
	}
	
	public int getValorEnvido() {
		return this.valorEnvido;
	}
	
	public String getValorComoString() {
		return this.valorComoString;
	}
	
	public int getValor() {
		return Integer.parseInt(valorComoString);
	}
	
	public void pasaAEstar(LugarCarta nuevoLugar) {
		this.lugar = nuevoLugar;
	}
	
	@Override
	public int hashCode() {
		return this.valorComoString.hashCode() + this.palo.getValor().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof Carta)) return false;
		if (o == this) return true;
		
		Carta c = (Carta) o;
		
		return (this.valorComoString.equals(c.getValorComoString()) && this.palo.getValor().equals(c.getPalo().getValor()));
	}
	
	public abstract Carta jugarContra(Carta carta);
	
	public abstract Carta jugarContra(UnoDeEspada unoDeEspada);
	
	public abstract Carta jugarContra(UnoDeBasto unoDeBasto);
	
	public abstract Carta jugarContra(SieteDeEspada sieteDeEspada);
	
	public abstract Carta jugarContra(SieteDeOro sieteDeOro);
	
	public abstract Carta jugarContra(Tres tres);
	
	public abstract Carta jugarContra(Dos dos);
	
	public abstract Carta jugarContra(UnoFalso unoFalso);
	
	public abstract Carta jugarContra(Rey rey);
	
	public abstract Carta jugarContra(Caballo caballo);
	
	public abstract Carta jugarContra(Sota sota);
	
	public abstract Carta jugarContra(SieteFalso sieteFalso);
	
	public abstract Carta jugarContra(Seis sseis);
	
	public abstract Carta jugarContra(Cinco cinco);
	
	public abstract Carta jugarContra(Cuatro cuatro);
}
