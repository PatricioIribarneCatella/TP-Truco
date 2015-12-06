package algoritmosyprogramacion3.tp2.modelo;

public abstract class SieteFalso extends Siete {

	public SieteFalso() {
		super();
	}
	
	@Override
	public Carta jugarContra(Carta carta) {
		return carta.jugarContra(this);
	}
	
	@Override
	public Carta jugarContra(Seis seis) {
		return this;
	}
	
	@Override
	public Carta jugarContra(Cinco cinco) {
		return this;
	}
	
	@Override
	public Carta jugarContra(Cuatro cuatro) {
		return this;
	}
	
	@Override
	public Carta jugarContra(Sota sota) {
		return sota;
	}
	
	@Override
	public Carta jugarContra(Caballo caballo) {
		return caballo;
	}
	
	@Override
	public Carta jugarContra(Rey rey) {
		return rey;
	}
	
	@Override
	public Carta jugarContra(UnoFalso uno) {
		return uno;
	}
	
	@Override
	public Carta jugarContra(Dos dos) {
		return dos;
	}
	
	@Override
	public Carta jugarContra(Tres tres) {
		return tres;
	}
	
	@Override
	public Carta jugarContra(UnoDeEspada unoDeEspada) {
		return unoDeEspada;
	}
	
	@Override
	public Carta jugarContra(UnoDeBasto unoDeBasto) {
		return unoDeBasto;
	}
	
	@Override
	public Carta jugarContra(SieteDeEspada sieteDeEspada) {
		return sieteDeEspada;
	}
	
	@Override
	public Carta jugarContra(SieteDeOro sieteDeOro) {
		return sieteDeOro;
	}
	
	@Override
	public Carta jugarContra(SieteFalso sieteFalso) {
		return this;
	}
}
