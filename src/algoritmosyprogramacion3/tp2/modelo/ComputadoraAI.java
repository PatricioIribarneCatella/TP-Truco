package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;
import java.util.Random;

import algoritmosyprogramacion3.tp2.excepciones.CartaYaJugadaException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;

public class ComputadoraAI implements Jugable {

	private int puntaje;
	private Mano cartas;
	private Moderador moderador;
	private Mesa mesa;
	private String nombre;
	private Equipo equipo;
	
	
	public ComputadoraAI() {
		
		this.puntaje = 0;
		this.cartas = new Mano();
		new Random();
		this.nombre = "Computadora";
	}
	
	public void darRespuestaAEnvido() {

	     this.moderador.jugadorAceptaVarianteEnvido(this);
	}
	
	public void darRespuestaARealEnvido() {
		
	     this.moderador.jugadorAceptaVarianteEnvido(this);
	}
	
	public void darRespuestaAFaltaEnvido() {
		
	     this.moderador.jugadorAceptaVarianteEnvido(this);
	}
		
	public void darRespuestaATruco() {
		
	     this.moderador.jugadorAceptaVarianteTruco(this);
	}
	
	public void darRespuestaATurno() {
		
		  this.jugarCarta();
	}
	
	private Evento jugarCarta() {

		/*Intenta jugar una carta hasta que el juego se lo permita*/
		try{

			this.jugarPrimerCarta();
		}
		catch(CartaYaJugadaException e){
			
			try {
				
				this.jugarSegundaCarta();
			}
			catch(CartaYaJugadaException d){
				
				this.jugarTercerCarta();
			}
				
		}
		
		return new JugarCarta();
	}

	public void recibirCarta(Carta carta) {
		
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
		this.equipo.sumarPuntos(puntos);
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

	@Override
	public List<Carta> getCartas() {
		return this.cartas.getCartas();
	}
	
	public String declararPuntosFlor()
	{
		return this.cartas.puntajeFlor().toString();
	}

	@Override
	public void devolverCartasAlMazo() {
		this.cartas.vaciar();
	}

	@Override
	public boolean tieneFlor() {
		return this.cartas.hayFlor();
	}

	@Override
	public String getCantidadCartasEnMano() {
		return Integer.toString(this.cartas.getCartas().size());
	}
}
