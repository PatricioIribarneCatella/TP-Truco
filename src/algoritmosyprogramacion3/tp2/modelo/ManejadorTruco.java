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
	private int rondasJugadas; // para llevar la cuenta si son 1 2 o 3 en caso de empate en alguna
	private boolean ventaja;
	
	public ManejadorTruco(){
		
		 this.nivelDeApuesta = null; // No hay ningun estado posible a menos que se cante algo 
		 this.resultadosJugadas = new LinkedList<Resultado>();
		 this.ventaja = false;
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
		
		return this.nivelDeApuesta.getPuntosGanados(this.equipoGanador);
	}
	
	public int getPuntajePorRechazar(){
		
		return this.nivelDeApuesta.getPuntosPorRechazo();
	}
	
	public void trucoNoQuerido() {
		
		this.nivelDeApuesta = null;
	}
	
	public boolean trucoCantado(){
		
		return this.nivelDeApuesta != null;
	}

	
	public boolean alguienGanoDosDeTres(){
		
		int jugadasGanadasEquipo1 = 0;
        int jugadasGanadasEquipo2 = 0;
        
        if(this.resultadosJugadas.size()>1){ //ya puede haber un ganador
        
        	System.out.println(resultadosJugadas.get(0).getJugadorGanador().getNombre());
        	System.out.println(resultadosJugadas.get(1).getJugadorGanador().getNombre());
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
		this.resultadosJugadas.clear();
	}

}
