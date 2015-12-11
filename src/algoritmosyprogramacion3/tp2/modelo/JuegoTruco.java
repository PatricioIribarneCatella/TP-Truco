package algoritmosyprogramacion3.tp2.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.CantidadDeEnvidosMaximosSuperadaException;
import algoritmosyprogramacion3.tp2.excepciones.CartaYaJugadaException;
import algoritmosyprogramacion3.tp2.excepciones.JugadorSinFlorException;
import algoritmosyprogramacion3.tp2.excepciones.PartidaSinFlorException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;

public class JuegoTruco extends Observable {
	
	private Partida partidaActual;
	private HashMap<String,Partida> partidasDisponibles;
	
	public JuegoTruco() {
		this.partidasDisponibles = new HashMap<String,Partida>();
	}
	
	private void actualizarObservadores() {
		setChanged();
		notifyObservers();
	}

	public boolean nuevaMesaContraComputadoraSinFlor(String nombreMesa, String nombreJugador) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaContraComputadora(nombreMesa, Flor.SIN_FLOR, nombreJugador);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaContraComputadoraConFlor(String nombreMesa, String nombreJugador) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaContraComputadora(nombreMesa, Flor.CON_FLOR, nombreJugador);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}	
	
	public boolean nuevaMesaDeDosSinFlor(String nombreMesa, List<String> jugadores) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeDos(nombreMesa, Flor.SIN_FLOR, jugadores);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}

	public boolean nuevaMesaDeDosConFlor(String nombreMesa, List<String> jugadores) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeDos(nombreMesa, Flor.CON_FLOR, jugadores);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeCuatroSinFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeCuatro(nombreMesa, Flor.SIN_FLOR, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeCuatroConFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeCuatro(nombreMesa, Flor.CON_FLOR, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeSeisSinFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeSeis(nombreMesa, Flor.SIN_FLOR, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeSeisConFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaDeSeis(nombreMesa, Flor.CON_FLOR, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean cantarTrucoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarTruco(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}

	public boolean cantarReTrucoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarReTruco(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean cantarValeCuatroPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarValeCuatro(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean cantarEnvidoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarEnvido(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean cantarRealEnvidoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarRealEnvido(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean cantarFaltaEnvidoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarFaltaEnvido(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean cantarFlorPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarFlor(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		} catch (JugadorSinFlorException | AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException | PartidaSinFlorException e) {
			
			throw e;
		}
	}
	
	public boolean aceptarFlorPorJugador(String nombreJugador){
		
		try {
			this.partidaActual.aceptarFlor(nombreJugador);
			this.actualizarObservadores();
			return true;
		}
		catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean aceptarVarianteEnvidoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.aceptarVarianteEnvido(nombreJugador);
			this.actualizarObservadores();
			return true;
		}
		catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException | CantidadDeEnvidosMaximosSuperadaException e) {
			
			throw e;
		}
	}
	
	public boolean aceptarTrucoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.aceptarTruco(nombreJugador);
			this.actualizarObservadores();
			return true;
		}
		catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean aceptarReTrucoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.aceptarReTruco(nombreJugador);
			this.actualizarObservadores();
			return true;
		}
		catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean aceptarValeCuatroPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.aceptarValeCuatro(nombreJugador);
			this.actualizarObservadores();
			return true;
		}
		catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean rechazarFlorPorJugador(String nombreJugador){
		
		try {
			this.partidaActual.rechazarFlor(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		}catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean rechazarVarianteEnvidoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.rechazarVarianteDeEnvido(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		}catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean rechazarVarianteTrucoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.rechazarVarianteDeTruco(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		}catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}

	public String mostrarPuntosDeJugador(String nombreJugador) {
		
		return this.partidaActual.mostrarPuntosJugador(nombreJugador);
	}

	public String mostrarPuntosEnvido(String nombreJugador) {
		
		return this.partidaActual.mostrarPuntosEnvido(nombreJugador);
	}
	
	public String mostrarPuntosFlor(String nombreJugador) {
		
		return this.partidaActual.mostrarPuntosFlor(nombreJugador);
	}
	
	public boolean jugarPrimerCartaDeJugador(String nombreJugador) {
		
		try {
			this.partidaActual.jugarPrimerCartaJugador(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		} catch (TurnoEquivocadoException | AccionInvalidaException | CartaYaJugadaException e) {
			
			throw e;
		}
	}
	
	public boolean jugarSegundaCartaDeJugador(String nombreJugador) {
		
		try {
			this.partidaActual.jugarSegundaCartaJugador(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		} catch (TurnoEquivocadoException | AccionInvalidaException | CartaYaJugadaException e) {
			
			throw e;
		}
	}
	
	public boolean jugarTercerCartaDeJugador(String nombreJugador) {
		
		try {
			this.partidaActual.jugarTercerCartaJugador(nombreJugador);
			this.actualizarObservadores();
			return true;
			
		} catch (TurnoEquivocadoException | AccionInvalidaException | CartaYaJugadaException e) {
			
			throw e;
		}
	}
	
	// Reparte cartas de forma aleatoria
	public void repartirCartas() {
		
		this.partidaActual.repartirCartas();
		this.actualizarObservadores();
	}
	
	// Reparte las cartas que se le pasan como parámetro siempre en ese mismo orden
	public void repartirCartas(List<Carta> listaCartas) {
		
		listaCartas.forEach(x -> { x.pasaAEstar(new EnMano()); });
		this.partidaActual.repartirCartas(listaCartas);
	}
	
	public List<Carta> getCartasJugadorConTurno() {
		return this.partidaActual.getCartasJugadorConTurno();
	}
	
	public Set<String> getMesasDisponilbles() {
		return this.partidasDisponibles.keySet();
	}
	
	public void cargarMesa(String nombreMesa) {
		this.partidaActual = this.partidasDisponibles.get(nombreMesa);
	}

	public String getNombreJugadorActual() {
		return this.partidaActual.getNombreJugadorActual();
	}

	public boolean mesaActualContraComputadora() {
		return this.partidaActual.esContraComputadora();
	}

	public String getCantidadCartasEnManoDeJugador(String nombreJugador) {
		return this.partidaActual.getCantidadCartasEnManoDeJugador(nombreJugador);
	}
	
	public Set<String> getNombresDeJugadores() {
		return this.partidaActual.getNombresDeJugadores();
	}

	public List<NombreJugadorCarta> getCartasYaJugadas() {
		return this.partidaActual.getCartasYaJugadasConJugador();
	}
}
