package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;

public class Campo {
	
	private Jugador jugador;
	private LinkedList<Carta> cartasEnJuego;
    
	
	public Campo(Jugador jugadorDelCampo){
		
		this.jugador = jugadorDelCampo;
		this.cartasEnJuego = new LinkedList<Carta>();
	}
	
	public Jugador getJugador(){
		
		return this.jugador;
	}
	
	public Carta getPrimerCartaJugada() {
		return this.cartasEnJuego.get(0);
	}
	
	public Carta getSegundaCartaJugada() {
		return this.cartasEnJuego.get(1);
	}
	
	public Carta getTercerCartaJugada() {
		return this.cartasEnJuego.get(2);
	}
	
	public void recibirCartaJugada(Carta unaCarta){
	
	     this.cartasEnJuego.add(unaCarta);
	}
	
	public void removerCartas()
	{
		this.cartasEnJuego.clear();
	}

	
}
