package truco.modelo;

public class MenorQueCinco implements EstadoRotacion {

	@Override
	public boolean esValidaParaCambiarComportamiento() {
		return false;
	}
}
