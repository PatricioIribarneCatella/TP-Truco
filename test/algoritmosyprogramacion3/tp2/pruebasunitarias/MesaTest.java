package algoritmosyprogramacion3.tp2.pruebasunitarias;

import  org.junit.Assert;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Campo;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.Mesa;
import algoritmosyprogramacion3.tp2.modelo.MesaDeCuatro;
import algoritmosyprogramacion3.tp2.modelo.MesaDeDos;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;

public class MesaTest {

	private LinkedList<Jugador> jugadoresPartidaDeDos;
	private LinkedList<Jugador> jugadoresPartidaDeCuatro;
	private Mesa mesaDeDos;
	private Mesa mesaDeCuatro;
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugador3;
	private Jugador jugador4;
	
	@Before
    public void  setUp()
	{
		jugadoresPartidaDeDos = new LinkedList<Jugador>();
		jugadoresPartidaDeCuatro = new LinkedList<Jugador>();
		jugador1= new Jugador("Pepe");
	    jugador2 = new Jugador("Jorgito");
	    jugador3 = new Jugador("Julian");
	    jugador4 = new Jugador("Anita");
	    
	    jugadoresPartidaDeDos.add(jugador1);
	    jugadoresPartidaDeDos.add(jugador2);
	    
	    jugadoresPartidaDeCuatro.add(jugador1);
	    jugadoresPartidaDeCuatro.add(jugador2);
	    jugadoresPartidaDeCuatro.add(jugador3);
	    jugadoresPartidaDeCuatro.add(jugador4);
	    
		mesaDeDos = new MesaDeDos(jugadoresPartidaDeDos,true);
		mesaDeCuatro = new MesaDeCuatro(jugadoresPartidaDeCuatro,true);
	}
	
	
	@Test
	public void testCreacionMesaDeDosYDeCuatroExitosa() {
		
		Assert.assertTrue(mesaDeDos.partidaConFlor());
		Assert.assertTrue(mesaDeCuatro.partidaConFlor());
	}
	
	
	@Test
	public void testRotacionDeTurnosParaDosJugadores(){
		 
		Jugador jugadorActual = mesaDeDos.getJugadorActual();
		Assert.assertTrue(jugador1 == jugadorActual);
		
		mesaDeDos.cambiarTurno();
		jugadorActual = mesaDeDos.getJugadorActual();
		Assert.assertTrue(jugador2 == jugadorActual);
		
	}
	
	@Test
	public void testRotacionDeTurnosParaCuatroJugadores(){
		 
		Jugador jugadorActual = mesaDeCuatro.getJugadorActual();
		Assert.assertTrue(jugador1 == jugadorActual);
		
		mesaDeCuatro.cambiarTurno();
		jugadorActual = mesaDeCuatro.getJugadorActual();
		Assert.assertTrue(jugador2 == jugadorActual);
		
		mesaDeCuatro.cambiarTurno();
		jugadorActual = mesaDeCuatro.getJugadorActual();
		Assert.assertTrue(jugador3 == jugadorActual);
		
		mesaDeCuatro.cambiarTurno();
		jugadorActual = mesaDeCuatro.getJugadorActual();
		Assert.assertTrue(jugador4 == jugadorActual);
		
	}
	
	@Test
	public void testJugarCarta(){
		
		Carta anchoDeEspada = new UnoDeEspada();
		Carta anchoDeBasto = new UnoDeBasto();
		Carta sieteDeEspada = new SieteDeEspada();
		
		Campo campoJugador1 = new Campo(jugador1, mesaDeDos);
		jugador1.setCampo(campoJugador1);
		
		jugador1.recibirCarta(anchoDeEspada);
		jugador1.recibirCarta(anchoDeBasto);
		jugador1.recibirCarta(sieteDeEspada);
		
		jugador1.jugarPrimerCarta(); //juego el ancho de espada
		
		Assert.assertTrue(campoJugador1.getCarta(0) ==  anchoDeEspada);
		Assert.assertTrue(jugador2 == mesaDeDos.getJugadorActual());
		
	}
	
	
	
	

}
