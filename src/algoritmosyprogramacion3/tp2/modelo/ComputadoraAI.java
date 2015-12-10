package algoritmosyprogramacion3.tp2.modelo;

import algoritmosyprogramacion3.tp2.excepciones.CartaYaJugadaException;

public class ComputadoraAI extends Jugable {
	
	public ComputadoraAI() {
		
		super();
		this.nombre = "Computadora";
	}
	
	public void darRespuestaAEnvido() {

	     this.moderador.jugadorAceptaVarianteEnvido(this);
	}
	
	public void darRespuestaARealEnvido() {
		
	     this.moderador.jugadorAceptaVarianteEnvido(this);
	}
	
	public void darRespuestaAFaltaEnvido() {
		
	     this.moderador.jugadorAceptaVarianteEnvido(this);
	}
		
	public void darRespuestaATruco() {
		
	     this.moderador.jugadorAceptaVarianteTruco(this);
	}
	
	public void darRespuestaATurno() {
		
		  this.jugarCarta();
	}
	
	private Evento jugarCarta() {

		/*Intenta jugar una carta hasta que el juego se lo permita*/
		try{

			this.jugarPrimerCarta();
		}
		catch(CartaYaJugadaException e){
			
			try {
				
				this.jugarSegundaCarta();
			}
			catch(CartaYaJugadaException d){
				
				this.jugarTercerCarta();
			}		
		}
		return new JugarCarta();
	}
}
