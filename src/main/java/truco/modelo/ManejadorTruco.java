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
	private int jugadasGanadasEquipo1;
    private int jugadasGanadasEquipo2;

	
	public ManejadorTruco(){
		
		 this.resultadosJugadas = new LinkedList<Resultado>();
		 jugadasGanadasEquipo1 = 0;
		 jugadasGanadasEquipo2 = 0;
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
	

	
	public boolean trucoCantado(){
		
		return this.nivelDeApuesta != null;
	}

	
	public boolean alguienGanoDosDeTres(){
		
        if(this.resultadosJugadas.size()>1){ //ya puede haber un ganador
        
        	this.jugadasGanadasEquipo1 = this.contarRondasGanadasPorEquipo(equipo1);
        	this.jugadasGanadasEquipo2 = this.contarRondasGanadasPorEquipo(equipo2);
        	
        	if(this.jugadasGanadasEquipo1 == 2){
        		
        		this.equipoGanador = equipo1;
        		return true;
        	}
        	
            if(this.jugadasGanadasEquipo2 == 2){
        			
        		this.equipoGanador = equipo2;
       			return true;
       		}
          	
        	return false;
        }
        else{
        	
        	return false;
        }
     
	}
	
	private int contarRondasGanadasPorEquipo(Equipo unEquipo) {
		
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
			   
			  if(unEquipo == unResultado.getJugadorGanador().getEquipo()  && empates == 0){
				
			    	rondasGanadas++;
			  }
			  
			  if(unEquipo == unResultado.getJugadorGanador().getEquipo() && empates > 0){
					
			    	rondasGanadas = 2; // si llegan a empatar las rondas anteriors pero despues alguien gana ,la jugada termina ahi.
			    	return rondasGanadas;
			  }
		   }
		   else{
			   empates++;
			   if(unEquipo == primerGanador){// el empate beneficia a aquel que ya gano una mano
				   
				   rondasGanadas++;
			   }
		   }
			  
		 }  
		return rondasGanadas;
	}


	public Equipo getGanador(){
		
		return this.equipoGanador;
	}

	/*Devuelve el ganador de la jugada*/
	public void resolverJugada(Jugada nuevaJugada) {
		
		   Resultado resultadoJugada = nuevaJugada.confrontar(this.jugadores);
		   this.resultadosJugadas.add(resultadoJugada);
	}
	
	public void trucoNoQuerido(Equipo equipoQueRechaza){
		
		  for(Jugable unJugador: this.jugadores){
			   
			   if(unJugador.getEquipo() != equipoQueRechaza){
					   
				   this.equipoGanador =  unJugador.getEquipo();
			   }
		   }
	}
	
	public void nuevaRonda(){
		
		this.jugadasGanadasEquipo1 = 0;
		this.jugadasGanadasEquipo2 = 0;
		this.nivelDeApuesta = null;
		this.equipoGanador = null;
		this.resultadosJugadas.clear();
	}

}
