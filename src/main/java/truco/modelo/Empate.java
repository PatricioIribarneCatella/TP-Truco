package truco.modelo;

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
