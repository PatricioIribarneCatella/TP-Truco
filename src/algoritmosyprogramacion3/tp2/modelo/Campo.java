package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;

public class Campo {
	
	private Jugador jugador;
	private LinkedList<Carta> cartasEnJuego;
	private Mesa mesaDeJuego;
    
	
	public Campo(Jugador jugadorDelCampo,Mesa mesaDelCampo){
		
		this.jugador = jugadorDelCampo;
		this.cartasEnJuego = new LinkedList<Carta>();
		this.mesaDeJuego = mesaDelCampo;
	}
	
	public Carta getCarta(int indice){
		
		return (this.cartasEnJuego.get(indice));
	}
	
	public void recibirCartaJugada(Carta unaCarta){
		
		this.cartasEnJuego.add(unaCarta);
		this.mesaDeJuego.cambiarTurno();
	}
	
	public void removerCartas()
	{
		this.cartasEnJuego.clear();
	}

	public boolean esMiTurno() {

		return (this.mesaDeJuego.getJugadorActual() == this.jugador);
	}
	
}
