package algoritmosyprogramacion3.tp2.modelo;

public abstract class Carta {

	protected Palo palo;
	protected String valorComoString;
	protected int valorEnvido;
	protected int valorFlor;
	protected int jerarquia;
	protected EstadoDeCarta estado;
	
	public Carta() {
		
		this.estado = new EnMazo();
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
	
	public int getJerarquia() {
		return this.jerarquia;
	}
	
	public void entregada() {
		
		this.estado = this.estado.proximoEstado();
	}
	
	public void jugate() {
		
		if (this.estado.esValidoParaSerJugada()) this.estado = this.estado.proximoEstado();
	}
	
	public void volveAlMazo() {
		
		this.estado = new EnMazo();
	}
	
	/* Compara las jerarquias entre las cartas. Devuelve 1 si la carta de un jugador es mayor que la que del otro,
 	-1 en caso contrario, o 0 si son de igual jerarquía. */
	public int compararCarta(Carta carta) {
		
		if (this.jerarquia < carta.getJerarquia()) return 1;
		
		if (this.jerarquia > carta.getJerarquia()) return -1;
		
		return 0;
	}
	
<<<<<<< HEAD
	public boolean esValidaParaSerJugada() {
		
=======
	public boolean esValidaParaSerJugada()
	{
>>>>>>> 7f99c0e1b7cce48787f92ed15b9dc3f8267dd501
		return this.estado.esValidoParaSerJugada();
	}
}
