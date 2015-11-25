package algoritmosyprogramacion3.tp2.pruebasunitarias;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Jugable;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.RotacionStrategy;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionPicaPica;

public class RotacionPicaPicaTest {
	
	private Jugable jugador1;
	private Jugable jugador2;
	private Jugable jugador3;
	private Jugable jugador4;
	private Jugable jugador5;
	private Jugable jugador6;
	private LinkedList<Jugable> jugadores;
	private RotacionStrategy rotacionPicaPica;
	
	@Before
	public void setUp(){
		
		jugador1= new Jugador("Patricio");
		jugador2 = new Jugador("Matias");
		jugador3= new Jugador("Jorge");
		jugador4 = new Jugador("Pepe");
		jugador5 = new Jugador("Julian");
		jugador6 = new Jugador("Santiago");
		
		jugadores= new LinkedList<Jugable>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);
		jugadores.add(jugador5);
		jugadores.add(jugador6);
		rotacionPicaPica = new StrategyRotacionPicaPica(jugadores);
	}
	

	@Test
	public void testRotacionDeTurnosRondaPicaPica(){
		
		/*Juega la primera pareja (jugador 1 vs jugador 6) */
	    Jugable jugadorConTurno = jugador1;
	    
	    jugadorConTurno = this.rotacionPicaPica.getJugadorConTurno();
	    Assert.assertTrue(jugador1== jugadorConTurno);
	    
	    jugadorConTurno = this.rotacionPicaPica.getJugadorConTurno();
	    Assert.assertTrue(jugador4 == jugadorConTurno);
	    
	    jugadorConTurno = this.rotacionPicaPica.getJugadorConTurno();
	    Assert.assertTrue(jugador1 == jugadorConTurno);
	    jugadorConTurno = this.rotacionPicaPica.getSiguienteJugadorMano();
	    
	    /*Juega la segunda pareja (jugador 2 vs jugador 5)  */
	    Assert.assertTrue(jugador2== jugadorConTurno);
	    	    
	    jugadorConTurno = this.rotacionPicaPica.getJugadorConTurno();
	    Assert.assertTrue(jugador5 == jugadorConTurno);
	    
	    jugadorConTurno = this.rotacionPicaPica.getJugadorConTurno();
	    Assert.assertTrue(jugador2 == jugadorConTurno);
	    jugadorConTurno = this.rotacionPicaPica.getSiguienteJugadorMano();
	    
	    /*Juega la tercera pareja (jugador 3 vs jugador 4)  */
	    Assert.assertTrue(jugador3 == jugadorConTurno);
	    
	    jugadorConTurno = this.rotacionPicaPica.getJugadorConTurno();
	    Assert.assertTrue(jugador6 == jugadorConTurno);
	    
	    jugadorConTurno = this.rotacionPicaPica.getJugadorConTurno();
	    Assert.assertTrue(jugador3 == jugadorConTurno);
	    jugadorConTurno = this.rotacionPicaPica.getSiguienteJugadorMano();
	    	
	}
	

	@Test
	public void testRotacionDeManoPartidaPicaPica(){
	
       Jugable jugadorMano = jugador1;		
       
       jugadorMano = this.rotacionPicaPica.getSiguienteJugadorMano();
       Assert.assertTrue(jugadorMano ==  jugador2);
       
       jugadorMano = this.rotacionPicaPica.getSiguienteJugadorMano();
       Assert.assertTrue(jugadorMano ==  jugador3);
	}
	
}
