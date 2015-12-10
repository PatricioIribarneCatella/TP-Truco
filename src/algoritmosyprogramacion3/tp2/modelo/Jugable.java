package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;

public abstract class Jugable {
	
	protected int puntaje;
	protected Mano cartas;
	protected Moderador moderador;
	protected Mesa mesa;
	protected String nombre;
	protected Equipo equipo;
	
	public Jugable() {
		
		this.puntaje = 0;
		this.cartas = new Mano();
	}
	
	public Carta getCartaJugada() {
		return this.cartas.getUltimaCartaJugada();
	}
	
	public String puntajeAcumuladoComoString() {
		
		String puntajeComoString = Integer.toString(this.puntaje);
		return puntajeComoString;
	}
	
	public int puntajeAcumulado() {
		return this.puntaje;
	}
	
	public void sumarPuntos(int puntos) {
		this.equipo.sumarPuntos(puntos);
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public void recibirCarta(Carta carta) {
		this.cartas.agregarCarta(carta);
	}

	public void setModerador(Moderador moderadorDeLaPartida) {
		this.moderador =  moderadorDeLaPartida;
	}

	private boolean esMiTurno() {
		
		return (this == this.moderador.getJugadorConTurno());
	}
	
	public void jugarPrimerCarta() {
	
		Carta cartaAJugar = this.cartas.getPrimerCarta();
		
		if (this.esMiTurno()) {
		
			this.mesa.recibirCartaJugada(this,cartaAJugar);	
			this.moderador.seJugoUnaCarta();
			
		} else {
			
			throw new TurnoEquivocadoException();
		}
	}

	public void jugarSegundaCarta() {
	
		Carta cartaAJugar = this.cartas.getSegundaCarta();
		
		if (this.esMiTurno()) {
		
			this.mesa.recibirCartaJugada(this,cartaAJugar);	
			this.moderador.seJugoUnaCarta();
			
		} else {
			
			throw new TurnoEquivocadoException();
		}
	}

	public void jugarTercerCarta() {
	 
		Carta cartaAJugar = this.cartas.getTercerCarta();
		
		if (this.esMiTurno()) {
		
			this.mesa.recibirCartaJugada(this,cartaAJugar);	
			this.moderador.seJugoUnaCarta();
			
		} else {
			
			throw new TurnoEquivocadoException();
		}
	}
	
	public String declararPuntosEnvido() {
		return this.cartas.puntajeEnvido();
	}
	
	public String declararPuntosFlor() {
		return this.cartas.puntajeFlor().toString();
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	public Equipo getEquipo() {
		return this.equipo;
	}

	public List<Carta> getCartas() {
		return this.cartas.getCartas();
	}

	public void devolverCartasAlMazo() {
		this.cartas.vaciar();
	}

	public boolean tieneFlor() {
		return this.cartas.hayFlor();
	}

	public String getCantidadCartasEnMano() {
		return Integer.toString(this.cartas.getCartas().size());
	}
}
