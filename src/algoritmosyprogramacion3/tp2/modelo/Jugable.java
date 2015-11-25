package algoritmosyprogramacion3.tp2.modelo;

public interface Jugable {
	
	public Carta getCartaJugada();

	public String puntajeAcumuladoComoString();
	
	public int puntajeAcumulado();
	
	public void sumarPuntos(int puntos);
}
