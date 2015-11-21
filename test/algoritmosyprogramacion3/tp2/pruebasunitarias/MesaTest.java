package algoritmosyprogramacion3.tp2.pruebasunitarias;

import  org.junit.Assert;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeCopa;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeOro;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.Mesa;
import algoritmosyprogramacion3.tp2.modelo.Moderador;
import algoritmosyprogramacion3.tp2.modelo.RotacionStrategy;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.SieteDeOro;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionEnRonda;
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
	private Moderador moderador;
	private RotacionStrategy rotacionEnRonda;
	
	
	@Before
    public void  setUp()
	{
		jugadoresPartidaDeDos = new LinkedList<Jugador>();
		jugadoresPartidaDeCuatro = new LinkedList<Jugador>();
		jugador1= new Jugador("Pepe");
	    jugador2 = new Jugador("Jorgito");

	    jugadoresPartidaDeDos.add(jugador1);
	    jugadoresPartidaDeDos.add(jugador2);
	     
		mesaDeDos = new Mesa(jugadoresPartidaDeDos,true);
		rotacionEnRonda = new StrategyRotacionEnRonda(this.mesaDeDos.getJugadores());
		
		moderador = new Moderador(mesaDeDos);
		this.moderador.setRotacionStrategy(rotacionEnRonda);
		this.jugador1.setModerador(moderador);
		this.jugador2.setModerador(moderador);
		
	    anchoDeEspada = new UnoDeEspada();
	    anchoDeBasto = new UnoDeBasto();
		sieteDeEspada = new SieteDeEspada();
		sieteDeOro = new SieteDeOro();
		cuatroDeCopa = new CuatroDeCopa();
		cuatroDeOro = new CuatroDeOro();
				
		moderador = new Moderador(mesaDeDos);
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
		
		Assert.assertTrue(mesaDeDos.seJuegaConFlor());
		Assert.assertTrue(mesaDeCuatro.seJuegaConFlor());
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
	public void testRecibirCarta(){
		
		jugador1.recibirCarta(anchoDeEspada);
		jugador2.recibirCarta(cuatroDeOro);
		jugador2.recibirCarta(cuatroDeCopa);
		
		jugador1.jugarPrimerCarta(); //juego el ancho de espada
		jugador2.jugarSegundaCarta();
		
		Assert.assertTrue(mesaDeDos.getPrimerCartaJugada(jugador1) ==  anchoDeEspada);
		Assert.assertTrue(mesaDeDos.getPrimerCartaJugada(jugador2) ==  cuatroDeCopa);
	}
	
	


}
