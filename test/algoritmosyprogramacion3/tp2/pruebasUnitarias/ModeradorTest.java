package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Jugable;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.Mesa;
import algoritmosyprogramacion3.tp2.modelo.MesaConFlor;
import algoritmosyprogramacion3.tp2.modelo.MesaSinFlor;
import algoritmosyprogramacion3.tp2.modelo.Moderador;
import algoritmosyprogramacion3.tp2.modelo.RotacionStrategy;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionEnRonda;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionPicaPica;

public class ModeradorTest {

	private Mesa mesaDeDos;
	private Mesa mesaDeCuatro;
	private Mesa mesaPicaPica;
	private Jugable jugador1;
	private Jugable jugador2;
	private Jugable jugador3;
	private Jugable jugador4;
	private Jugable jugador5;
	private Jugable jugador6;
	private LinkedList<Jugable> jugadoresMesaDeDos;
	private LinkedList<Jugable> jugadoresMesaDeCuatro;
	private LinkedList<Jugable> jugadoresMesaDeSeis;
	private Moderador moderadorMesaDeDos;
	private Moderador moderadorMesaDeCuatro;
	private Moderador moderadorMesaDeSeis;
	private RotacionStrategy rotacionEnRonda;
	private RotacionStrategy rotacionPicaPica;
	
