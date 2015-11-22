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
	
	public void jugarCarta() {
	
		if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
		this.moderador.cambiarTurno();
	}
	
	public void cantarTruco() {
		
		if (!this.estado.esValidoParaCantarTruco()) throw new AccionInvalidaException(); 
		this.estado = new TrucoCantado();
	}
	
	public void cantarReTruco() {
		
		if (!this.estado.esValidoParaCantarReTruco()) throw new AccionInvalidaException(); 
		this.estado = new ReTrucoCantado();
	}
	
	public void cantarValeCuatro() {
		
		if (!this.estado.esValidoParaCantarValeCuatro()) throw new AccionInvalidaException(); 
		this.estado = new ValeCuatroCantado();
	}
	
	public void cantarEnvido() {
		
		if (!this.estado.esValidoParaCantarEnvido()) throw new AccionInvalidaException();
		if (this.cantidadDeEnvidosCantados == 3) throw new CantidadDeEnvidosMaximosSuperadaException();
		this.estado = new EnvidoCantado();
		this.cantidadDeEnvidosCantados++;
	}
	
	public void cantarRealEnvido() {
	
		if (!this.estado.esValidoParaCantarRealEnvido()) throw new AccionInvalidaException();
		this.estado = new RealEnvidoCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void cantarFaltaEnvido() {
		
		if (!this.estado.esValidoParaCantarFaltaEnvido()) throw new AccionInvalidaException();
		this.estado = new FaltaEnvidoCantado();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void aceptar() {
		
		if (!this.estado.esValidoParaAceptar()) throw new AccionInvalidaException();
	}
	
	public void rechazar() {
		
		if (!this.estado.esValidoParaRechazar()) throw new AccionInvalidaException();
		this.estado = new PartidaFinalizada();
		this.cantidadDeEnvidosCantados = 0;
		this.moderador.rondaFinalizada();
	}
}
