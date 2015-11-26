package algoritmosyprogramacion3.tp2.modelo;

public class UnoDeEspada extends Carta {

	public UnoDeEspada() {
		
		super();
		this.palo = new Espada();
		this.valorEnvido = 1;
		this.valorFlor = 1;
		this.valorComoString = "1";
		this.imagen = new Imagen("file:resources/imagenes/cartas/espada/uno-de-espada.jpg", 100, 400, false, true);
	}
	
	@Override
	public Carta jugarContra(Carta carta) {
		return carta.jugarContra(this);
	}

	@Override
	public Carta jugarContra(UnoDeBasto unoDeBasto) {
		return this;
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
		return this;
	}
}