	@Before
	public void setUp(){		
		jugador1 = new Jugador("1");
		jugador2 = new Jugador("2");
		jugador3 = new Jugador("3");
		jugador4 = new Jugador("4");
		jugador5 = new Jugador("5");
		jugador6 = new Jugador("6");
				
		jugadoresMesaDeDos = new LinkedList<Jugable>();
		jugadoresMesaDeCuatro = new LinkedList<Jugable>();
		jugadoresMesaDeSeis = new LinkedList<Jugable>();
		jugadoresMesaDeDos.add(jugador1);
		jugadoresMesaDeDos.add(jugador2);
		jugadoresMesaDeCuatro.add(jugador1);
		jugadoresMesaDeCuatro.add(jugador2);
		jugadoresMesaDeCuatro.add(jugador3);
		jugadoresMesaDeCuatro.add(jugador4);
		jugadoresMesaDeSeis.add(jugador1);
		jugadoresMesaDeSeis.add(jugador2);
		jugadoresMesaDeSeis.add(jugador3);
		jugadoresMesaDeSeis.add(jugador4);
		jugadoresMesaDeSeis.add(jugador5);
		jugadoresMesaDeSeis.add(jugador6);
		
		
	    RotacionStrategy criterioRotacionMesaDeDos = new StrategyRotacionEnRonda(this.jugadoresMesaDeDos);
	    RotacionStrategy criterioRotacionMesaDeCuatro = new StrategyRotacionEnRonda(this.jugadoresMesaDeCuatro);
	    rotacionPicaPica = new StrategyRotacionPicaPica(this.jugadoresMesaDeSeis);
	    rotacionEnRonda = new StrategyRotacionEnRonda(this.jugadoresMesaDeSeis);
		mesaDeDos = new MesaConFlor(jugadoresMesaDeDos);
		mesaDeCuatro = new MesaConFlor(jugadoresMesaDeCuatro); 
	    mesaPicaPica = new MesaSinFlor(jugadoresMesaDeSeis);
	    this.moderadorMesaDeDos = new Moderador(mesaDeDos);
	    this.moderadorMesaDeCuatro = new Moderador(mesaDeCuatro);
	    this.moderadorMesaDeSeis = new Moderador(mesaPicaPica);
	    this.moderadorMesaDeDos.setRotacionStrategy(criterioRotacionMesaDeDos);
	    this.moderadorMesaDeCuatro.setRotacionStrategy(criterioRotacionMesaDeCuatro);
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionPicaPica);
	}
	
	@Test
	public void testRotacionDeTurnosPatidaDeDos() {
		
	    Jugable jugadorConTurno = this.moderadorMesaDeDos.getJugadorConTurno();
	    Assert.assertTrue(jugador1 == jugadorConTurno);	
		
	    this.moderadorMesaDeDos.seJugoUnaCarta();	
	    jugadorConTurno = this.moderadorMesaDeDos.getJugadorConTurno();
	    Assert.assertTrue(jugador2 == jugadorConTurno);	
	    
	    this.moderadorMesaDeDos.seJugoUnaCarta();	
	    jugadorConTurno = this.moderadorMesaDeDos.getJugadorConTurno();
	    Assert.assertTrue(jugador1 == jugadorConTurno);	
	}
	
	@Test
	public void testRotacionDeTurnosPartidaDeCuatro(){
		
		    Jugable jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorConTurno();
	        Assert.assertTrue(jugador1 == jugadorConTurno);	
		
		    this.moderadorMesaDeCuatro.seJugoUnaCarta();	
		    jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorConTurno();
		    Assert.assertTrue(jugador2 == jugadorConTurno);	
		    
		    this.moderadorMesaDeCuatro.seJugoUnaCarta();	
		    jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorConTurno();
		    Assert.assertTrue(jugador3 == jugadorConTurno);	

		    this.moderadorMesaDeCuatro.seJugoUnaCarta();	
		    jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorConTurno();
		    Assert.assertTrue(jugador4 == jugadorConTurno);	
		    
		    this.moderadorMesaDeCuatro.seJugoUnaCarta();	
		    jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorConTurno();
		    Assert.assertTrue(jugador1 == jugadorConTurno);	
	}
	
	
	@Test
	public void testRotacionDeManoPartidaDeDos(){
		
		
		 Jugable jugadorMano = this.moderadorMesaDeDos.getJugadorMano();
	     Assert.assertTrue(jugador1 == jugadorMano);
	     
	     this.moderadorMesaDeDos.rondaFinalizada();
	     jugadorMano = this.moderadorMesaDeDos.getJugadorMano();
	     Assert.assertTrue(jugador2 == jugadorMano);

	     this.moderadorMesaDeDos.rondaFinalizada();
	     jugadorMano = this.moderadorMesaDeDos.getJugadorMano();
	     Assert.assertTrue(jugador1 == jugadorMano); 
	}
	
	@Test
	public void testRotacionDeManoPartidaDeCuatro(){
		
		    Jugable jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
	        Assert.assertTrue(jugador1 == jugadorMano);	
		
		    this.moderadorMesaDeCuatro.rondaFinalizada();
		    jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
		    Assert.assertTrue(jugador2 == jugadorMano);	
		    
		    this.moderadorMesaDeCuatro.rondaFinalizada();	
		    jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
		    Assert.assertTrue(jugador3 == jugadorMano);	

		    this.moderadorMesaDeCuatro.rondaFinalizada();;	
		    jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
		    Assert.assertTrue(jugador4 == jugadorMano);	
		    
		    this.moderadorMesaDeCuatro.rondaFinalizada();;	
		    jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
		    Assert.assertTrue(jugador1 == jugadorMano);	
	}
	
	
	@Test
	public void testRotacionDeTurnosRondaPicaPica(){
		
		/*Juega la primera pareja (jugador 1 vs jugador 4) */
	    Jugable jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugador1 == jugadorConTurno);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugador4 == jugadorConTurno);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugador1 == jugadorConTurno);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    /*Juega la segunda pareja (jugador 2 vs jugador 5)  */
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugador2 == jugadorConTurno);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugador5 == jugadorConTurno);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugador2 == jugadorConTurno);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    /*Juega la tercera pareja (jugador 3 vs jugador 6)  */
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugador3 == jugadorConTurno);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugador6 == jugadorConTurno);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugador3 == jugadorConTurno);
	    this.moderadorMesaDeSeis.rondaFinalizada();
		
	}
	
	
	@Test
	public void testCambioDeComportamientoDelModeradorEnMesaConPicaPica(){
		
		this.moderadorMesaDeSeis.setRotacionStrategy(rotacionEnRonda);
		Jugable jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
		Jugable jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
		
		/*Rotacion en ronda*/
		for(int i=0; i<5 ; i++){
			
			this.moderadorMesaDeSeis.seJugoUnaCarta();	
		}
		
		jugadorConTurno =  this.moderadorMesaDeSeis.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador6);
		this.moderadorMesaDeSeis.rondaFinalizada();
		jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
		Assert.assertTrue(jugadorMano == jugador2);
		
		/*Fin ronda ahora cambia el comportamiento*/
		
		/*Ronda pica pica*/
		rotacionPicaPica  = new StrategyRotacionPicaPica(jugadoresMesaDeSeis);
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionPicaPica);
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugadorConTurno == jugador2);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugadorConTurno == jugador2);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    Assert.assertTrue(jugadorConTurno == jugador3);
	    Assert.assertTrue(jugadorMano == jugador3);
	    
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugadorConTurno == jugador4);
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugadorConTurno == jugador1);
	    
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    /*fin ronda pica pica*/
	    
	    /*Vuelve a rotar en ronda*/
	    rotacionEnRonda = new StrategyRotacionEnRonda(jugadoresMesaDeSeis);
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionEnRonda);
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador3);
		Assert.assertTrue(jugadorMano == jugador3);
	    
        for(int i=0; i<5 ; i++){
			
			this.moderadorMesaDeSeis.seJugoUnaCarta();	
		}
        jugadorConTurno =  this.moderadorMesaDeSeis.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador2);
		this.moderadorMesaDeSeis.rondaFinalizada();
		jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
		Assert.assertTrue(jugadorMano == jugador4);
		/*Fin ronda comun, vuelve a pica pica*/
		
		/*Ronda pica pica de nuevo*/
		rotacionPicaPica = new StrategyRotacionPicaPica(this.jugadoresMesaDeSeis);
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionPicaPica);
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugadorConTurno == jugador4);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugadorConTurno == jugador4);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    Assert.assertTrue(jugadorConTurno == jugador2);
	    Assert.assertTrue(jugadorMano == jugador5);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    /*fin ronda pica pica*/
		
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    Assert.assertTrue(jugadorConTurno == jugador5);
	    Assert.assertTrue(jugadorMano == jugador5);
	    
	    /*Vuelve a rotar en ronda*/
	    rotacionEnRonda = new StrategyRotacionEnRonda(jugadoresMesaDeSeis);
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionEnRonda);
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador5);
		Assert.assertTrue(jugadorMano == jugador5);
	    
        for(int i=0; i<5 ; i++){
			
			this.moderadorMesaDeSeis.seJugoUnaCarta();	
		}
        jugadorConTurno =  this.moderadorMesaDeSeis.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador4);
		this.moderadorMesaDeSeis.rondaFinalizada();
		jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
		Assert.assertTrue(jugadorMano == jugador6);
		/*Fin ronda comun, vuelve a pica pica*/
	    
		/*Ronda pica pica de nuevo*/
		rotacionPicaPica = new StrategyRotacionPicaPica(this.jugadoresMesaDeSeis);
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionPicaPica);
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugadorConTurno == jugador6);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugadorConTurno == jugador3);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    Assert.assertTrue(jugadorConTurno == jugador4);
	    Assert.assertTrue(jugadorMano == jugador1);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    /*fin ronda pica pica*/
	}
}
