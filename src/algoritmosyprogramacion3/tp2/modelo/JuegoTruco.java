package algoritmosyprogramacion3.tp2.modelo;

import java.util.HashMap;
import java.util.List;

public class JuegoTruco {
	
	private Mesa mesaActual;
	private HashMap<String,Mesa> mesasDisponibles;

	public void nuevaMesaContraComputadoraSinFlor(String nombreJugador) {
		
	}
	
	public void nuevaMesaContraComputadoraConFlor(String nombreJugador) {
		
	}	
	
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
		
	}
	
	// Reparte las cartas que se le pasan como parámetro siempre en ese mismo orden
	public void repartirCartas(List<Carta> listaCartas) {
		
		listaCartas.forEach(x -> { x.entregada(); });
	}
}
