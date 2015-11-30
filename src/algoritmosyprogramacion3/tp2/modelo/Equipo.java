package algoritmosyprogramacion3.tp2.modelo;

import java.util.HashMap;

public class Equipo {

	private int puntaje;
	private HashMap<String,Jugable> jugadores;
	
	public Equipo() {
		this.puntaje = 0;
		this.jugadores = new HashMap<String,Jugable>();
	}
	
	public void sumarPuntos(int puntosASumar) {
		this.puntaje += puntosASumar;
	}
	
	public void agregarIntegrante(Jugable jugador) {
		jugador.setEquipo(this);
		this.jugadores.put(jugador.getNombre(), jugador);
	}

	public int getPuntaje() {
		return this.puntaje;
	}
}
