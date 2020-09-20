package truco.modelo;

public interface EstadoPartida {

	public boolean esValidoParaJugarCarta();
	
	public boolean esValidoParaCantarTruco();
	
	public boolean esValidoParaCantarReTruco();
	
	public boolean esValidoParaCantarValeCuatro();
	
	public boolean esValidoParaCantarEnvido();
	
	public boolean esValidoParaCantarRealEnvido();
	
	public boolean esValidoParaCantarFaltaEnvido();
	
	public boolean esValidoParaCantarFlor();
	
	public boolean esValidoParaAceptar();
	
	public boolean esValidoParaRechazar();
}
