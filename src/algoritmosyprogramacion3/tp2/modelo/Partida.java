package algoritmosyprogramacion3.tp2.modelo;

import java.util.HashMap;

import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.CantidadDeEnvidosMaximosSuperadaException;

public abstract class Partida {

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
	
	public String getNombre() {
		return this.nombrePartida;
	}
	
	public void iniciarPartida() {
		
		this.estado = new TurnoJugador();
		this.cantidadDeEnvidosCantados = 0;
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
	
	public void aceptarVarianteEnvido(String jugadorQueAcepta) {
		
		if (!this.estado.esValidoParaAceptar()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueAcepta);
		this.moderador.jugadorAceptaVarianteEnvido(jugador);
		this.estado = new TurnoJugador();
		// habria que crear otro estado que se mantenga hasta que se declaren todos los valores de envido
	}
	
    public void aceptarVarianteTruco(String jugadorQueAcepta) {
		
		if (!this.estado.esValidoParaAceptar()) throw new AccionInvalidaException();
		
		Jugable jugador = this.jugadores.get(jugadorQueAcepta);
		this.moderador.jugadorAceptaVarianteTruco(jugador);
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
    	this.moderador.rondaFinalizada();
    	this.estado = new TurnoJugador();
	}
}
