package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

public class ManejadorTruco {
	
	private List<Jugable> jugadores;
	private Canto nivelDeApuesta; 
	private Equipo equipoGanador;
	private List<Resultado> resultadosJugadas;
	private Equipo equipo1;
	private Equipo equipo2;

	
	public ManejadorTruco(){
		
		 this.nivelDeApuesta = null; // No hay ningun estado posible a menos que se cante algo 
		 this.resultadosJugadas = new LinkedList<Resultado>();
	}

	
	public void setJugadoresEnfrentados(List<Jugable> jugadoresEnfrentados){
		
		 this.jugadores = jugadoresEnfrentados;
		 this.equipo1 = this.jugadores.get(0).getEquipo();
		 this.equipo2 = this.jugadores.get(1).getEquipo(); // los jugadores de 2 posiciones contiguas tienen distintos equipos
	}
	
	
	
	public void setNivelApuesta(Canto unCanto) {
			
		this.nivelDeApuesta = unCanto;
	}
	
	public int getPuntajePorGanar(){
		
		if(this.nivelDeApuesta == null){
			return 1;
		}
		return this.nivelDeApuesta.getPuntosGanados(this.equipoGanador);
	}
	
	public int getPuntajePorRechazar(){
		
		return this.nivelDeApuesta.getPuntosPorRechazo();
	}
	
	public void trucoNoQuerido() {
		
		this.nuevaRonda();
	}
	
	public boolean trucoCantado(){
		
		return this.nivelDeApuesta != null;
	}

	
	public boolean alguienGanoDosDeTres(){
		
		int jugadasGanadasEquipo1 = 0;
        int jugadasGanadasEquipo2 = 0;
        
        if(this.resultadosJugadas.size()>1){ //ya puede haber un ganador
        
        	jugadasGanadasEquipo1 = this.rondasGanadasEquipo(equipo1);
        	jugadasGanadasEquipo2 = this.rondasGanadasEquipo(equipo2);
        	
        	if(jugadasGanadasEquipo1 == 2){
        		
        		this.equipoGanador = equipo1;
        		return true;
        	}
        	
        	
            if(jugadasGanadasEquipo2 == 2){
        			
        		this.equipoGanador = equipo2;
       			return true;
       		}
          	
        	return false;
        }
        else{
        	
        	return false;
        }
     
	}
	
	private int rondasGanadasEquipo(Equipo unEquipo) {
		
		boolean aparecioPrimerGanador = false;
		int rondasGanadas = 0;
		int empates = 0;
		Equipo primerGanador = new Equipo(); // el que hace la primera 
		for(Resultado unResultado:this.resultadosJugadas){
			
		   if(unResultado.huboGanador()){
			   
			   if(!aparecioPrimerGanador){
				
				   aparecioPrimerGanador = true;
				   primerGanador =  unResultado.getJugadorGanador().getEquipo(); // el que hace la primera
			   }
			   
			  if(unEquipo == unResultado.getJugadorGanador().getEquipo() && empates == 0){
				
			    	rondasGanadas++;
			  }
			  
			  if(unEquipo == unResultado.getJugadorGanador().getEquipo() && empates > 0){
					
			    	rondasGanadas = 2;
			    	return rondasGanadas;
			  }
		   }
		   else{
			   empates++;
			   if(rondasGanadas>0 && unEquipo == primerGanador){// el empate beneficia a aquel que ya gano una mano
				   
				   rondasGanadas++;
			   }
		   }
			  
		 }  
		return rondasGanadas;
	}


	public Equipo getGanador(){
		
		this.nivelDeApuesta = null;
		return this.equipoGanador;
	}

	/*Devuelve el ganador de la jugada*/
	public void resolverJugada(Jugada nuevaJugada) {
		
		   Resultado resultadoJugada = nuevaJugada.confrontar(this.jugadores);
		   this.resultadosJugadas.add(resultadoJugada);
	}
	
	public void nuevaRonda(){
		
		this.nivelDeApuesta = null;
		this.equipoGanador = null;
		this.resultadosJugadas.clear();
	}

}
