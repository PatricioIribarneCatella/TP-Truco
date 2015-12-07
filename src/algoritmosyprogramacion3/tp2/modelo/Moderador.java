package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;

public class Moderador {
	
	private Jugable jugadorConDecisionTruco;
	private Jugable jugadorConDecision; //para la flor y el envido
    private Jugable jugadorConTurno;   
    private Jugable jugadorMano;
    private Mesa mesaACargo;
    private List<Jugable> jugadores;
    private Mazo mazo;
    private Partida partidaEnCurso;
    private RotacionStrategy criterioDeRotacion;
    private ManejadorEnvidos manejadorEnvidos;
    private ManejadorTruco manejadorTruco;
    private ManejadorFlor manejadorFlor;
    private int cantidadDeCartasDeLaJugada;
    
	public Moderador(Mesa unaMesa){

		this.mazo = new  Mazo();
		this.mesaACargo = unaMesa;
		this.jugadores = this.mesaACargo.getJugadores();
		this.jugadorConTurno = this.jugadores.get(0);
		this.jugadorMano = this.jugadores.get(0); //Seteo por default que en toda partida el primer jugador es mano
		this.jugadorConDecision = this.jugadores.get(0);
		this.jugadorConDecisionTruco = this.jugadores.get(0);
		this.manejadorEnvidos = new ManejadorEnvidos();
		this.manejadorTruco = new ManejadorTruco();
		this.manejadorFlor = new ManejadorFlor();
		this.cantidadDeCartasDeLaJugada = 0;
	}
	
	public void setRotacionStrategy(RotacionStrategy criterioDeRotacion){
		
		this.criterioDeRotacion = criterioDeRotacion;
		this.jugadorConTurno = this.criterioDeRotacion.getJugadorConTurno();
		this.jugadorConDecision = this.criterioDeRotacion.getJugadorConDecision();
		this.jugadorConDecisionTruco = this.criterioDeRotacion.getJugadorConDecisionTruco();
		this.manejadorTruco.setJugadoresEnfrentados(this.criterioDeRotacion.getJugadoresEnfrentados());
	}
	
	public void setPartida(Partida unaPartida){
		
		this.partidaEnCurso = unaPartida;
	}
		
	public void repartirCartas(){
				
	   for(int i = 0;i<3 ;i++){
		   
	  	  for(Jugable unJugador:this.jugadores){
		 		
		    	unJugador.recibirCarta(this.mazo.darCarta());	
		  }
	   }
	}

	// Metodo exclusivo para realizar tests de integración
	public void repartirCartas(List<Carta> listaCartas) {
		
		int i;
		int j = 0;
		 
		for (Jugable jugador : this.jugadores) {
			for (i = 0; i < 3; i++) {
				jugador.recibirCarta(listaCartas.get(i + j));
			}
			j += i;
		}
	}
	
	public void seJugoUnaCarta() {
	    	 
    	this.cantidadDeCartasDeLaJugada++;
    	this.jugadorConTurno = this.criterioDeRotacion.getJugadorConTurno(); 
    	List<Jugable> jugadoresEnfrentados = this.criterioDeRotacion.getJugadoresEnfrentados();
    	
    	if (!this.manejadorTruco.trucoCantado()) { // porque las decisiones cambian de alguna forma de comportamiento una vez cantado el truco
    		this.jugadorConDecision = this.criterioDeRotacion.getJugadorConDecision();
    		this.jugadorConDecisionTruco = this.criterioDeRotacion.getJugadorConDecisionTruco();
    	}
    	
    	if (this.cantidadDeCartasDeLaJugada == jugadoresEnfrentados.size()) {
    		
    		this.cantidadDeCartasDeLaJugada = 0;
    		Jugada nuevaJugada = new Jugada();
    		this.manejadorTruco.resolverJugada(nuevaJugada);
    		if (this.manejadorTruco.alguienGanoDosDeTres()) {
                
    			int puntajeASumar = this.manejadorTruco.getPuntajePorGanar();
    			Equipo equipoGanador = this.manejadorTruco.getGanador();
    			this.partidaEnCurso.sumarPuntos(equipoGanador,puntajeASumar);
    			this.rondaFinalizada();
    		}
    	}
    }
	    
