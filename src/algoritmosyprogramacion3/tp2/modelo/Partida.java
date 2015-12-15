package algoritmosyprogramacion3.tp2.modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.CantidadDeEnvidosMaximosSuperadaException;
import algoritmosyprogramacion3.tp2.excepciones.JugadorSinFlorException;
import algoritmosyprogramacion3.tp2.excepciones.PartidaSinFlorException;
import algoritmosyprogramacion3.tp2.utilitarios.NombreJugadorCarta;

public abstract class Partida extends Observable {

	private EstadoPartida estado;
	protected Moderador moderador;
	protected String nombrePartida;
	private int cantidadDeEnvidosCantados;
	protected HashMap<String,Jugable> jugadores;
	
	public Partida(String nombrePartida) {
		
		this.nombrePartida = nombrePartida;
		this.cantidadDeEnvidosCantados = 0;
		this.jugadores = new HashMap<String,Jugable>();
	}
	
	public void setChanged() {
		super.setChanged();
	}
	
	public String getNombre() {
		return this.nombrePartida;
	}
	
	public void iniciarPartida() {
		
		this.estado = new TurnoJugador();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void jugarCartaDeJugador(String nombreJugador, Carta carta) {
		
		if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(nombreJugador);
		this.moderador.jugarCartaDeJugador(jugador, carta);
	}
	
	public void jugarPrimerCartaJugador(String unJugador){
		
		if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(unJugador);
		this.moderador.jugarPrimerCarta(jugador);	
	}
	
	public void jugarSegundaCartaJugador(String unJugador){
	
    	if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
    	
    	Jugable jugador = this.jugadores.get(unJugador);
		this.moderador.jugarSegundaCarta(jugador);
	}

	public void jugarTercerCartaJugador(String unJugador){

		if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
	   
		Jugable jugador = this.jugadores.get(unJugador);
		this.moderador.jugarTercerCarta(jugador);
	}
	
	public void cantarTruco(String jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarTruco()) throw new AccionInvalidaException(); 
	  
		Jugable jugador = this.jugadores.get(jugadorQueCanta);
		this.moderador.trucoCantado(jugador);
		this.estado = new TrucoCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void cantarReTruco(String jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarReTruco()) throw new AccionInvalidaException(); 

		Jugable jugador = this.jugadores.get(jugadorQueCanta);
		this.moderador.reTrucoCantado(jugador);
		this.estado = new ReTrucoCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void cantarValeCuatro(String jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarValeCuatro()) throw new AccionInvalidaException(); 
		
		Jugable jugador = this.jugadores.get(jugadorQueCanta);
		this.moderador.valeCuatroCantado(jugador);
		this.estado = new ValeCuatroCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
    public void cantarFlor(String jugadorQueCanta) {
		
    	if (!this.moderador.getMesa().seJuegaConFlor()) throw new PartidaSinFlorException();
    	if (!this.jugadores.get(jugadorQueCanta).tieneFlor()) throw new JugadorSinFlorException();
		if (!this.estado.esValidoParaCantarFlor()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueCanta);
		this.moderador.florCantada(jugador);
		this.estado = new FlorCantada();
		this.cantidadDeEnvidosCantados = 0; // cuando se canta flor no importa mas el envido
	}
	
	public void cantarEnvido(String jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarEnvido()) throw new AccionInvalidaException();
		if (this.cantidadDeEnvidosCantados == 3) throw new CantidadDeEnvidosMaximosSuperadaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueCanta);
		this.moderador.envidoCantado(jugador);
		this.estado = new EnvidoCantado();
		this.cantidadDeEnvidosCantados++;
	}
	
	public void cantarRealEnvido(String jugadorQueCanta) {
	
		if (!this.estado.esValidoParaCantarRealEnvido()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueCanta);
		this.moderador.realEnvidoCantado(jugador);
		this.estado = new RealEnvidoCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void cantarFaltaEnvido(String jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarFaltaEnvido()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueCanta);
		this.estado = new FaltaEnvidoCantado();
		this.moderador.faltaEnvidoCantado(jugador);
		this.estado = new FaltaEnvidoCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	
	public void aceptarFlor(String jugadorQueAcepta) { //sinonimo de contraflor
		
		if (!this.estado.esValidoParaAceptar()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueAcepta);
		this.moderador.jugadorAceptaFlor(jugador);
		this.estado = new TurnoJugador();
	}
	
	
	public void aceptarVarianteEnvido(String jugadorQueAcepta) {
		
		if (!this.estado.esValidoParaAceptar()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueAcepta);
		this.moderador.jugadorAceptaVarianteEnvido(jugador);
		this.estado = new TurnoJugador();
	}
	
	private void manejarVarianteTruco(String jugadorQueAcepta) {
		
		if (!this.estado.esValidoParaAceptar()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueAcepta);
		this.moderador.jugadorAceptaVarianteTruco(jugador);
	}
	
    public void aceptarTruco(String jugadorQueAcepta) {
		
		this.manejarVarianteTruco(jugadorQueAcepta);
		this.estado = new TrucoAceptado();
	}
	
    public void aceptarReTruco(String jugadorQueAcepta) {
		
    	this.manejarVarianteTruco(jugadorQueAcepta);
		this.estado = new ReTrucoAceptado();
	}
    
    public void aceptarValeCuatro(String jugadorQueAcepta) {
		
    	this.manejarVarianteTruco(jugadorQueAcepta);
		this.estado = new ValeCuatroAceptado();
	}
    
    public void rechazarFlor(String jugadorQueRechaza){
    	
        if (!this.estado.esValidoParaRechazar()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueRechaza);
    	this.moderador.jugadorRechazaFlor(jugador);
    	this.estado = new TurnoJugador();
    }
    
    public void rechazarVarianteDeEnvido(String jugadorQueRechaza) {
		
		if (!this.estado.esValidoParaRechazar()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueRechaza);
    	this.moderador.jugadorRechazaVarianteEnvido(jugador);
    	this.cantidadDeEnvidosCantados = 0;
    	this.estado = new TurnoJugador();
	}
    
	public void rechazarVarianteDeTruco(String jugadorQueRechaza) {
		
		if (!this.estado.esValidoParaRechazar()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueRechaza);
		this.moderador.jugadorRechazaVarianteTruco(jugador);
    	this.cantidadDeEnvidosCantados = 0;
    	this.estado = new TurnoJugador();
	}

	public void repartirCartas() {
		this.moderador.repartirCartas();
	}

	public void repartirCartas(List<Carta> listaCartas) {
		this.moderador.repartirCartas(listaCartas);
	}

	public List<Carta> getCartasJugador(String nombreJugador) {
		
		Jugable jugador = this.jugadores.get(nombreJugador);
		return jugador.getCartas();
	}
	
	public void sumarPuntos(Equipo equipo, int puntosASumar) {
		equipo.sumarPuntos(puntosASumar);
		this.estado = new TurnoJugador();
	}
	
	public void rondaFinalizada(){
		
		this.verificarEstrategiaDeRotacion();
	}
	
	protected abstract void verificarEstrategiaDeRotacion();

	public String mostrarPuntosJugador(String nombreJugador) {
		
		Jugable jugador = this.jugadores.get(nombreJugador);
		return jugador.getEquipo().getPuntajeComoString();
	}

	public String mostrarPuntosEnvido(String nombreJugador) {
		
		Jugable jugador = this.jugadores.get(nombreJugador);
		return jugador.declararPuntosEnvido();
	}

	public String mostrarPuntosFlor(String nombreJugador) {
		
		Jugable jugador = this.jugadores.get(nombreJugador);
		return jugador.declararPuntosFlor();
	}

	public String getNombreJugadorConTurno() {
		return this.moderador.getJugadorQueTieneTurno().getNombre();
	}

	public String getNombreJugadorConDecisionEnvido() {
		return this.moderador.getJugadorQueTieneDecisionEnvido().getNombre();
	}
	
	public String getNombreJugadorConDecisionFlor() {
		return this.moderador.getJugadorQueTieneDecisionFlor().getNombre();
	}
	
	public String getNombreJugadorConDecisionTruco() {
		return this.moderador.getJugadorQueTieneDecisionTruco().getNombre();
	}
	
	public abstract boolean esContraComputadora();
	
	public String getCantidadCartasEnManoDeJugador(String nombreJugador) {
		
		Jugable jugador = this.jugadores.get(nombreJugador);
		return jugador.getCantidadCartasEnMano();
	}

	public Set<String> getNombresDeJugadores() {
		return this.jugadores.keySet();
	}
	
	public List<NombreJugadorCarta> getCartasYaJugadasConJugador() {
		
		List<NombreJugadorCarta> lista = new LinkedList<NombreJugadorCarta>();
		
		Mesa mesa = this.moderador.getMesa();
		
		for (Jugable jugador : this.jugadores.values()) {
			
			List<Carta> cartas = mesa.getCartasJugadasPorJugador(jugador);
			
			for (Carta carta : cartas) {
				lista.add(new NombreJugadorCarta(jugador.getNombre(), carta));
			}
		}
		
		return lista;
	}

	public boolean seJuegaConFlor() {
		return this.moderador.getMesa().seJuegaConFlor();
	}

	public Carta getUltimaCartaJugada(String nombreJugador) {
		
		Jugable jugador = this.jugadores.get(nombreJugador);
		return jugador.getCartaJugada();
	}
}
