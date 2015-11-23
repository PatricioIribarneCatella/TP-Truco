package algoritmosyprogramacion3.tp2.pruebasunitarias;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugador3;
	private Jugador jugador4;
	private Jugador jugador5;
	private Jugador jugador6;
	private LinkedList<Jugador> jugadoresMesaDeDos;
	private LinkedList<Jugador> jugadoresMesaDeCuatro;
	private LinkedList<Jugador> jugadoresMesaDeSeis;
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
				
		jugadoresMesaDeDos = new LinkedList<Jugador>();
		jugadoresMesaDeCuatro = new LinkedList<Jugador>();
		jugadoresMesaDeSeis = new LinkedList<Jugador>();
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
		
	    Jugador jugadorConTurno = this.moderadorMesaDeDos.getJugadorConTurno();
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
		
		    Jugador jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorConTurno();
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
		
		
		 Jugador jugadorMano = this.moderadorMesaDeDos.getJugadorMano();
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
		
		    Jugador jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
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
	    Jugador jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
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
	public void cambioDeComportamientoDelModeradorEnMesaConPicaPicaTest(){
		
		this.moderadorMesaDeSeis.setRotacionStrategy(rotacionEnRonda);
		Jugador jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
		Jugador jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
		
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
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionPicaPica);
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugadorConTurno == jugador2);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugadorConTurno == jugador1);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    Assert.assertTrue(jugadorConTurno == jugador2);
	    Assert.assertTrue(jugadorMano == jugador2);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    /*fin ronda pica pica*/
	    
	    /*Vuelve a rotar en ronda*/
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    System.out.println(jugadorConTurno.getNombre());
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionEnRonda);
	    
	    
	}
	
	@Test
	public void testRotacionDeManoPartidaPicaPica(){
		
		
	    
	}
	
	

}
