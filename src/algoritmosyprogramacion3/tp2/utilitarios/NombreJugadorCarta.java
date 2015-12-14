package algoritmosyprogramacion3.tp2.utilitarios;

import algoritmosyprogramacion3.tp2.modelo.Carta;

public class NombreJugadorCarta {

	private String nombreJugador;
	private Carta carta;

	public NombreJugadorCarta(String nombreJugador, Carta carta) {
		
		this.nombreJugador = nombreJugador;
		this.carta = carta;
	}

	public String getNombreJugador() {
		return this.nombreJugador;
	}
	
	public Carta getCarta() {
		return this.carta;
	}
}
