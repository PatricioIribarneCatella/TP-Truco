package algoritmosyprogramacion3.tp2.modelo;
import java.util.LinkedList;

import algoritmosyprogramacion3.tp2.excepciones.PartidaSinFlorException;


public abstract class Mesa {
    
	protected LinkedList<Jugador> jugadores;
	protected LinkedList<Campo> camposDeJuego; 
	protected int indiceActual;
    protected Jugador jugadorActual;   
    protected Jugador jugadorMano;
    protected boolean conFlor;
    
    
    protected Mesa(LinkedList<Jugador>jugadores,boolean conFlor) {
    	
    	this.camposDeJuego = new LinkedList<Campo>();
    	this.jugadores = jugadores;
    	for(Jugador unJugador:this.jugadores){
    		
    		Campo nuevoCampo = new Campo(unJugador,this);
    		this.camposDeJuego.add(nuevoCampo);
    		unJugador.setCampo(nuevoCampo);
    	}
    	this.conFlor = conFlor;
    	this.jugadorActual = this.jugadores.getFirst();
    	this.jugadorMano =  this.jugadorActual;
    	this.indiceActual = 0;
    }


     public boolean partidaConFlor(){
    	return this.conFlor;
     }

	 public void cambiarTurno() {
		if(this.indiceActual<this.jugadores.size()-1){
			
			this.indiceActual += 1;
		}
		else{
			this.indiceActual = 0;
		}
		this.jugadorActual = this.jugadores.get(this.indiceActual);		
	 }
		
    
    public Jugador getJugadorActual(){
    	
    	return this.jugadorActual;
    }
    
    
    
    
    
    public boolean cantarFlor(){
    	
    	if(!this.partidaConFlor())
    	{
    		throw new PartidaSinFlorException();
    	}
    	return (this.jugadorActual.cantarFlor());
    }
    
    public void cambiarMano(){
    	
    	this.jugadorMano= 
    	
    }
	
    
	
}
