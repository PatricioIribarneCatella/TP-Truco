package algoritmosyprogramacion3.tp2.modelo;

public class EnMano implements EstadoDeCarta {

	@Override
	public boolean esValidoParaSerJugada() {
		return true;
	}

	@Override
	public EstadoDeCarta proximoEstado() {
		return new EnMesa();
	}
}
