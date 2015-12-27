package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

public abstract class PartidaPorTurnos extends Partida {

	public PartidaPorTurnos(String nombrePartida, List<String> jugadoresEquipo1, List<String> jugadoresEquipo2) {
		
		super(nombrePartida);
		this.initialize(jugadoresEquipo1, jugadoresEquipo2);
	}

	private void initialize(List<String> jugadoresEquipo1, List<String> jugadoresEquipo2) {
		
		List<Jugable> jugadores = new LinkedList<Jugable>();
		
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		
		for (int i = 0; i < jugadoresEquipo1.size(); i++) {
			
			Jugable jugador1 = new Jugador(jugadoresEquipo1.get(i));
			Jugable jugador2 = new Jugador(jugadoresEquipo2.get(i));
			
			jugadores.add(jugador1);
			jugadores.add(jugador2);
		}
		
		for (int i = 0, j = 1; i < jugadores.size() && j < jugadores.size(); i = i + 2, j = j + 2) {
			
			equipo1.agregarIntegrante(jugadores.get(i));
			equipo2.agregarIntegrante(jugadores.get(j));
		}
		
		Mesa mesa = new Mesa(jugadores);
		
		this.moderador = new Moderador(mesa);
		this.moderador.setPartida(this);
		this.moderador.setRotacionStrategy(new StrategyRotacionEnRonda(jugadores));
		
		for (Jugable jugador : jugadores) {
			
			jugador.setModerador(moderador);
			jugador.setMesa(moderador.getMesa());
			this.jugadores.put(jugador.getNombre(), jugador);
		}
		
		this.setConfiguracionDeLaRotacion(jugadores, equipo1, equipo2);
	}

	protected abstract void setConfiguracionDeLaRotacion(List<Jugable> jugadores, Equipo equipo1, Equipo equipo2);
	
	@Override
	public boolean esContraComputadora() {
		return false;
	}
	
	@Override
	public void repartirCartas() {
		super.repartirCartas();
	}
}
