package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import  org.junit.Assert;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.excepciones.TurnoEquivocadoException;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.Cuatro;
import algoritmosyprogramacion3.tp2.modelo.Jugable;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.Mesa;
import algoritmosyprogramacion3.tp2.modelo.MesaConFlor;
import algoritmosyprogramacion3.tp2.modelo.Moderador;
import algoritmosyprogramacion3.tp2.modelo.Palo;
import algoritmosyprogramacion3.tp2.modelo.RotacionStrategy;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.SieteDeOro;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionEnRonda;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;

public class MesaTest {

	private LinkedList<Jugable> jugadoresPartidaDeDos;
	private Mesa mesaDeDos;
	private Jugable jugador1;
	private Jugable jugador2;
	private Carta anchoDeEspada;
	private Carta anchoDeBasto;
	private Carta sieteDeEspada;
	private Carta sieteDeOro;
	private Carta cuatroDeCopa;
	private Carta cuatroDeOro;
	private Moderador moderador;
	private RotacionStrategy rotacionEnRonda;
	
	
	@Before
    public void setUp()
	{
		jugadoresPartidaDeDos = new LinkedList<Jugable>();
		jugador1= new Jugador("Pepe");
	    jugador2 = new Jugador("Jorgito");

	    jugadoresPartidaDeDos.add(jugador1);
	    jugadoresPartidaDeDos.add(jugador2);
	     
		mesaDeDos = new MesaConFlor(jugadoresPartidaDeDos);
		rotacionEnRonda = new StrategyRotacionEnRonda(this.mesaDeDos.getJugadores());
		
		moderador = new Moderador(mesaDeDos);
		this.moderador.setRotacionStrategy(rotacionEnRonda);
		this.jugador1.setModerador(moderador);
		this.jugador2.setModerador(moderador);
		
	    anchoDeEspada = new UnoDeEspada();
	    anchoDeBasto = new UnoDeBasto();
		sieteDeEspada = new SieteDeEspada();
		sieteDeOro = new SieteDeOro();
		cuatroDeCopa = new Cuatro(Palo.COPA);
		cuatroDeOro = new Cuatro(Palo.ORO);
		
		jugador1.recibirCarta(anchoDeEspada);
		jugador1.recibirCarta(sieteDeEspada);
		jugador1.recibirCarta(cuatroDeOro);
		
		jugador2.recibirCarta(anchoDeBasto);
		jugador2.recibirCarta(sieteDeOro);
		jugador2.recibirCarta(cuatroDeCopa);
				
	    sieteDeOro.entregada();
		sieteDeEspada.entregada();
		anchoDeBasto.entregada();
		anchoDeEspada.entregada();
		cuatroDeCopa.entregada();
		cuatroDeOro.entregada();
		
		moderador = new Moderador(mesaDeDos);
	}
	
	@Test
	public void testCreacionMesaDeDosYDeCuatroExitosa() {
		
		Assert.assertTrue(mesaDeDos.seJuegaConFlor());
	}
		
	@Test (expected = TurnoEquivocadoException.class)
	public void testSoloElDuenioDelTurnoPuedeJugar(){
		
		jugador1.jugarPrimerCarta(); 
		jugador2.jugarPrimerCarta();
		jugador2.jugarSegundaCarta();
	}
	
	@Test
	public void testRecibirCarta(){
		
		jugador1.jugarPrimerCarta(); //juego el ancho de espada
		jugador2.jugarSegundaCarta(); //juego el siete de oro
		
		Assert.assertTrue(mesaDeDos.getPrimerCartaJugada(jugador1) ==  anchoDeEspada);
		Assert.assertTrue(mesaDeDos.getPrimerCartaJugada(jugador2) ==  sieteDeOro);
	}
}
