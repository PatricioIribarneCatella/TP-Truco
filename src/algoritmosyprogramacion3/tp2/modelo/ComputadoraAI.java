package algoritmosyprogramacion3.tp2.modelo;

import java.util.Random;

import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;

public class ComputadoraAI implements Jugable {

	private int puntaje;
	private Mano cartas;
	private Moderador moderador;
	private Mesa mesa;
	private String nombre;
	private Equipo equipo;
	private Random numeroRandom;
	
	public ComputadoraAI() {
		
		this.puntaje = 0;
		this.cartas = new Mano();
		this.numeroRandom = new Random();
		this.nombre = "Computadora";
	}
	
	private Evento nuevoEvento() {
		
		int numero = this.numeroRandom.nextInt(3);
		
		if (!this.cartas.hayCartasJugadas()) {
			
			if (numero == 0) return new Envido();
			if (numero == 1 && this.mesa.seJuegaConFlor()) return new Flor(); 
		}
		return new Truco();
	}
	
	public Evento darRespuestaAEvento(Evento evento) {
		
		int numero = this.numeroRandom.nextInt(3);
		
		if (numero == 0 && evento.esPosibleSubirLaApuesta()) return evento.subirApuesta();
		else if (numero == 1) {
			return new Aceptar();
		} 
		return new Rechazar();
	}
		
	
	public Evento darRespuestaATurno() {
		
		int numero = this.numeroRandom.nextInt(2);
	     
		if(numero == 0){
	       
			return this.jugarCarta();		
		}
		
		return this.nuevoEvento();
	}
	
	private Evento jugarCarta() {

		int numero = this.numeroRandom.nextInt(3);
		if (numero == 0) {
			
			this.jugarPrimerCarta();
		}
		else{
			
			if(numero == 1){
				
				this.jugarSegundaCarta();
			}
			else{
				
				this.jugarTercerCarta();
			}
				
		}
		return new JugarCarta();
	}

	public void recibirCarta(Carta carta) {
		
		carta.entregada();
		this.cartas.agregarCarta(carta);
	}
	
	public void setModerador(Moderador moderadorDeLaPartida){
		
		this.moderador =  moderadorDeLaPartida;
	}
	
	public void setMesa(Mesa mesaDeJuego){
		
		this.mesa = mesaDeJuego;
	}
	
	@Override
	public String puntajeAcumuladoComoString() {
		
		String puntajeComoString = Integer.toString(this.puntaje);
		return puntajeComoString;
	}
	
	@Override
	public int puntajeAcumulado() {
		return this.puntaje;
	}
	
	@Override
	public Carta getCartaJugada() {
		return this.cartas.getUltimaCartaJugada();
	}

	@Override
	public void sumarPuntos(int puntos) {
		this.puntaje += puntos; 
	}

	
	private boolean esMiTurno() {
		
		return (this == this.moderador.getJugadorConTurno());
	}
	
	@Override
	public void jugarPrimerCarta() {
	    
		Carta cartaAJugar = this.cartas.getPrimerCarta();
		
		if (this.esMiTurno()) {
		
			this.mesa.recibirCartaJugada(this,cartaAJugar);	
			this.moderador.seJugoUnaCarta();
			
		} else {
			
			throw new TurnoEquivocadoException();
		}
	}

	@Override
	public void jugarSegundaCarta() {
	
		Carta cartaAJugar = this.cartas.getSegundaCarta();
		
		if (this.esMiTurno()) {
		
			this.mesa.recibirCartaJugada(this,cartaAJugar);	
			this.moderador.seJugoUnaCarta();
			
		} else {
			
			throw new TurnoEquivocadoException();
		}
	}

	@Override
	public void jugarTercerCarta() {
	 
		Carta cartaAJugar = this.cartas.getTercerCarta();
		
		if (this.esMiTurno()) {
		
			this.mesa.recibirCartaJugada(this,cartaAJugar);	
			this.moderador.seJugoUnaCarta();
			
		} else {
			
			throw new TurnoEquivocadoException();
		}
	}
	
	public String declararPuntosEnvido(){
		
		return(this.cartas.puntajeEnvido());
	}
	
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public Equipo getEquipo() {
		return this.equipo;
	}
}
