package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

public class PartidaDeSeis extends Partida {
	
	private Equipo equipo1;
	private Equipo equipo2;
	private ManejadorRotacion manejoDeRotacion;
	
	public PartidaDeSeis(String nombrePartida, boolean conFlor, List<String> nombresJugadoresEquipo1, List<String> nombresJugadoresEquipo2) {
		
		super(nombrePartida);
		
		this.initialize(nombresJugadoresEquipo1, nombresJugadoresEquipo2, conFlor);
	}
	
	private void initialize(List<String> nombresJugadoresEquipo1, List<String> nombresJugadoresEquipo2, boolean conFlor) {
		
	    Mesa mesaDeSeis;
		
		List<Jugable> jugadores = new LinkedList<Jugable>();
		
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		
		Jugable jugador1 = new Jugador(nombresJugadoresEquipo1.get(0));
		Jugable jugador2 = new Jugador(nombresJugadoresEquipo2.get(0));
		Jugable jugador3 = new Jugador(nombresJugadoresEquipo1.get(1));
		Jugable jugador4 = new Jugador(nombresJugadoresEquipo2.get(1));
		Jugable jugador5 = new Jugador(nombresJugadoresEquipo1.get(2));
		Jugable jugador6 = new Jugador(nombresJugadoresEquipo2.get(2));
		
		equipo1.agregarIntegrante(jugador1);
		equipo1.agregarIntegrante(jugador3);
		equipo1.agregarIntegrante(jugador5);
		equipo2.agregarIntegrante(jugador2);
		equipo2.agregarIntegrante(jugador4);
		equipo2.agregarIntegrante(jugador6);
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);
		jugadores.add(jugador5);
		jugadores.add(jugador6);
		
		
		if (conFlor) mesaDeSeis = new MesaConFlor(jugadores);
		else mesaDeSeis = new MesaSinFlor(jugadores);
		this.moderador = new Moderador(mesaDeSeis);
		this.moderador.setPartida(this);
		this.moderador.setRotacionStrategy(new StrategyRotacionEnRonda(jugadores));
		
		for (Jugable jugador : jugadores) {
			
			jugador.setModerador(moderador);
			jugador.setMesa(moderador.getMesa());
			this.jugadores.put(jugador.getNombre(), jugador);
		}
		
		this.manejoDeRotacion = new ManejadorRotacion(jugadores);
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	@Override
	protected void verificarEstrategiaDeRotacion() {
		
		this.manejoDeRotacion.verificarEstrategiaDeRotacion(this.equipo1, this.equipo2);
		RotacionStrategy rotacion = this.manejoDeRotacion.getRotacion();
		this.moderador.setRotacionStrategy(rotacion);
	}

	@Override
	public boolean esContraComputadora() {
		return false;
	}
}
