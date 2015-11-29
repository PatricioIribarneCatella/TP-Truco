package algoritmosyprogramacion3.tp2.modelo;

import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.CantidadDeEnvidosMaximosSuperadaException;

public class Partida {

	private EstadoPartida estado;
	private Moderador moderador;
	private int cantidadDeEnvidosCantados;
	
	public Partida(Moderador moderador) {
		
		this.moderador = moderador;
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void iniciarPartida() {
		
		this.estado = new TurnoJugador();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void jugarPrimerCartaJugador(Jugable unJugador){
		
		if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
		
		this.moderador.jugarPrimerCarta(unJugador);	
	}
	
	public void jugarSegundaCartaJugador(Jugable unJugador){
	
    	if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
    	
		this.moderador.jugarSegundaCarta(unJugador);
	}

	public void jugarTercerCartaJugador(Jugable unJugador){

		if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
	   
		this.moderador.jugarTercerCarta(unJugador);
	}
	
	
	public void cantarTruco(Jugable jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarTruco()) throw new AccionInvalidaException(); 
	  
		this.moderador.trucoCantado(jugadorQueCanta);
		this.estado = new TrucoCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void cantarReTruco(Jugable jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarReTruco()) throw new AccionInvalidaException(); 

		this.moderador.reTrucoCantado(jugadorQueCanta);
		this.estado = new ReTrucoCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void cantarValeCuatro(Jugable jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarValeCuatro()) throw new AccionInvalidaException(); 
		
		this.moderador.valeCuatroCantado(jugadorQueCanta);
		this.estado = new ValeCuatroCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void cantarEnvido(Jugable jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarEnvido()) throw new AccionInvalidaException();
		if (this.cantidadDeEnvidosCantados == 3) throw new CantidadDeEnvidosMaximosSuperadaException();
		
		this.moderador.envidoCantado(jugadorQueCanta);
		this.estado = new EnvidoCantado();
		this.cantidadDeEnvidosCantados++;
	}
	
	public void cantarRealEnvido(Jugable jugadorQueCanta) {
	
		if (!this.estado.esValidoParaCantarRealEnvido()) throw new AccionInvalidaException();
		
		this.moderador.realEnvidoCantado(jugadorQueCanta);
		this.estado = new RealEnvidoCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void cantarFaltaEnvido(Jugable jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarFaltaEnvido()) throw new AccionInvalidaException();
		
		this.estado = new FaltaEnvidoCantado();
		this.moderador.faltaEnvidoCantado(jugadorQueCanta);
		this.estado = new FaltaEnvidoCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void aceptarVarianteEnvido(Jugable jugadorQueAcepta) {
		
		if (!this.estado.esValidoParaAceptar()) throw new AccionInvalidaException();
			
		this.moderador.jugadorAceptaVarianteEnvido(jugadorQueAcepta);
		// habria que crear otro estado que se mantenga hasta que se declaren todos los valores de envido
	}
	
    public void aceptarVarianteTruco(Jugable jugadorQueAcepta) {
		
		if (!this.estado.esValidoParaAceptar()) throw new AccionInvalidaException();
			
		this.moderador.jugadorAceptaVarianteTruco(jugadorQueAcepta);
	}
	
    public void rechazarVarianteDeEnvido(Jugable jugadorQueRechaza) {
		
		if (!this.estado.esValidoParaRechazar()) throw new AccionInvalidaException();
			
    	this.moderador.jugadorRechazaVarianteEnvido(jugadorQueRechaza);
    	this.cantidadDeEnvidosCantados = 0;
    	this.estado = new TurnoJugador();
	}
    
	public void rechazarVarianteDeTruco(Jugable jugadorQueRechaza) {
		
		if (!this.estado.esValidoParaRechazar()) throw new AccionInvalidaException();
		
		this.moderador.jugadorRechazaVarianteTruco(jugadorQueRechaza);
    	this.cantidadDeEnvidosCantados = 0;
    	this.moderador.rondaFinalizada();
    	this.estado = new TurnoJugador();
	}
}
