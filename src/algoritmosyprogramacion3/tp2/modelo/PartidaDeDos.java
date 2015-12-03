package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

public class PartidaDeDos extends Partida {
	
	public PartidaDeDos(String nombrePartida, boolean conFlor, List<String> nombresJugadores) {
		
		super(nombrePartida);
		
		this.initialize(nombresJugadores, conFlor);
	}
	
	private void initialize(List<String> nombresJugadores, boolean conFlor) {
		
		Mesa mesaDeDos;
		
		List<Jugable> jugadores = new LinkedList<Jugable>();
		
		for (String nombreJugador : nombresJugadores) {
			
			Equipo equipo = new Equipo();
			Jugable jugador = new Jugador(nombreJugador);
			equipo.agregarIntegrante(jugador);
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
	protected void verificarEstrategiaDeRotacion() {
		// No verifica ninguna estrategia ya que la ronda es la única que hay
	}
}
