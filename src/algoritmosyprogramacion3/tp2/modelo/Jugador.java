package algoritmosyprogramacion3.tp2.modelo;

public class Jugador
{
	private Mano cartas;
	private Campo campoPropio;
	private String nombre;
	private int puntaje;
	
	public Jugador(String nombre)
	{
		this.nombre = nombre;
		this.puntaje = 0;
		this.cartas = new Mano();
	}
	
	
	//Metodo que permite que un usuario reciba nuevas cartas al comienzo de cada ronda
	public void recibirCarta(Carta unaCarta)
	{
		this.cartas.agregarCarta(unaCarta);
	}

	
	public void setCampo(Campo campoDelJugador){
		
		this.campoPropio = campoDelJugador;
	}
	
	public void cantarEnvido()
	{
		
	}
	
	public void cantarRealEnvido()
	{
		
	}
	
	public void cantarFaltaEnvido()
	{
		
	}
	
	public void cantarTruco()
	{
	}
	
	public void cantarRetruco()
	{
	}
	
	public void cantarValeCuatro()
	{
		
	}
	
	public void cantarFlor()
	{
		
	}
	
	public void irseAlMazo()
	{
		this.cartas.removerCartas();
	}
	
	
	public void Aceptar()
	{
		
	}
	
	public void Rechazar()
	{
		
	}

	/*El jugador declara la cantidad de puntos que suman sus cartas en el envido*/
	public String declararPuntosEnvido()
	{
		return(this.cartas.puntajeEnvido());
	}
	
	public String declararPuntosFlor()
	{
		return this.cartas.puntajeFlor().toString();
	}
	
	/*El jugador coloca una carta de su mano en la mesa*/
	public void jugarPrimerCarta()
	{
		if(this.campoPropio.esMiTurno())
		{
			Carta cartaAJugar = this.cartas.getPrimerCarta();
			this.campoPropio.recibirCartaJugada(cartaAJugar);	
		}
	}
	
	public void jugarSegundaCarta()
	{
		if(this.campoPropio.esMiTurno())
		{
			Carta cartaAJugar = this.cartas.getSegundaCarta();
			this.campoPropio.recibirCartaJugada(cartaAJugar);	
		}
	}
	
	public void jugarTercerCarta()
	{
		if(this.campoPropio.esMiTurno())
		{
			Carta cartaAJugar = this.cartas.getTercerCarta();
			this.campoPropio.recibirCartaJugada(cartaAJugar);	
		}
	}
}
