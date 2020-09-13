package algoritmosyprogramacion3.tp2.modelo;

import java.util.List;

public class ManejadorRotacion {

	private List<Jugable> jugadores;
	private EstadoRotacion estado;
	private boolean esPrimeraVezParaCinco;
	private boolean esPrimeraVezParaVenticinco;
	private RotacionStrategy rotacion;
	
	public ManejadorRotacion(List<Jugable> jugadores) {
		this.jugadores = jugadores;
		this.esPrimeraVezParaCinco = true;
		this.esPrimeraVezParaVenticinco = true;
		this.estado = new MenorQueCinco();
		this.rotacion = new StrategyRotacionEnRonda(this.jugadores);
	}
	
	public void verificarEstrategiaDeRotacion(Equipo equipo1, Equipo equipo2) {
		
		if ((equipo1.getPuntaje() >= 5 || equipo2.getPuntaje() >= 5) && this.esPrimeraVezParaCinco) {
			this.esPrimeraVezParaCinco = false;
			this.estado = new MayorQueCincoYMenorQueVenticinco();
		}
		else if ((equipo1.getPuntaje() >= 25 || equipo2.getPuntaje() >= 25) && this.esPrimeraVezParaVenticinco){
			this.esPrimeraVezParaVenticinco = false;
			this.estado = new MayorQueVeinticinco();
		}
	}
	
	public RotacionStrategy getRotacion() {
		
		if (this.estado.esValidaParaCambiarComportamiento()){
			this.rotacion = this.rotacion.getProximaRotacion();
		}
		else{
			this.rotacion = new StrategyRotacionEnRonda(this.jugadores);
		}
			
		return this.rotacion;
	}
}
