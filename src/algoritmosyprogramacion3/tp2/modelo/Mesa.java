package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

import algoritmosyprogramacion3.tp2.excepciones.CartaYaJugadaException;

public abstract class Mesa {
    
	private List<Jugable> jugadores;
	private List<Campo> camposDeJuego;
    
    public Mesa(List<Jugable>jugadores) {
    	
    	this.camposDeJuego = new LinkedList<Campo>();
    	this.jugadores = jugadores;
    	for(Jugable unJugador:this.jugadores){
    		
    		Campo nuevoCampo = new Campo(unJugador);
    		this.camposDeJuego.add(nuevoCampo);
            unJugador.setMesa(this);
    	}
    }
    
	public abstract boolean seJuegaConFlor();
	
    public List<Jugable> getJugadores()
    {
    	return this.jugadores;
    }
    
    private Campo getCampoDelJugador(Jugable unJugador){
    	 
    	for (Campo unCampo : this.camposDeJuego){
    		 
    		if (unCampo.getJugador() == unJugador)
    		{
    			 return unCampo;
    		}
    	}
    	return null;//nunca va a llegar aca
    }
    
    public void recibirCartaJugada(Jugable unJugador,Carta unaCarta) {

   		if (unaCarta.esValidaParaSerJugada()) {
   			
    		unaCarta.jugate();
    		Campo campoDelJugador = this.getCampoDelJugador(unJugador);
    		campoDelJugador.recibirCartaJugada(unaCarta);
        }
   		else {
   			
   			throw new CartaYaJugadaException();
   		}
    }
    
	public Carta getPrimerCartaJugada(Jugable unJugador) {
		
		Campo campoDelJugador = this.getCampoDelJugador(unJugador);
		return campoDelJugador.getPrimerCartaJugada();
	}
	
	public Carta getSegundaCartaJugada(Jugable unJugador) {
		
		Campo campoDelJugador = this.getCampoDelJugador(unJugador);
		return campoDelJugador.getSegundaCartaJugada();
	}
	
	public Carta getTercerCartaJugada(Jugable unJugador) {
		
		Campo campoDelJugador = this.getCampoDelJugador(unJugador);
		return campoDelJugador.getTercerCartaJugada();
	}
}
