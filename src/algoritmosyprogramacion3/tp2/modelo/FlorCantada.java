package algoritmosyprogramacion3.tp2.modelo;

public class FlorCantada implements EstadoPartida {

	@Override
	public boolean esValidoParaJugarCarta() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esValidoParaCantarTruco() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esValidoParaCantarReTruco() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esValidoParaCantarValeCuatro() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esValidoParaCantarEnvido() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esValidoParaCantarRealEnvido() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esValidoParaCantarFaltaEnvido() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esValidoParaAceptar() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean esValidoParaRechazar() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean esValidoParaCantarFlor() {
		return false;
	}

}
