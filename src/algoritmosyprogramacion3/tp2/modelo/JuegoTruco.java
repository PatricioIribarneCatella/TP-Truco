package algoritmosyprogramacion3.tp2.modelo;

import java.util.HashMap;
import java.util.List;

public class JuegoTruco {
	
	private Mesa mesaActual;
	private HashMap<String,Mesa> mesasDisponibles;

	public void nuevaMesaDeDosSinFlor(String nombreMesa, List<String> jugadores) {
		
	}

	public void nuevaMesaDeDosConFlor(String nombreMesa, List<String> jugadores) {
		
	}
	
	public void nuevaMesaDeCuatroSinFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
	}
	
	public void nuevaMesaDeCuatroConFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
	}
	
	public void nuevaMesaDeSeisSinFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
	}
	
	public void nuevaMesaDeSeisConFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
	}
	
	public boolean cantarTrucoPorJugador(String jugador) {
		return false;
	}

	public boolean cantarReTrucoPorJugador(String jugador) {
		return false;
	}
	
	public boolean cantarValeCuatroPorJugador(String jugador) {
		return false;
	}
	
	public boolean cantarEnvidoPorJugador(String jugador) {
		return false;
	}
	
	public boolean cantarRealEnvidoPorJugador(String jugador) {
		return false;
	}
	
	public boolean cantarFaltaEnvidoPorJugador(String jugador) {
		return false;
	}
	
	public boolean cantarFlorPorJugador(String jugador) {
		return false;
	}
	
	public boolean aceptarVarianteEnvidoPorJugador(String jugador) {
		return false;
	}
	
	public boolean aceptarVarianteTrucoPorJugador(String jugador) {
		return false;
	}
	
	public boolean rechazarVarianteEnvidoPorJugador(String jugador) {
		return false;
	}
	
	public boolean rechazarVarianteTrucoPorJugador(String jugador) {
		return false;
	}

	public String mostrarPuntosDeJugador(String string) {
		return null;
	}

	public String mostrarPuntosEnvido(String jugador) {
		return null;
	}
	
	public String mostrarPuntosFlor(String jugador) {
		return null;
	}
	
	public boolean jugarPrimerCartaDeJugador(String jugador) {
		return false;
	}
	
	public boolean jugarSegundaCartaDeJugador(String jugador) {
		return false;
	}
	
	public boolean jugarTercerCartaDeJugador(String jugador) {
		return false;
	}
	
	// Reparte cartas de forma aleatoria
	public void repartirCartas() {
		
	}
	
	// Reparte las cartas que se le pasan como parámetro siempre en ese mismo orden
	public void repartirCartas(List<Carta> listaCartas) {
		
		listaCartas.forEach(x -> { x.entregada(); });
	}
}
