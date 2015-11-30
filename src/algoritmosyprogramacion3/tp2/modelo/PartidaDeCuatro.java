package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

public class PartidaDeCuatro extends Partida {
	
	public PartidaDeCuatro(String nombrePartida, boolean conFlor, List<String> nombresJugadoresEquipo1, List<String> nombresJugadoresEquipo2) {
		
		super(nombrePartida);
		
		this.initialize(nombresJugadoresEquipo1, nombresJugadoresEquipo2, conFlor);
	}
	
	private void initialize(List<String> nombresJugadoresEquipo1, List<String> nombresJugadoresEquipo2, boolean conFlor) {
		
		Mesa mesaDeDos;
		
		List<Jugable> jugadores = new LinkedList<Jugable>();
		
		Equipo equipo1 = new Equipo();
		
		for (String nombreJugador : nombresJugadoresEquipo1) {
			
			Jugable jugador = new Jugador(nombreJugador);
			equipo1.agregarIntegrante(jugador);
			jugadores.add(jugador);
		}
		
		Equipo equipo2 = new Equipo();
		
		for (String nombreJugador : nombresJugadoresEquipo2) {
			
			Jugable jugador = new Jugador(nombreJugador);
			equipo2.agregarIntegrante(jugador);
			jugadores.add(jugador);
		}
		
		if (conFlor) mesaDeDos = new MesaConFlor(jugadores);
		else mesaDeDos = new MesaSinFlor(jugadores);
		this.moderador = new Moderador(mesaDeDos);
		this.moderador.setPartida(this);
		this.moderador.setRotacionStrategy(new StrategyRotacionEnRonda(jugadores));
		
		for (Jugable jugador : jugadores) {
			
			jugador.setModerador(moderador);
			jugador.setMesa(moderador.getMesa());
			this.jugadores.put(jugador.getNombre(), jugador);
		}
	}

	@Override
	protected void verificarPuntaje() {
		
	}
}