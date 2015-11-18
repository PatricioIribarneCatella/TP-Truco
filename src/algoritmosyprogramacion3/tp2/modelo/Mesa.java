package algoritmosyprogramacion3.tp2.modelo;
import java.util.LinkedList;
import java.util.List;

public abstract class Mesa {
    
	protected List<Jugador> jugadores;
	protected List<Campo> camposDeJuego; 
    protected Moderador moderador;
	
    protected Mesa(List<Jugador>jugadores,boolean conFlor) {
    	
    	this.camposDeJuego = new LinkedList<Campo>();
    	this.jugadores = jugadores;
    	
    	for(Jugador unJugador:this.jugadores){
    		
    		Campo nuevoCampo = new Campo(unJugador);
    		this.camposDeJuego.add(nuevoCampo);
    		//unJugador.setCampo(nuevoCampo);
            unJugador.setMesa(this);
    	}
    	moderador = new Moderador(this,conFlor);
    	
    }
    
    public List<Jugador> getJugadores()
    {
    	return this.jugadores;
    }
    
    
     public void recibirCartaJugada(Carta unaCarta){

   		if(unaCarta.esValidaParaSerJugada())
   		{
    		unaCarta.jugate();
    		Campo campoDelJugador = this.getCampoDelJugador(this.moderador.getJugadorConTurno());
    		campoDelJugador.recibirCartaJugada(unaCarta);
    		this.moderador.cambiarTurno();
        }
    	 
     }
    
     private Campo getCampoDelJugador(Jugador unJugador){
    	 
    	 for(Campo unCampo:this.camposDeJuego){
    		 
    		 if(unCampo.getJugador() == unJugador)
    		 {
    			 return unCampo;
    		 }
    	 }
    	 return null;//nunca va a llegar aca
     }
     
     public Jugador getJugadorConTurno(){
    	 
    	 return this.moderador.getJugadorConTurno();
     }

     public boolean partidaConFlor() {
    	 return this.moderador.seJuegaConFlor();
     }
	 
	 public void cambiarMano(){
	    	
	 }


	public Carta getPrimerCartaJugada(Jugador unJugador) {
		
		Campo campoDelJugador = this.getCampoDelJugador(unJugador);
		return campoDelJugador.getPrimerCartaJugada();
	}
	
	public Carta getSegundaCartaJugada(Jugador unJugador) {
		
		Campo campoDelJugador = this.getCampoDelJugador(unJugador);
		return campoDelJugador.getSegundaCartaJugada();
	}
	
	public Carta getTercerCartaJugada(Jugador unJugador) {
		
		Campo campoDelJugador = this.getCampoDelJugador(unJugador);
		return campoDelJugador.getTercerCartaJugada();
	}
}
