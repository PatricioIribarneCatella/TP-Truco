package truco.modelo;

import truco.excepciones.CantidadDeEnvidosMaximosSuperadaException;

public class Jugador extends Jugable {
	
	public Jugador(String nombre) {
		
		super();
		this.nombre = nombre;
	}

	public void cantarEnvido()
	{
		try{
		
			this.moderador.envidoCantado(this);
		}
		catch(CantidadDeEnvidosMaximosSuperadaException e){
			
		}
	}
	
	public void cantarRealEnvido(){
		
		this.moderador.realEnvidoCantado(this);
	}
	
	public void cantarFaltaEnvido(){
		
		this.moderador.faltaEnvidoCantado(this);
	}
	
	public void cantarTruco(){
		
		this.moderador.trucoCantado(this);
	}
	
	public void cantarRetruco(){
		
		this.moderador.reTrucoCantado(this);
	}
	
	public void cantarValeCuatro(){
		
		this.moderador.valeCuatroCantado(this);
	}
	
	public void irseAlMazo()
	{
		this.cartas.removerCartas();
	}
	
	public void aceptarVarianteEnvido()
	{
	     this.moderador.jugadorAceptaVarianteEnvido(this);
	}
	
	public void aceptarVarianteTruco()
	{
	     this.moderador.jugadorAceptaVarianteEnvido(this);
	}
		
	public void rechazarVarianteEnvido()
	{
		this.moderador.jugadorRechazaVarianteEnvido(this);
	}
	
	public void rechazarVarianteTruco()
	{
		this.moderador.jugadorRechazaVarianteTruco(this);
	}
}
