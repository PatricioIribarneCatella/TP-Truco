package truco.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import java.util.Set;

import truco.excepciones.AccionInvalidaException;
import truco.excepciones.CantidadDeEnvidosMaximosSuperadaException;
import truco.excepciones.CartaYaJugadaException;
import truco.excepciones.JugadorSinFlorException;
import truco.excepciones.PartidaSinFlorException;
import truco.excepciones.TurnoEquivocadoException;
import truco.excepciones.TurnoParaTomarDecisionEquivocadoException;
import truco.utilitarios.NombreJugadorCarta;

public class JuegoTruco {
	
	private Partida partidaActual;
	private HashMap<String,Partida> partidasDisponibles;
	
	public JuegoTruco() {
		this.partidasDisponibles = new HashMap<String,Partida>();
	}

	public void addObserver(Observer o) {
		this.partidaActual.addObserver(o);
	}
	
	private void setChanged() {
		this.partidaActual.setChanged();
	}
	
	private void notifyObservers() {
		this.partidaActual.notifyObservers();
	}
	
	private void actualizar() {
		setChanged();
		notifyObservers();
	}
	
	public boolean nuevaMesaContraComputadoraSinFlor(String nombreMesa, String nombreJugador) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaContraComputadoraSinFlor(nombreMesa, nombreJugador);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaContraComputadoraConFlor(String nombreMesa, String nombreJugador) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaContraComputadoraConFlor(nombreMesa, nombreJugador);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}	
	
	public boolean nuevaMesaDeDosSinFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaRondaSinFlor(nombreMesa, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}

	public boolean nuevaMesaDeDosConFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaRondaConFlor(nombreMesa, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeCuatroSinFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaRondaSinFlor(nombreMesa, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeCuatroConFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaRondaConFlor(nombreMesa, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeSeisSinFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaRondaYPicaPicaSinFlor(nombreMesa, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean nuevaMesaDeSeisConFlor(String nombreMesa, List<String> equipoJugadores1, List<String> equipoJugadores2) {
		
		if (this.partidasDisponibles.containsKey(nombreMesa)) return false;
		
		Partida nuevaPartida = new PartidaRondaYPicaPicaConFlor(nombreMesa, equipoJugadores1, equipoJugadores2);
		this.partidaActual = nuevaPartida;
		this.partidaActual.iniciarPartida();
		this.partidasDisponibles.put(nombreMesa, nuevaPartida);
		return true;
	}
	
	public boolean cantarTrucoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarTruco(nombreJugador);
			actualizar();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}

	public boolean cantarReTrucoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarReTruco(nombreJugador);
			actualizar();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean cantarValeCuatroPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarValeCuatro(nombreJugador);
			actualizar();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean cantarEnvidoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarEnvido(nombreJugador);
			actualizar();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException | CantidadDeEnvidosMaximosSuperadaException e) {
			
			throw e;
		}
	}
	
	public boolean cantarRealEnvidoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarRealEnvido(nombreJugador);
			actualizar();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean cantarFaltaEnvidoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarFaltaEnvido(nombreJugador);
			actualizar();
			return true;
			
		} catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean cantarFlorPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.cantarFlor(nombreJugador);
			actualizar();
			return true;
			
		} catch (JugadorSinFlorException | AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException | PartidaSinFlorException e) {
			
			throw e;
		}
	}
	
	public boolean aceptarFlorPorJugador(String nombreJugador){
		
		try {
			this.partidaActual.aceptarFlor(nombreJugador);
			actualizar();
			return true;
		}
		catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean aceptarVarianteEnvidoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.aceptarVarianteEnvido(nombreJugador);
			actualizar();
			return true;
		}
		catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException | CantidadDeEnvidosMaximosSuperadaException e) {
			
			throw e;
		}
	}
	
	public boolean aceptarTrucoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.aceptarTruco(nombreJugador);
			actualizar();
			return true;
		}
		catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean aceptarReTrucoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.aceptarReTruco(nombreJugador);
			actualizar();
			return true;
		}
		catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean aceptarValeCuatroPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.aceptarValeCuatro(nombreJugador);
			actualizar();
			return true;
		}
		catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean rechazarFlorPorJugador(String nombreJugador){
		
		try {
			this.partidaActual.rechazarFlor(nombreJugador);
			actualizar();
			return true;
			
		}catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean rechazarVarianteEnvidoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.rechazarVarianteDeEnvido(nombreJugador);
			actualizar();
			return true;
			
		}catch (AccionInvalidaException | TurnoParaTomarDecisionEquivocadoException e) {
			
			throw e;
		}
	}
	
	public boolean rechazarVarianteTrucoPorJugador(String nombreJugador) {
		
		try {
			this.partidaActual.rechazarVarianteDeTruco(nombreJugador);
			actualizar();
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
	
	public boolean jugarCartaDeJugador(String nombreJugador, Carta carta) {
		
		try {
			this.partidaActual.jugarCartaDeJugador(nombreJugador, carta);
			actualizar();
			return true;
			
		} catch (TurnoEquivocadoException | AccionInvalidaException e) {
			
			throw e;
		}
	}
	
	public boolean jugarPrimerCartaDeJugador(String nombreJugador) {
		
		try {
			this.partidaActual.jugarPrimerCartaJugador(nombreJugador);
			return true;
			
		} catch (TurnoEquivocadoException | AccionInvalidaException | CartaYaJugadaException e) {
			
			throw e;
		}
	}
	
	public boolean jugarSegundaCartaDeJugador(String nombreJugador) {
		
		try {
			this.partidaActual.jugarSegundaCartaJugador(nombreJugador);
			return true;
			
		} catch (TurnoEquivocadoException | AccionInvalidaException | CartaYaJugadaException e) {
			
			throw e;
		}
	}
	
	public boolean jugarTercerCartaDeJugador(String nombreJugador) {
		
		try {
			this.partidaActual.jugarTercerCartaJugador(nombreJugador);
			return true;
			
		} catch (TurnoEquivocadoException | AccionInvalidaException | CartaYaJugadaException e) {
			
			throw e;
		}
	}
	
	// Reparte cartas de forma aleatoria
	public void repartirCartas() {
		
		this.partidaActual.repartirCartas();
	}
	
	// Reparte las cartas que se le pasan como parámetro siempre en ese mismo orden
	public void repartirCartas(List<Carta> listaCartas) {
		
		listaCartas.forEach(x -> { x.pasaAEstar(new EnMano()); });
		this.partidaActual.repartirCartas(listaCartas);
	}
	
	public List<Carta> getCartasJugador(String nombreJugador) {
		return this.partidaActual.getCartasJugador(nombreJugador);
	}
	
	public Set<String> getMesasDisponilbles() {
		return this.partidasDisponibles.keySet();
	}
	
	public void cargarMesa(String nombreMesa) {
		this.partidaActual = this.partidasDisponibles.get(nombreMesa);
	}

	public String getNombreJugadorConTurno() {
		return this.partidaActual.getNombreJugadorConTurno();
	}

	public String getNombreJugadorConDecisionEnvido() {
		return this.partidaActual.getNombreJugadorConDecisionEnvido();
	}
	
	public String getNombreJugadorConDecisionFlor() {
		return this.partidaActual.getNombreJugadorConDecisionFlor();
	}
	
	public String getNombreJugadorConDecisionTruco() {
		return this.partidaActual.getNombreJugadorConDecisionTruco();
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

	public Partida getPartida() {
		return this.partidaActual;
	}

	public Carta getUltimaCartaJugada(String nombreJugador) {
		return this.partidaActual.getUltimaCartaJugada(nombreJugador);
	}
	
	public String getPuntajeGanadorEnvido(){
		
		return Integer.toString(this.partidaActual.getPuntajeGanadorEnvido());
	}
	
	public String getPuntajeAcumuladoEnvidoJugado(){
		
		return Integer.toString(this.partidaActual.getPuntajeAcumuladoEnvidoJugado());
	}
	
    public String getPuntajeAcumuladoEnvidoRechazado(){
		
		return Integer.toString(this.partidaActual.getPuntajeAcumuladoEnvidoRechazado());
	}
    
    
    public Set<String> getEquipoGanadorFlor(){
		
		return this.partidaActual.getGanadorFlor().getNombresJugadores();
	}
	
	public String getPuntajeGanadorFlor(){
		
		return Integer.toString(this.partidaActual.getPuntajeGanadorFlor());
	}
	
	public String getPuntajeAcumuladoFlorJugada(){
		
		return Integer.toString(this.partidaActual.getPuntajeAcumuladoFlorJugada());
	}
	
    public String getPuntajeAcumuladoFlorRechazada(){
		
		return Integer.toString(this.partidaActual.getPuntajeAcumuladoFlorRechazada());
	}
    
    
    public Set<String> getEquipoGanadorTruco(){
    		
    	return this.partidaActual.getGanadorTruco().getNombresJugadores();
    }
    
	
	public String getPuntajeAcumuladoTrucoJugado(){
		
		return Integer.toString(this.partidaActual.getPuntajeAcumuladoTrucoJugado());
	}
	
    public String getPuntajeAcumuladoTrucoRechazado(){
		
		return Integer.toString(this.partidaActual.getPuntajeAcumuladoTrucoRechazado());
	}
    
    public boolean equipoGanoDosDeTres(){
    	
    	return this.partidaActual.hayGanadorTruco();
    }
    
	public boolean hayUnGanador(){
		
		return this.partidaActual.hayUnGanador();
	}
	
	public Equipo getGanador(){
		
		return this.partidaActual.getEquipoGanador();
	}
	
	public Set<String> getEquipoGanadorEnvido() {
		return this.partidaActual.getGanadorEnvido().getNombresJugadores();
	}
}
