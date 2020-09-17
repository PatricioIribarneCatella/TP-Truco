package truco.modelo;

public class GanoJugable implements Resultado {

	private Jugable jugadorGandador;
	
	public GanoJugable(Jugable jugador) {
		this.jugadorGandador = jugador;
	}
	
	@Override
	public boolean huboGanador() {
		return true;
	}

	@Override
	public Jugable getJugadorGanador() {
		return this.jugadorGandador;
	}
}
