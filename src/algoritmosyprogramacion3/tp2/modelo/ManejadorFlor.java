package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

public class ManejadorFlor {

	private List<Jugable> jugadores;
	private List<Canto> floresAcumuladas; //pueden ser a lo sumo 2
	private Jugable ganador;
	
	public ManejadorFlor(){
		
		this.floresAcumuladas = new LinkedList<Canto>();
	}

	
	public void setJugadoresEnfrentados(List<Jugable> jugadoresEnfrentados){
		
		this.jugadores = jugadoresEnfrentados;
	}
	
	
	public void florCantada(Canto unCanto){
		
		this.floresAcumuladas.add(unCanto);
	}
	
	public Jugable getGanador(){
		
		Jugable ganador = this.getJugadoresConPuntajeMasAlto().getFirst(); // gana siempre el que esta mas cerca del mazo, en este caso el que esta primero en la lista.
		this.ganador = ganador;
		return ganador;
	}
	
	private LinkedList<Jugable> getJugadoresConPuntajeMasAlto(){
		
		LinkedList<Jugable> jugadoresConPuntajeMaximo = new LinkedList<Jugable>();
        int puntajeGanador  = this.getPuntajeGanador();
		
		for(Jugable unJugador:this.jugadores){
			
		   int puntajeJugador = Integer.parseInt(unJugador.declararPuntosFlor());
		   if(puntajeJugador == puntajeGanador){
			   
			   jugadoresConPuntajeMaximo.add(unJugador);
		   }
		}
		
		return jugadoresConPuntajeMaximo;
	}
	
	
   public int getPuntajeGanador(){
	   
	    int florDelJugador;
		int florMasAlta = -1; // -1 para que el primer jugador de la lista supere este numero siempre
		for(Jugable unJugador:this.jugadores){
			
			florDelJugador = Integer.parseInt(unJugador.declararPuntosFlor());
			if(florDelJugador > florMasAlta){
				
				florMasAlta =  florDelJugador;
			}
		}
		return florMasAlta;
   }
   
   
   public int getPuntajeAEntregar(){
		
		int puntajeAcumulado = 0; 
		if(!this.floresAcumuladas.isEmpty()){
			
			for(Canto unCanto:this.floresAcumuladas){
				
				puntajeAcumulado += unCanto.getPuntosGanados(this.ganador.getEquipo());
			}
		}
		return puntajeAcumulado;
	}
	
	public int calcularPuntajeAcumuladoPorRechazo(){
		
		return this.getPuntajeAEntregar();
	}
	
	
	public void florNoQuerida(){
		
		this.floresAcumuladas.clear();
	}
	
	public void nuevaRonda(){
		
		this.ganador = null;
		this.floresAcumuladas.clear();
	}
	
}
