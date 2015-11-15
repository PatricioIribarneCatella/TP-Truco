package algoritmosyprogramacion3.tp2.pruebasunitarias;

import  org.junit.Assert;

import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;
import algoritmosyprogramacion3.tp2.modelo.Campo;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeCopa;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeOro;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.Mesa;
import algoritmosyprogramacion3.tp2.modelo.MesaDeCuatro;
import algoritmosyprogramacion3.tp2.modelo.MesaDeDos;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.SieteDeOro;
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
	private Jugador jugador5;
	private Jugador jugador6;
	private Carta anchoDeEspada;
	private Carta anchoDeBasto;
	private Carta sieteDeEspada;
	private Carta sieteDeOro;
	private Carta cuatroDeCopa;
	private Carta cuatroDeOro;
	
	
	@Before
    public void  setUp()
	{
		jugadoresPartidaDeDos = new LinkedList<Jugador>();
		jugadoresPartidaDeCuatro = new LinkedList<Jugador>();
		jugador1= new Jugador("Pepe");
	    jugador2 = new Jugador("Jorgito");
	    jugador3 = new Jugador("Patricio");
	    jugador4 = new Jugador("Anita");
        jugador5 = new Jugador("Santiago");
        jugador6 = new Jugador("Julian");
	    
	    jugadoresPartidaDeDos.add(jugador1);
	    jugadoresPartidaDeDos.add(jugador2);
	    
	    jugadoresPartidaDeCuatro.add(jugador3);
	    jugadoresPartidaDeCuatro.add(jugador4);
	    jugadoresPartidaDeCuatro.add(jugador5);
	    jugadoresPartidaDeCuatro.add(jugador6);
	    
		mesaDeDos = new MesaDeDos(jugadoresPartidaDeDos,true);
		mesaDeCuatro = new MesaDeCuatro(jugadoresPartidaDeCuatro,true);
		
	    anchoDeEspada = new UnoDeEspada();
	    anchoDeBasto = new UnoDeBasto();
		sieteDeEspada = new SieteDeEspada();
		sieteDeOro = new SieteDeOro();
		cuatroDeCopa = new CuatroDeCopa();
		cuatroDeOro = new CuatroDeOro();
				
	}
	
	
	@After
	public void devolverAlMazo()
	{
		anchoDeEspada.volveAlMazo();
		anchoDeBasto.volveAlMazo();
		sieteDeEspada.volveAlMazo();
		sieteDeOro.volveAlMazo();
		cuatroDeCopa.volveAlMazo();
		cuatroDeOro.volveAlMazo();
	}
	
	
	@Test
	public void testCreacionMesaDeDosYDeCuatroExitosa() {
		
		Assert.assertTrue(mesaDeDos.partidaConFlor());
		Assert.assertTrue(mesaDeCuatro.partidaConFlor());
	}
		
	@Test (expected = TurnoEquivocadoException.class)
	public void testSoloElDuenioDelTurnoPuedeJugar(){
	
		jugador1.recibirCarta(anchoDeEspada);
		jugador2.recibirCarta(anchoDeBasto);
		jugador2.recibirCarta(cuatroDeCopa);
		jugador1.jugarPrimerCarta(); 
		jugador2.jugarPrimerCarta();
		jugador2.jugarSegundaCarta();
	}
	
	
	@Test
	public void testRotacionDeTurnosParaDosJugadores(){
		 		
		jugador1.recibirCarta(anchoDeEspada);
		jugador1.recibirCarta(anchoDeBasto);
		jugador1.recibirCarta(sieteDeEspada);
		jugador2.recibirCarta(sieteDeOro);
		jugador2.recibirCarta(cuatroDeCopa);
		jugador2.recibirCarta(cuatroDeOro);	
		
		Jugador jugadorActual = mesaDeDos.getJugadorConTurno();
		Assert.assertTrue(jugador1 == jugadorActual);
		
		jugadorActual.jugarPrimerCarta();
		jugadorActual = mesaDeDos.getJugadorConTurno();
		Assert.assertTrue(jugador2 == jugadorActual);

		jugadorActual.jugarPrimerCarta();
		jugadorActual = mesaDeDos.getJugadorConTurno();
		Assert.assertTrue(jugador1 == jugadorActual);
		
		jugadorActual.jugarTercerCarta();
		jugadorActual = mesaDeDos.getJugadorConTurno();
		Assert.assertTrue(jugador2 == jugadorActual);	
	}
	
	
	@Test
	public void testRotacionDeTurnosParaCuatroJugadores(){
				 
		jugador3.recibirCarta(anchoDeEspada);
		jugador3.recibirCarta(anchoDeBasto);
		jugador4.recibirCarta(sieteDeEspada);
		jugador4.recibirCarta(sieteDeOro);
		jugador5.recibirCarta(cuatroDeCopa);
		jugador6.recibirCarta(cuatroDeOro);	
		
		Jugador jugadorActual = mesaDeCuatro.getJugadorConTurno();
		Assert.assertTrue(jugador3 == jugadorActual);

		jugadorActual.jugarPrimerCarta();
		jugadorActual = mesaDeCuatro.getJugadorConTurno(); 
		Assert.assertTrue(jugador4 == jugadorActual);
		
		jugadorActual.jugarSegundaCarta();
		jugadorActual = mesaDeCuatro.getJugadorConTurno();
		Assert.assertTrue(jugador5 == jugadorActual);
		
		jugadorActual.jugarPrimerCarta();
		jugadorActual = mesaDeCuatro.getJugadorConTurno();
		Assert.assertTrue(jugador6 == jugadorActual);
		
		jugadorActual.jugarPrimerCarta();
		jugadorActual = mesaDeCuatro.getJugadorConTurno();
		Assert.assertTrue(jugador3 == jugadorActual);
		
		jugadorActual.jugarSegundaCarta();
		jugadorActual = mesaDeCuatro.getJugadorConTurno();
		Assert.assertTrue(jugador4 == jugadorActual);
	}
	
	@Test
	public void testRecibirCarta(){
		
		jugador1.recibirCarta(anchoDeEspada);
		jugador2.recibirCarta(cuatroDeOro);
		jugador2.recibirCarta(cuatroDeCopa);
		
		jugador1.jugarPrimerCarta(); //juego el ancho de espada
		jugador2.jugarSegundaCarta();
		
		Assert.assertTrue(mesaDeDos.getPrimerCartaJugada(jugador1) ==  anchoDeEspada);
		Assert.assertTrue(mesaDeDos.getPrimerCartaJugada(jugador2) ==  cuatroDeCopa);
	}
	
	
	@Test
	public void testJugadorNoPuedeJugarDosVecesLaMismaCarta(){
		jugador1.recibirCarta(anchoDeEspada);
		jugador1.recibirCarta(anchoDeBasto);
		jugador1.recibirCarta(sieteDeEspada);
		jugador2.recibirCarta(sieteDeOro);
		jugador2.recibirCarta(cuatroDeCopa);
		jugador2.recibirCarta(cuatroDeOro);
		
		jugador1.jugarPrimerCarta();
		jugador2.jugarPrimerCarta();
		jugador1.jugarPrimerCarta(); //Me equivoco, pero eso no me saca el turno
		jugador1.jugarSegundaCarta();
		Assert.assertFalse(mesaDeDos.getSegundaCartaJugada(jugador1) ==  anchoDeEspada);
	}
		

}
