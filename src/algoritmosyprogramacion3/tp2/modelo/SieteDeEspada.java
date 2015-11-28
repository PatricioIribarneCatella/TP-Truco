package algoritmosyprogramacion3.tp2.modelo;

public class SieteDeEspada extends Carta {

	public SieteDeEspada() {
		
		super();
		this.palo = new Espada();
		this.valorEnvido = 7;
		this.valorFlor = 7;
		this.valorComoString = "7";
		this.imagen = new Imagen("file:resources/imagenes/cartas/espada/siete-de-espada.jpg", 75, 150, false, true);
	}
	
	@Override
	public Carta jugarContra(Carta carta) {
		return carta.jugarContra(this);
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
	public Carta jugarContra(UnoDeBasto unoDeBasto) {
		return unoDeBasto;
	}
	
	@Override
	public Carta jugarContra(UnoDeEspada unoDeEspada) {
		return unoDeEspada;
	}
	
	@Override
	public Carta jugarContra(SieteDeEspada sieteDeEspada) {
		return this;
	}
}
