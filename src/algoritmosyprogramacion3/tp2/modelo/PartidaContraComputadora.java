package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

public class PartidaContraComputadora extends Partida {

	private Jugable computadora;
	
	public PartidaContraComputadora(String nombrePartida, boolean conFlor, String nombreJugador) {
		
		super(nombrePartida);
		
		this.initialize(nombreJugador, conFlor);
	}
	
	private void initialize(String nombreJugador, boolean conFlor) {
		
		Mesa mesaDeDos;
		
		List<Jugable> jugadores = new LinkedList<Jugable>();
		
		Equipo equipoJugador = new Equipo();
		Jugable nuevoJugador = new Jugador(nombreJugador);
		equipoJugador.agregarIntegrante(nuevoJugador);
		jugadores.add(nuevoJugador);
		
		Equipo equipoComputadora = new Equipo();
		this.computadora = new ComputadoraAI();
		equipoComputadora.agregarIntegrante(this.computadora);
		jugadores.add(this.computadora);
		
		if (conFlor) mesaDeDos = new MesaConFlor(jugadores);
		else mesaDeDos = new MesaSinFlor(jugadores);
		this.moderador = new Moderador(mesaDeDos);
		this.moderador.setPartida(this);
		this.moderador.setRotacionStrategy(new StrategyRotacionEnRonda(jugadores));
		
		nuevoJugador.setModerador(moderador);
		nuevoJugador.setMesa(moderador.getMesa());
		
		this.computadora.setModerador(moderador);
		this.computadora.setMesa(moderador.getMesa());
		
		for (Jugable jugador : jugadores) {
			this.jugadores.put(jugador.getNombre(), jugador);
		}
	}

	@Override
	protected void verificarEstrategiaDeRotacion() {
		// No verifica ninguna estrategia ya que la ronda es la única que hay
	}

	@Override
	public boolean esContraComputadora() {
		return true;
	}
}
