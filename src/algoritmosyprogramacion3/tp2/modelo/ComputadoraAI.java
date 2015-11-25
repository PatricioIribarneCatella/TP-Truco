package algoritmosyprogramacion3.tp2.modelo;

import java.util.Random;

public class ComputadoraAI implements Jugable {

	private int puntaje;
	private Mano cartas;
	private Moderador moderador;
	private Mesa mesa;
	private Random numeroRandom;
	
	public ComputadoraAI() {
		
		this.puntaje = 0;
		this.cartas = new Mano();
		this.numeroRandom = new Random();
	}
	
	private Respuesta nuevoEvento() {
		
		int numero = this.numeroRandom.nextInt(3);
		
		if (!this.cartas.hayCartasJugadas()) {
			
			if (numero == 0) return new Envido();
			if (numero == 1 && this.mesa.seJuegaConFlor()) return new Flor(); 
		}
		return new Truco();
	}
	
	public Respuesta darRespuestaAEvento(Evento evento) {
		
		int numero = this.numeroRandom.nextInt(3);
		
		if (numero == 0 && evento.esPosibleSubirLaApuesta()) return evento.subirApuesta();
		else if (numero == 1) {
			return new Aceptar();
		} 
		return new Rechazar();
	}
		
	
	public Respuesta darRespuestaATurno() {
		
		int numero = this.numeroRandom.nextInt(2);
		
		if (numero == 0) {
			
			this.moderador.seJugoUnaCarta();
			Carta cartaRandom = this.cartas.getCartaRandom();
			this.mesa.recibirCartaJugada(this,cartaRandom);	
			return new JugarCarta();
		}
		return this.nuevoEvento();
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
}
