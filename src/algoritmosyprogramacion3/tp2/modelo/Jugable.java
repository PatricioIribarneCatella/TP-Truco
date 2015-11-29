package algoritmosyprogramacion3.tp2.modelo;

public interface Jugable {
	
	public Carta getCartaJugada();

	public String puntajeAcumuladoComoString();
	
	public int puntajeAcumulado();
	
	public void sumarPuntos(int puntos);

	public void setMesa(Mesa mesa);

	public void recibirCarta(Carta darCarta);

	public void setModerador(Moderador moderador);

	public void jugarPrimerCarta();

	public void jugarSegundaCarta();

	public void jugarTercerCarta();
	
	public String declararPuntosEnvido();
	
}
