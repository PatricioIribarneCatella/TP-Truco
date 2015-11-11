package algoritmosyprogramacion3.tp2.pruebasunitarias;

import  org.junit.Assert;

import java.util.LinkedList;

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
	private Campo campoJugador1;
	private Campo campoJugador2;
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
		
	    anchoDeEspada = new UnoDeEspada();
	    anchoDeBasto = new UnoDeBasto();
		sieteDeEspada = new SieteDeEspada();
		sieteDeOro = new SieteDeOro();
		cuatroDeCopa = new CuatroDeCopa();
		cuatroDeOro = new CuatroDeOro();
		
		campoJugador1 = new Campo(jugador1, mesaDeDos);
		campoJugador2 = new Campo(jugador2,mesaDeDos);
		jugador1.setCampo(campoJugador1);
		jugador2.setCampo(campoJugador2);
		
		jugador1.recibirCarta(anchoDeEspada);
		jugador1.recibirCarta(anchoDeBasto);
		jugador1.recibirCarta(sieteDeEspada);
		jugador2.recibirCarta(sieteDeOro);
		jugador2.recibirCarta(cuatroDeCopa);
		jugador2.recibirCarta(cuatroDeOro);
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
		
		mesaDeDos.cambiarTurno();
		jugadorActual = mesaDeDos.getJugadorActual();
		Assert.assertTrue(jugador1 == jugadorActual);
		
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
		
		mesaDeCuatro.cambiarTurno();
		jugadorActual = mesaDeCuatro.getJugadorActual();
		Assert.assertTrue(jugador1 == jugadorActual);
	}
	
	@Test
	public void testJugarCarta(){
		
		
		jugador1.jugarPrimerCarta(); //juego el ancho de espada
		jugador2.jugarSegundaCarta();
		Assert.assertTrue(campoJugador1.getPrimerCarta() ==  anchoDeEspada);
		Assert.assertTrue(campoJugador2.getPrimerCarta() ==  cuatroDeCopa);
		
	}
	
	
	@Test (expected= TurnoEquivocadoException.class)
	public void testSoloElDuenioDelTurnoPuedeJugar(){
	
		jugador1.jugarPrimerCarta(); 
		jugador2.jugarSegundaCarta();
		jugador1.jugarSegundaCarta();
		jugador1.jugarTercerCarta();
	}
	
	@Test
	public void testJugadorNoPuedeJugarDosVecesLaMismaCarta(){
		
	
		jugador1.jugarPrimerCarta();
		jugador2.jugarPrimerCarta();
		jugador1.jugarPrimerCarta(); //Me equivoco, pero eso no me saca el turno
		jugador1.jugarSegundaCarta();
		Assert.assertTrue(campoJugador1.getPrimerCarta() ==  anchoDeEspada);
		Assert.assertFalse(campoJugador1.getSegundaCarta() ==  anchoDeEspada);
	}
	
	
	

}
