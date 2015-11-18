package algoritmosyprogramacion3.tp2.modelo;

import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;

public class Jugador implements Jugable
{
	private Mano cartas;
	private Mesa mesa;
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
		unaCarta.entregada();
		this.cartas.agregarCarta(unaCarta);
	}

	
	public void setMesa(Mesa mesaDeJuego){
		
		this.mesa = mesaDeJuego;
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
	
	public boolean cantarFlor()
	{
	    return this.cartas.hayFlor();
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
	
	
	private boolean esMiTurno() {
		
		return (this == this.mesa.getJugadorConTurno());
	}
	
	/*El jugador coloca una carta de su mano en la mesa*/
	public void jugarPrimerCarta()
	{
		Carta cartaAJugar = this.cartas.getPrimerCarta();
		
		if(this.esMiTurno()){
			try
			{
			    this.mesa.recibirCartaJugada(cartaAJugar);	
			}
			catch(TurnoEquivocadoException e)
			{
				//no hago nada
			}
		}
		else
		{
			throw new TurnoEquivocadoException();
		}
	}
	
	public void jugarSegundaCarta()
	{
		Carta cartaAJugar = this.cartas.getSegundaCarta();
		
		if(this.esMiTurno()){
			try
			{
			    this.mesa.recibirCartaJugada(cartaAJugar);	
			}
			catch(TurnoEquivocadoException e)
			{
				//no hago nada
			}
		}
		else
		{
			throw new TurnoEquivocadoException();
		}
	}
	
	public void jugarTercerCarta()
	{
		Carta cartaAJugar = this.cartas.getTercerCarta();
		
		if(this.esMiTurno()){
			try
			{
			    this.mesa.recibirCartaJugada(cartaAJugar);	
			}
			catch(TurnoEquivocadoException e)
			{
				//no hago nada
			}
		}
		else
		{
			throw new TurnoEquivocadoException();
		}
	}


	public String getNombre() {
		
		return this.nombre;
	}

	public String puntajeAcumulado() {
		
		String puntajeComoString = Integer.toString(this.puntaje);
		return puntajeComoString;
	}
	
	@Override
	public Carta getCartaJugada() {
		return this.cartas.getUltimaCartaJugada();
	}

	@Override
	public void sumarPuntos(int puntos) {
		this.puntaje += puntos; 
	}
}
