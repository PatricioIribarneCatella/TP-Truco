package algoritmosyprogramacion3.tp2.pruebasunitarias;

import  org.junit.Assert;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.RotacionStrategy;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionEnRonda;

public class RotacionEnRondaTest {

	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugador3;
	private Jugador jugador4;
	private Jugador jugador5;
	private Jugador jugador6;
	private LinkedList<Jugador> jugadores;
	private RotacionStrategy rotacionEnRonda;
	
	
	@Before
	public void setUp(){
		
		jugador1= new Jugador("1");
		jugador2 = new Jugador("2");
		jugador3= new Jugador("3");
		jugador4 = new Jugador("4");
		jugador5 = new Jugador("5");
		jugador6 = new Jugador("6");
		
		jugadores= new LinkedList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);
		jugadores.add(jugador5);
		jugadores.add(jugador6);
		rotacionEnRonda = new StrategyRotacionEnRonda(jugadores);
	}
	

	@Test
	public void testRotacionDeTurnosEnRonda(){
		
		Jugador jugadorConTurno =  jugador1;
		
		jugadorConTurno = this.rotacionEnRonda.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador1);
		
		jugadorConTurno = this.rotacionEnRonda.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador2);
		
		jugadorConTurno = this.rotacionEnRonda.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador3);
		
		jugadorConTurno = this.rotacionEnRonda.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador4);
		
		jugadorConTurno = this.rotacionEnRonda.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador5);
		
		jugadorConTurno = this.rotacionEnRonda.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador6);
		
		jugadorConTurno = this.rotacionEnRonda.getJugadorConTurno();
		Assert.assertTrue(jugadorConTurno == jugador1);
	}
	
	@Test
	public void testRotacionDeManoEnRonda(){
		
		Jugador jugadorMano = jugador1;
		
		for(int i = 0 ; i<6;i++){
			jugadorMano = this.rotacionEnRonda.getSiguienteJugadorMano();
		}
		
		Assert.assertTrue(jugadorMano == jugador1);
	}
	
}
