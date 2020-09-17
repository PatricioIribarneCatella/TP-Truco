package truco.modelo;

import java.util.List;

public interface RotacionStrategy {

	/*Devuelve al jugador a quien le corresponde el siguiente turno*/
	public Jugable getJugadorConTurno();

	/*Devuelve el siguiente jugador que es mano*/
	public Jugable getSiguienteJugadorMano();

	/*Devuelve el jugador al que le corresponde cantar o responder ante un evento*/
	public Jugable getJugadorConDecision();

	public List<Jugable> getJugadoresEnfrentados();

	public RotacionStrategy getProximaRotacion();

	public Jugable getJugadorConDecisionTruco();

	public boolean rotacionCompleta(); // es para la ronda pica pica para saber cuando jugaron todas las parejas.
}
