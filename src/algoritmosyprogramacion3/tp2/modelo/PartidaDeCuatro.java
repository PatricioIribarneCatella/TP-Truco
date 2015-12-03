package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

public class PartidaDeCuatro extends Partida {
	
	public PartidaDeCuatro(String nombrePartida, boolean conFlor, List<String> nombresJugadoresEquipo1, List<String> nombresJugadoresEquipo2) {
		
		super(nombrePartida);
		
		this.initialize(nombresJugadoresEquipo1, nombresJugadoresEquipo2, conFlor);
	}
	
	private void initialize(List<String> nombresJugadoresEquipo1, List<String> nombresJugadoresEquipo2, boolean conFlor) {
		
		Mesa mesaDeCuatro;
		
		List<Jugable> jugadores = new LinkedList<Jugable>();
		
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		
		Jugable jugador1 = new Jugador(nombresJugadoresEquipo1.get(0));
		Jugable jugador2 = new Jugador(nombresJugadoresEquipo2.get(0));
		Jugable jugador3 = new Jugador(nombresJugadoresEquipo1.get(1));
		Jugable jugador4 = new Jugador(nombresJugadoresEquipo2.get(1));
		equipo1.agregarIntegrante(jugador1);
		equipo1.agregarIntegrante(jugador3);
		equipo2.agregarIntegrante(jugador2);
		equipo2.agregarIntegrante(jugador4);
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);
				
		
		if (conFlor) mesaDeCuatro = new MesaConFlor(jugadores);
		else mesaDeCuatro = new MesaSinFlor(jugadores);
		this.moderador = new Moderador(mesaDeCuatro);
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

	@Override
	public boolean esContraComputadora() {
		return false;
	}
}
