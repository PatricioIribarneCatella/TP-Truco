package truco.modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Jugada {
	
	private HashMap<Carta, Jugable> jugadoresCartas;
	
	public Jugada() {
		this.jugadoresCartas = new HashMap<Carta, Jugable>();
	}

	private Resultado confrontarEquipos(List<Jugable> listaJugadores) {
	
		Resultado resultado;
		
		List<Carta> cartasEquipo1 = new LinkedList<Carta>();
		List<Carta> cartasEquipo2 = new LinkedList<Carta>();
		
		List<Jugable> equipoJugadores1 = new LinkedList<Jugable>();
		List<Jugable> equipoJugadores2 = new LinkedList<Jugable>();
		
		for (int i = 0; i < listaJugadores.size()-1; i += 2) {
			
			equipoJugadores1.add(listaJugadores.get(i));
			int j = i;
			j++;
			equipoJugadores2.add(listaJugadores.get(j));
		}
		
		for (Jugable jugador : equipoJugadores1) {
			cartasEquipo1.add(jugador.getCartaJugada());
		}
		
		for (Jugable jugador : equipoJugadores2) {
			cartasEquipo2.add(jugador.getCartaJugada());
		}
		
		Optional<Carta> maximo1 = cartasEquipo1.stream().max(new ComparadorCartasTruco());
		Optional<Carta> maximo2 = cartasEquipo2.stream().max(new ComparadorCartasTruco());
		
		Carta carta1 = maximo1.get();
		Carta carta2 = maximo2.get();
		
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
	
	public Resultado confrontar(List<Jugable> listaJugadores) {
		
		for (Jugable jugador : listaJugadores) {
			Carta carta = jugador.getCartaJugada();
			this.jugadoresCartas.put(carta, jugador);
		}
		
		return this.confrontarEquipos(listaJugadores);
	}
}
