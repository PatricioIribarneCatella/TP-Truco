package algoritmosyprogramacion3.tp2.modelo;

public interface RotacionStrategy {
	
	
	
	/*Devuelve al jugador a quien le corresponde el siguiente turno*/
	 public Jugable getJugadorConTurno();
	 
	 
	 /*Devuelve el siguiente jugador que es mano*/
	 public Jugable getSiguienteJugadorMano();
	 
	 /*Devuelve el jugador al que le corresponde cantar o responder ante un evento*/
	 public Jugable getJugadorConDecision();

}
