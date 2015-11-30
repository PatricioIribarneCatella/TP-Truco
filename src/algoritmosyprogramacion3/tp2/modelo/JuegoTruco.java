package algoritmosyprogramacion3.tp2.modelo;

import java.util.HashMap;
import java.util.List;

public class JuegoTruco {
	
	private Partida partidaActual;
	private HashMap<String,Partida> partidasDisponibles;
	
	public JuegoTruco() {
		this.partidasDisponibles = new HashMap<String,Partida>();
	}

	public boolean nuevaMesaContraComputadoraSinFlor(String nombreMesa, String nombreJugador) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaContraComputadora(nombreMesa, Flor.SIN_FLOR, nombreJugador);
		this.partidaActual = nuevaPartida;
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaContraComputadoraConFlor(String nombreMesa, String nombreJugador) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaContraComputadora(nombreMesa, Flor.CON_FLOR, nombreJugador);
		this.partidaActual = nuevaPartida;
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}	
	
	public boolean nuevaMesaDeDosSinFlor(String nombreMesa, List<String> jugadores) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeDos(nombreMesa, Flor.SIN_FLOR, jugadores);
		this.partidaActual = nuevaPartida;
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}

	public boolean nuevaMesaDeDosConFlor(String nombreMesa, List<String> jugadores) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeDos(nombreMesa, Flor.CON_FLOR, jugadores);
		this.partidaActual = nuevaPartida;
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeCuatroSinFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeCuatro(nombreMesa, Flor.SIN_FLOR, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeCuatroConFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeCuatro(nombreMesa, Flor.CON_FLOR, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeSeisSinFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeSeis(nombreMesa, Flor.SIN_FLOR, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeSeisConFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeSeis(nombreMesa, Flor.CON_FLOR, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean cantarTrucoPorJugador(String nombreJugador) {
		return false;
	}

	public boolean cantarReTrucoPorJugador(String nombreJugador) {
		return false;
	}
	
	public boolean cantarValeCuatroPorJugador(String nombreJugador) {
		return false;
	}
	
	public boolean cantarEnvidoPorJugador(String nombreJugador) {
		return false;
	}
	
	public boolean cantarRealEnvidoPorJugador(String nombreJugador) {
		return false;
	}
	
	public boolean cantarFaltaEnvidoPorJugador(String nombreJugador) {
		return false;
	}
	
	public boolean cantarFlorPorJugador(String nombreJugador) {
		return false;
	}
	
	public boolean aceptarVarianteEnvidoPorJugador(String nombreJugador) {
		return false;
	}
	
	public boolean aceptarVarianteTrucoPorJugador(String nombreJugador) {
		return false;
	}
	
	public boolean rechazarVarianteEnvidoPorJugador(String nombreJugador) {
		return false;
	}
	
	public boolean rechazarVarianteTrucoPorJugador(String nombreJugador) {
		return false;
	}

	public String mostrarPuntosDeJugador(String nombreJugador) {
		return null;
	}

	public String mostrarPuntosEnvido(String nombreJugador) {
		return null;
	}
	
	public String mostrarPuntosFlor(String nombreJugador) {
		return null;
	}
	
	public boolean jugarPrimerCartaDeJugador(String nombreJugador) {
		return false;
	}
	
	public boolean jugarSegundaCartaDeJugador(String nombreJugador) {
		return false;
	}
	
	public boolean jugarTercerCartaDeJugador(String nombreJugador) {
		return false;
	}
	
	// Reparte cartas de forma aleatoria
	public void repartirCartas() {
		this.partidaActual.repartirCartas();
	}
	
	// Reparte las cartas que se le pasan como parámetro siempre en ese mismo orden
	public void repartirCartas(List<Carta> listaCartas) {
		
		listaCartas.forEach(x -> { x.entregada(); });
		this.partidaActual.repartirCartas(listaCartas);
	}
	
	public List<Carta> getCartasJugadorConTurno() {
		return this.partidaActual.getCartasJugadorConTurno();
	}
}
