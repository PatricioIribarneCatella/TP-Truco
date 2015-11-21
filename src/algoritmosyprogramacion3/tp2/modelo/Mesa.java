package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

public class Mesa {
    
	private List<Jugador> jugadores;
	private List<Campo> camposDeJuego; 
    //private Moderador moderador;
    private boolean partidaConFlor;
	
    
    public Mesa(List<Jugador>jugadores,boolean conFlor) {
    	
    	this.camposDeJuego = new LinkedList<Campo>();
    	this.jugadores = jugadores;
    	this.partidaConFlor = conFlor;
    	for(Jugador unJugador:this.jugadores){
    		
    		Campo nuevoCampo = new Campo(unJugador);
    		this.camposDeJuego.add(nuevoCampo);
            unJugador.setMesa(this);
    	}
    	
    	/*this.moderador = new Moderador(this);
    	RotacionStrategy estrategiaDeRotacion = new StrategyRotacionEnRonda(this.jugadores);
    	this.setRotacionStrategy(estrategiaDeRotacion);*/
    }
    
	public boolean seJuegaConFlor(){
		
       return this.partidaConFlor;
	}
	
	    
	
    public List<Jugador> getJugadores()
    {
    	return this.jugadores;
    }
    
    
    /*public void setRotacionStrategy(RotacionStrategy estrategiaDeRotacion){
    	
    	this.moderador.setRotacionStrategy(estrategiaDeRotacion);
    }*/
    
     public void recibirCartaJugada(Jugador unJugador,Carta unaCarta){

   		if(unaCarta.esValidaParaSerJugada())
   		{
    		unaCarta.jugate();
    		Campo campoDelJugador = this.getCampoDelJugador(unJugador);
    		campoDelJugador.recibirCartaJugada(unaCarta);
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
     
     /*public Jugador getJugadorConTurno(){
    	 
    	 return this.moderador.getJugadorConTurno();
     }*/

    	 
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
