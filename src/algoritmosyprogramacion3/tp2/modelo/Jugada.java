package algoritmosyprogramacion3.tp2.modelo;

import java.util.HashMap;

public class Jugada {
	
	private HashMap<Carta, Jugable> jugadoresCartas;
	
	public Jugada() {
		this.jugadoresCartas = new HashMap<Carta, Jugable>();
	}

	public Resultado confrontar(Jugable jugador1, Jugable jugador2) {
		
		Resultado resultado;
		
		Carta carta1 = jugador1.getCartaJugada();
		Carta carta2 = jugador2.getCartaJugada();
		
		this.jugadoresCartas.put(carta1, jugador1);
		this.jugadoresCartas.put(carta2, jugador2);
		
		Carta cartaGanadora1 = carta1.jugarContra(carta2);
		Carta cartaGanadora2 = carta2.jugarContra(carta1);
		
		if (cartaGanadora1.equals(cartaGanadora2)) {
			
			Jugable jugadorGanador = this.jugadoresCartas.get(cartaGanadora1);
			resultado = new GanoJugable(jugadorGanador);
			
		} else {
			
			resultado = new Empate();
		}
		
		return resultado;
	}
}
