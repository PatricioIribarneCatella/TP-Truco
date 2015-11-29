package algoritmosyprogramacion3.tp2.modelo;

import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.CantidadDeEnvidosMaximosSuperadaException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;

public class Partida {

	private EstadoPartida estado;
	private Moderador moderador;
	private int cantidadDeEnvidosCantados;
	
	public Partida(Moderador moderador) {
		
		this.moderador = moderador;
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void iniciarPartida() {
		
		this.estado = new TurnoJugador();
		this.cantidadDeEnvidosCantados = 0;
	}
	
	public void jugarPrimerCartaJugador(Jugable unJugador){
		
		if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
		try{
			this.moderador.jugarPrimerCarta(unJugador);	
		}
		catch(TurnoEquivocadoException e){
			
			throw new TurnoEquivocadoException();//lanzo de nuevo y que resuelva el juego truco.
		}
	}
	
    public void jugarSegundaCartaJugador(Jugable unJugador){
	
    	if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
    	
		try{
			this.moderador.jugarSegundaCarta(unJugador);	
		}
		catch(TurnoEquivocadoException e){
			
			throw new TurnoEquivocadoException();
		}
	}

   public void jugarTercerCartaJugador(Jugable unJugador){

	   if (!this.estado.esValidoParaJugarCarta()) throw new AccionInvalidaException();
	   
	   try{
		   this.moderador.jugarTercerCarta(unJugador);	
	   }
		catch(TurnoEquivocadoException e){
			
			throw new TurnoEquivocadoException();
		}
   }
	
	
   public void cantarTruco(Jugable jugadorQueCanta) {
		
	   if (!this.estado.esValidoParaCantarTruco()) throw new AccionInvalidaException(); 
	  
		try{
			  this.moderador.trucoCantado(jugadorQueCanta);
			  this.estado = new TrucoCantado();
			  this.cantidadDeEnvidosCantados = 0;
		}
		catch(TurnoParaTomarDecisionEquivocadoException e){
				
			throw new TurnoParaTomarDecisionEquivocadoException();
		}
	   
   }
	
	public void cantarReTruco(Jugable jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarReTruco()) throw new AccionInvalidaException(); 

		try{
			  this.moderador.reTrucoCantado(jugadorQueCanta);
			  this.estado = new ReTrucoCantado();
			  this.cantidadDeEnvidosCantados = 0;
		}
		catch(TurnoParaTomarDecisionEquivocadoException e){
				
			throw new TurnoParaTomarDecisionEquivocadoException();
		}
	}
	
	public void cantarValeCuatro(Jugable jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarValeCuatro()) throw new AccionInvalidaException(); 
		
		try{
			  this.moderador.valeCuatroCantado(jugadorQueCanta);
			  this.estado = new ValeCuatroCantado();
			  this.cantidadDeEnvidosCantados = 0;
		}
		catch(TurnoParaTomarDecisionEquivocadoException e){
				
			throw new TurnoParaTomarDecisionEquivocadoException();
		}
	}
	
	public void cantarEnvido(Jugable jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarEnvido()) throw new AccionInvalidaException();
		if (this.cantidadDeEnvidosCantados == 3) throw new CantidadDeEnvidosMaximosSuperadaException();
		
		try{
		  this.moderador.envidoCantado(jugadorQueCanta);
		  this.estado = new EnvidoCantado();
		  this.cantidadDeEnvidosCantados++;
		}
		catch(TurnoParaTomarDecisionEquivocadoException e){
			
			throw new TurnoParaTomarDecisionEquivocadoException();
		}
		
	}
	
	public void cantarRealEnvido(Jugable jugadorQueCanta) {
	
		if (!this.estado.esValidoParaCantarRealEnvido()) throw new AccionInvalidaException();
		try{
			  this.moderador.realEnvidoCantado(jugadorQueCanta);
			  this.estado = new RealEnvidoCantado();
			  this.cantidadDeEnvidosCantados = 0;
		}
		catch(TurnoParaTomarDecisionEquivocadoException e){
				
			throw new TurnoParaTomarDecisionEquivocadoException();
		}
	}
	
	public void cantarFaltaEnvido(Jugable jugadorQueCanta) {
		
		if (!this.estado.esValidoParaCantarFaltaEnvido()) throw new AccionInvalidaException();
		this.estado = new FaltaEnvidoCantado();
		try{
			  this.moderador.faltaEnvidoCantado(jugadorQueCanta);
			  this.estado = new FaltaEnvidoCantado();
			  this.cantidadDeEnvidosCantados = 0;
		}
		catch(TurnoParaTomarDecisionEquivocadoException e){
				
			throw new TurnoParaTomarDecisionEquivocadoException();
		}
	}
	
	public void aceptarVarianteEnvido(Jugable jugadorQueAcepta) {
		
		if (!this.estado.esValidoParaAceptar()) throw new AccionInvalidaException();
		
		try{
			
			this.moderador.jugadorAceptaVarianteEnvido(jugadorQueAcepta);
			 // habria que crear otro estado que se mantenga hasta que se declaren todos los valores de envido
		}
		catch(TurnoParaTomarDecisionEquivocadoException e){
				
			throw new TurnoParaTomarDecisionEquivocadoException();
		}	
	}
	
    public void aceptarVarianteTruco(Jugable jugadorQueAcepta) {
		
		if (!this.estado.esValidoParaAceptar()) throw new AccionInvalidaException();
	
		try{
			
			this.moderador.jugadorAceptaVarianteTruco(jugadorQueAcepta);
		}
		catch(TurnoParaTomarDecisionEquivocadoException e){
				
			throw new TurnoParaTomarDecisionEquivocadoException();
		}
	}
	
	
    public void rechazarVarianteDeEnvido(Jugable jugadorQueRechaza) {
		
		if (!this.estado.esValidoParaRechazar()) throw new AccionInvalidaException();
		
        try{
			
    		this.moderador.jugadorRechazaVarianteEnvido(jugadorQueRechaza);
    		this.cantidadDeEnvidosCantados = 0;
    		this.estado = new TurnoJugador();
		}
		catch(TurnoParaTomarDecisionEquivocadoException e){
				
			throw new TurnoParaTomarDecisionEquivocadoException();
		}
		
	}
    
	public void rechazarVarianteDeTruco(Jugable jugadorQueRechaza) {
		
		if (!this.estado.esValidoParaRechazar()) throw new AccionInvalidaException();
		//this.estado = new PartidaFinalizada();// esto no va por que la partida no termina a menos que algun jugable llegue a 30
		
        try{
		
        	this.moderador.jugadorRechazaVarianteTruco(jugadorQueRechaza);
    		this.cantidadDeEnvidosCantados = 0;
    		this.moderador.rondaFinalizada();
    		this.estado = new TurnoJugador();
		}
		catch(TurnoParaTomarDecisionEquivocadoException e){
				
			throw new TurnoParaTomarDecisionEquivocadoException();
		}
		
		
	}

}
