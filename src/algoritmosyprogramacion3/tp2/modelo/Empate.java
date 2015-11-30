package algoritmosyprogramacion3.tp2.modelo;

public class Empate implements Resultado{

	@Override
	public boolean huboGanador() {
		return false;
	}

	@Override
	public Jugable getJugadorGanador() {
		return null;
	}
}