	public void rondaFinalizada(){
	
		List<Jugable> jugadoresEnfrentados = this.criterioDeRotacion.getJugadoresEnfrentados();
    	for (Jugable jugador : jugadoresEnfrentados) {
    		jugador.devolverCartasAlMazo();
    	}
    	this.jugadorMano = this.criterioDeRotacion.getSiguienteJugadorMano();
    	this.jugadorConTurno = this.criterioDeRotacion.getJugadorConTurno();
    	this.jugadorConDecision = this.getJugadorConDecision();
    	this.jugadorConDecisionTruco = this.getJugadorConDecisionTruco();
    	this.manejadorEnvidos.nuevaRonda();
    	this.manejadorFlor.nuevaRonda();
    	this.manejadorTruco.nuevaRonda();
    	this.manejadorTruco.setJugadoresEnfrentados(this.criterioDeRotacion.getJugadoresEnfrentados()); //puede que quede en null hasta que en el pica pica cambie el strategy
    	
    	if(this.criterioDeRotacion.rotacionCompleta()) this.partidaEnCurso.rondaFinalizada();
	}
	
	public Jugable getJugadorConTurno(){
	    	
		return this.jugadorConTurno;
	}
	
	public Jugable getJugadorMano(){
		    	
		 return this.jugadorMano;
	}

	private Jugable getJugadorConDecision() {
		
		return this.criterioDeRotacion.getJugadorConDecision();
	}
		
	private Jugable getJugadorConDecisionTruco() {
		
		return this.criterioDeRotacion.getJugadorConDecisionTruco();
	}
		
	public void jugarPrimerCarta(Jugable unJugador){
		
		try{
			unJugador.jugarPrimerCarta();
		}
		catch(TurnoEquivocadoException e){
			
			throw new TurnoEquivocadoException();
		}
	}
	
	public void jugarSegundaCarta(Jugable unJugador){
		
		try{
			unJugador.jugarSegundaCarta();
		}
		catch(TurnoEquivocadoException e){
			
			throw new TurnoEquivocadoException();
		}
	}
	
	public void jugarTercerCarta(Jugable unJugador){
		
		try{
			unJugador.jugarTercerCarta();
		}
		catch(TurnoEquivocadoException e){
			
			throw new TurnoEquivocadoException();
		}
	}
	
    /*METODOS DE ENVIDO Y TRUCO*/
	
