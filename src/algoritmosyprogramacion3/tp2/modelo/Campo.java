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
	
	public Carta getPrimerCarta() {
		return this.cartasEnJuego.get(0);
	}
	
	public Carta getSegundaCarta() {
		return this.cartasEnJuego.get(1);
	}
	
	public Carta getTercerCarta() {
		return this.cartasEnJuego.get(2);
	}
	
	public void recibirCartaJugada(Carta unaCarta){
		
		if(unaCarta.esValidaParaSerJugada())
		{
			unaCarta.jugate();
			this.cartasEnJuego.add(unaCarta);
			this.mesaDeJuego.cambiarTurno();
		}	
	}
	
	public void removerCartas()
	{
		this.cartasEnJuego.clear();
	}

	public boolean esMiTurno() {

		return (this.mesaDeJuego.getJugadorActual() == this.jugador);
	}
	
}
