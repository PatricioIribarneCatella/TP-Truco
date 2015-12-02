package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

import algoritmosyprogramacion3.tp2.excepciones.CantidadDeEnvidosMaximosSuperadaException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;

public class Jugador implements Jugable {
	
	private int puntaje;
	private Mano cartas;
	private Moderador moderador;
	private Mesa mesa;
	private String nombre;
	private Equipo equipo;
	
	public Jugador(String nombre)
	{
		this.nombre = nombre;
		this.puntaje = 0;
		this.cartas = new Mano();
	}
	
	public void setModerador(Moderador moderadorDeLaPartida){
		
		this.moderador =  moderadorDeLaPartida;
	}
	
	public void setMesa(Mesa mesaDeJuego){
		
		this.mesa = mesaDeJuego;
	}
	
	//Metodo que permite que un usuario reciba nuevas cartas al comienzo de cada ronda
	public void recibirCarta(Carta unaCarta)
	{
		this.cartas.agregarCarta(unaCarta);
	}

	public void cantarEnvido()
	{
		try{
		
			this.moderador.envidoCantado(this);
		}
		catch(CantidadDeEnvidosMaximosSuperadaException e){
			
		}
	}
	
	public void cantarRealEnvido(){
		
		this.moderador.realEnvidoCantado(this);
	}
	
	public void cantarFaltaEnvido(){
		
		this.moderador.faltaEnvidoCantado(this);
	}
	
	public void cantarTruco(){
		
		this.moderador.trucoCantado(this);
	}
	
	public void cantarRetruco(){
		
		this.moderador.reTrucoCantado(this);
	}
	
	public void cantarValeCuatro(){
		
		this.moderador.valeCuatroCantado(this);
	}	
	
	
	public boolean cantarFlor()
	{
	    return this.cartas.hayFlor();
	}
	
	public void irseAlMazo()
	{
		this.cartas.removerCartas();
		//this.moderador.jugadorSeFueAlMazo(this);
	}
	
	
	public void aceptarVarianteEnvido()
	{
	     this.moderador.jugadorAceptaVarianteEnvido(this);
	}
	
	public void aceptarVarianteTruco()
	{
	     this.moderador.jugadorAceptaVarianteEnvido(this);
	}
		
	public void rechazarVarianteEnvido()
	{
		this.moderador.jugadorRechazaVarianteEnvido(this);
	}
	
	public void rechazarVarianteTruco()
	{
		this.moderador.jugadorRechazaVarianteTruco(this);
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
		
		return (this == this.moderador.getJugadorConTurno());
	}
	
	/*El jugador coloca una carta de su mano en la mesa*/
	public void jugarPrimerCarta() {
		
		Carta cartaAJugar = this.cartas.getPrimerCarta();
		
		if (this.esMiTurno()) {
		
			this.mesa.recibirCartaJugada(this,cartaAJugar);	
			this.moderador.seJugoUnaCarta();
			
		} else {
			throw new TurnoEquivocadoException();
		}
	}
	
	public void jugarSegundaCarta() {
		
		Carta cartaAJugar = this.cartas.getSegundaCarta();
		
		if (this.esMiTurno()) {
			
			this.mesa.recibirCartaJugada(this,cartaAJugar);	
			this.moderador.seJugoUnaCarta();
			
		} else {
			throw new TurnoEquivocadoException();
		}
	}
	
	public void jugarTercerCarta() {
		
		Carta cartaAJugar = this.cartas.getTercerCarta();
		
		if (this.esMiTurno()) {
			
			this.mesa.recibirCartaJugada(this,cartaAJugar);	
			this.moderador.seJugoUnaCarta();
			
		} else {
			throw new TurnoEquivocadoException();
		}
	}

	@Override
	public String getNombre() {
		
		return this.nombre;
	}

	@Override
	public String puntajeAcumuladoComoString() {
		
		String puntajeComoString = Integer.toString(this.puntaje);
		return puntajeComoString;
	}
	
	@Override
	public int puntajeAcumulado() {
		return this.puntaje;
	}
	
	@Override
	public Carta getCartaJugada() {
		return this.cartas.getUltimaCartaJugada();
	}

	@Override
	public void sumarPuntos(int puntos) {
		this.equipo.sumarPuntos(puntos); 
	}

	@Override
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public Equipo getEquipo() {
		return this.equipo;
	}

	@Override
	public List<Carta> getCartas() {
		return this.cartas.getCartas();
	}

	@Override
	public void devolverCartasAlMazo() {
		this.cartas.vaciar();
	}
}