	public void florCantada(Jugable jugadorQueCanto) {
		
	    if(this.jugadorConDecision == jugadorQueCanto){
			 
	    	this.manejadorEnvidos.envidoNoQuerido(); //la flor reemplaza al envido
			Canto flor = new Flor();
			this.manejadorFlor.florCantada(flor);
			this.jugadorConDecision = this.getJugadorConDecision(); // ahora el que decide si acepta o no es otro.
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
	}	
	
	public void envidoCantado(Jugable jugadorQueCanto) {
       
		if(this.jugadorConDecision == jugadorQueCanto){
			
			Canto envido = new Envido();
			this.manejadorEnvidos.concatenarCanto(envido);
			this.jugadorConDecision = this.getJugadorConDecision(); // ahora el que decide si acepta o no es otro.
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
	}

	public void realEnvidoCantado(Jugable jugadorQueCanto) {
		
        if(this.jugadorConDecision == jugadorQueCanto){
			
			Canto realEnvido = new RealEnvido();
			this.manejadorEnvidos.concatenarCanto(realEnvido);
			this.jugadorConDecision = this.getJugadorConDecision(); 
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
	}

	public void faltaEnvidoCantado(Jugable jugadorQueCanto) {
	
        if(this.jugadorConDecision == jugadorQueCanto){
			
			Canto faltaEnvido = new FaltaEnvido();
			this.manejadorEnvidos.concatenarCanto(faltaEnvido);
			this.jugadorConDecision = this.getJugadorConDecision(); 
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
	}

	public void trucoCantado(Jugable jugadorQueCanto) {
        
		if(this.jugadorConDecisionTruco == jugadorQueCanto){
			
			Canto truco = new Truco();
			this.manejadorTruco.setNivelApuesta(truco);
			this.jugadorConDecisionTruco = this.getJugadorConDecisionTruco();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }
	}

	public void reTrucoCantado(Jugable jugadorQueCanto) {
		
		if(this.jugadorConDecisionTruco == jugadorQueCanto){
			
			Canto reTruco = new ReTruco();
			this.manejadorTruco.setNivelApuesta(reTruco);
			this.jugadorConDecisionTruco = this.getJugadorConDecisionTruco();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}

	public void valeCuatroCantado(Jugable jugadorQueCanto) {

		if(this.jugadorConDecisionTruco == jugadorQueCanto){
			
			Canto valeCuatro = new ValeCuatro();
			this.manejadorTruco.setNivelApuesta(valeCuatro);
			this.jugadorConDecisionTruco = this.getJugadorConDecisionTruco();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}

	/*Se juega el envido o flor*/
	
	public void jugadorAceptaFlor(Jugable jugadorQueResponde) {
		
        if(this.jugadorConDecision == jugadorQueResponde){
			
			this.manejadorFlor.setJugadoresEnfrentados(this.criterioDeRotacion.getJugadoresEnfrentados());
			this.manejadorFlor.florCantada(new Flor()); //contra flor
			Jugable jugadorGanador = this.manejadorFlor.getGanador();
			int puntajeASumar = this.manejadorFlor.getPuntajeAEntregar();
			this.partidaEnCurso.sumarPuntos(jugadorGanador.getEquipo(),puntajeASumar);
			this.jugadorConDecision = this.criterioDeRotacion.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}
	
	public void jugadorAceptaVarianteEnvido(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
			
			this.manejadorEnvidos.setJugadoresEnfrentados(this.criterioDeRotacion.getJugadoresEnfrentados());
			Jugable jugadorGanador = this.manejadorEnvidos.getGanador();
			int puntajeASumar = this.manejadorEnvidos.calcularPuntajeAcumulado();
			this.partidaEnCurso.sumarPuntos(jugadorGanador.getEquipo(),puntajeASumar);
			this.jugadorConDecision = this.criterioDeRotacion.getJugadorConDecision();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }		
	}
	
	/*Se juega el truco*/
	
	public void jugadorAceptaVarianteTruco(Jugable jugadorQueResponde) {

		if(!(this.jugadorConDecisionTruco == jugadorQueResponde)){
		
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }		
		// caso contrario simplemente se siguen jugando cartas o subiendo apuestas
	}
	
	public void jugadorRechazaFlor(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
				
			this.jugadorConDecision = this.getJugadorConDecision();
			int puntajeASumar = this.manejadorFlor.calcularPuntajeAcumuladoPorRechazo();
			this.manejadorFlor.florNoQuerida();
			this.partidaEnCurso.sumarPuntos(jugadorConDecision.getEquipo(),puntajeASumar);
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}
	
	public void jugadorRechazaVarianteEnvido(Jugable jugadorQueResponde) {

		if(this.jugadorConDecision == jugadorQueResponde){
				
			this.jugadorConDecision = this.getJugadorConDecision();
			int puntajeASumar = this.manejadorEnvidos.calcularPuntajeAcumuladoPorRechazo();
			this.manejadorEnvidos.envidoNoQuerido();
			this.partidaEnCurso.sumarPuntos(this.jugadorConDecision.getEquipo(),puntajeASumar);
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}

	public void jugadorRechazaVarianteTruco(Jugable jugadorQueResponde) {

		if(this.jugadorConDecisionTruco == jugadorQueResponde){
			
			this.jugadorConDecisionTruco = getJugadorConDecisionTruco();
			int puntajeASumar = this.manejadorTruco.getPuntajePorRechazar();
			this.partidaEnCurso.sumarPuntos(jugadorConDecisionTruco.getEquipo(), puntajeASumar);
			this.manejadorTruco.trucoNoQuerido();
			this.rondaFinalizada();
		}
		else{
			
			throw new TurnoParaTomarDecisionEquivocadoException();
	    }	
	}
	
	public Mesa getMesa() {
		return this.mesaACargo;
	}
}
