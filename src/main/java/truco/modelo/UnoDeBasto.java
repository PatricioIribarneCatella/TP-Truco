package truco.modelo;

public class UnoDeBasto extends Uno {

	public UnoDeBasto() {
		
		super();
		this.palo = new Basto();
	}
	
	@Override
	public Carta jugarContra(Carta carta) {
		return carta.jugarContra(this);
	}

	@Override
	public Carta jugarContra(SieteDeEspada sieteDeEspada) {
		return this;
	}

	@Override
	public Carta jugarContra(SieteDeOro sieteDeOro) {
		return this;
	}

	@Override
	public Carta jugarContra(Tres tres) {
		return this;
	}

	@Override
	public Carta jugarContra(Dos dos) {
		return this;
	}

	@Override
	public Carta jugarContra(UnoFalso unoFalso) {
		return this;
	}

	@Override
	public Carta jugarContra(Rey rey) {
		return this;
	}

	@Override
	public Carta jugarContra(Caballo caballo) {
		return this;
	}

	@Override
	public Carta jugarContra(Sota sota) {
		return this;
	}

	@Override
	public Carta jugarContra(SieteFalso sieteFalso) {
		return this;
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
	public Carta jugarContra(UnoDeEspada unoDeEspada) {
		return unoDeEspada;
	}
	
	@Override
	public Carta jugarContra(UnoDeBasto unoDeBasto) {
		return this;
	}
}
