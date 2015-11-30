package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;

public class ManejadorTruco {
	
	private List<Jugable> jugadores;
	private Canto nivelDeApuesta; // puede ser truco, re truco o vale 4
	private Jugable ganador;
	private List<Resultado> resultadosJugadas;
	private Equipo equipoConVentaja;
	private int jugadasRealizadas; // para llevar la cuenta si son 1 2 o 3 en caso de empate en alguna
	private boolean ventaja;
	
	public ManejadorTruco(){
		
		 this.nivelDeApuesta = null; // No hay ningun estado posible a menos que se cante algo 
		 this.resultadosJugadas = new LinkedList<Resultado>();
		 this.jugadasRealizadas = 0;
		 this.equipoConVentaja = new Equipo();
		 this.ventaja = false;
	}

	
	public void setJugadoresEnfrentados(List<Jugable> jugadoresEnfrentados){
		
		this.jugadores = jugadoresEnfrentados;
	}
	
	
	
	public void setNivelApuesta(Canto unCanto) {
			
		this.nivelDeApuesta = unCanto;
	}
	
	public int getPuntajePorGanar(){
		
		return this.nivelDeApuesta.getPuntosGanados(this.ganador);
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


	/*Devuelve el ganador de la jugada*/
	public void resolverJugada(Jugada nuevaJugada) {
		
		
        Resultado resultadoJugada = nuevaJugada.confrontar(this.jugadores);
        this.resultadosJugadas.add(resultadoJugada);
        
        if(this.resultadosJugadas.size() >=2 ){ //ya puede haber un ganador
            	
        	for(Resultado resultado:this.resultadosJugadas){
        		
        		
        	}
        }
        else{
        	
        }
                        
        this.jugadasRealizadas++;
		
	}

}
