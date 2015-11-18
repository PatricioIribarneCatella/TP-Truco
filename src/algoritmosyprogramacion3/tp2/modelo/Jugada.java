package algoritmosyprogramacion3.tp2.modelo;

import java.util.HashMap;

public class Jugada {
	
	private HashMap<Carta, Jugable> jugadoresCartas;
	
	public Jugada() {
		this.jugadoresCartas = new HashMap<Carta, Jugable>();
	}

	public Jugable confrontar(Jugable jugador1, Jugable jugador2) {
		
		Carta carta1 = jugador1.getCartaJugada();
		Carta carta2 = jugador2.getCartaJugada();
		
		this.jugadoresCartas.put(carta1, jugador1);
		this.jugadoresCartas.put(carta2, jugador2);
		
		Carta cartaGanadora = carta1.jugarContra(carta2);
		
		Jugable jugadorGanador = this.jugadoresCartas.get(cartaGanadora);
		
		return jugadorGanador;
	}
}
