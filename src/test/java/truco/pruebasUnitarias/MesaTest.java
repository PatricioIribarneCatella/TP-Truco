package truco.pruebasUnitarias;

import  org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import truco.excepciones.TurnoEquivocadoException;
import truco.modelo.Carta;
import truco.modelo.Cuatro;
import truco.modelo.EnMano;
import truco.modelo.Jugable;
import truco.modelo.Jugador;
import truco.modelo.Mesa;
import truco.modelo.Moderador;
import truco.modelo.Palo;
import truco.modelo.RotacionStrategy;
import truco.modelo.SieteDeEspada;
import truco.modelo.SieteDeOro;
import truco.modelo.StrategyRotacionEnRonda;
import truco.modelo.UnoDeBasto;
import truco.modelo.UnoDeEspada;

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
	     
		mesaDeDos = new Mesa(jugadoresPartidaDeDos);
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
		List<Carta> cartas = Arrays.asList(anchoDeEspada, anchoDeBasto, sieteDeEspada, sieteDeOro, cuatroDeCopa, cuatroDeOro);
		
		jugador1.recibirCarta(anchoDeEspada);
		jugador1.recibirCarta(sieteDeEspada);
		jugador1.recibirCarta(cuatroDeOro);
		
		jugador2.recibirCarta(anchoDeBasto);
		jugador2.recibirCarta(sieteDeOro);
		jugador2.recibirCarta(cuatroDeCopa);
				
	    for (Carta carta : cartas) {
	    	carta.pasaAEstar(new EnMano());
	    }
		
		moderador = new Moderador(mesaDeDos);
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
