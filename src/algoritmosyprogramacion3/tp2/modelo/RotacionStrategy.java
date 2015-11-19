package algoritmosyprogramacion3.tp2.modelo;

public interface RotacionStrategy {
	
	
	
	/*Devuelve al jugador a quien le corresponde el siguiente turno*/
	 public Jugador cambiarTurno();
	 
	 
	 /*Devuelve el siguiente jugador que es mano*/
	 public Jugador rondaFinalizada();

}
