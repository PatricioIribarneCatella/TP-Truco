package algoritmosyprogramacion3.tp2.modelo;

public class Dos extends Carta {

	public Dos() {
		
		super();
		this.initialize();
	}
	
	public Dos(Palo palo) {
		
		super();
		this.initialize();
		this.palo = palo;
	}
	
	private void initialize() {
		
		this.valorEnvido = 2;
		this.valorFlor = 2;
		this.valorComoString = "2";
	}
	
	@Override
	public Carta jugarContra(Carta carta) {
		return carta.jugarContra(this);
	}
	
	@Override
	public Carta jugarContra(UnoFalso uno) {
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
	public Carta jugarContra(Dos dos) {
		return this;
	}
}
