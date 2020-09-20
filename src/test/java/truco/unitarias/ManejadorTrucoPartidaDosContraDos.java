package truco.unitarias;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import truco.modelo.Carta;
import truco.modelo.Dos;
import truco.modelo.EnMano;
import truco.modelo.Tres;
import truco.modelo.Cinco;
import truco.modelo.Seis;
import truco.modelo.Caballo;
import truco.modelo.Equipo;
import truco.modelo.Jugable;
import truco.modelo.Jugada;
import truco.modelo.Jugador;
import truco.modelo.ManejadorTruco;
import truco.modelo.Mesa;
import truco.modelo.Moderador;
import truco.modelo.Palo;
import truco.modelo.SieteDeBasto;
import truco.modelo.SieteDeEspada;
import truco.modelo.StrategyRotacionEnRonda;
import truco.modelo.UnoDeBasto;
import truco.modelo.UnoDeCopa;
import truco.modelo.UnoDeEspada;
import truco.modelo.UnoDeOro;

public class ManejadorTrucoPartidaDosContraDos {

	private Equipo equipo1;
	private Equipo equipo2;
	private Mesa mesa;
	private Moderador moderador;
	private Jugable jugador1;
	private Jugable jugador2;
	private Jugable jugador3;
	private Jugable jugador4;
	private List<Jugable> jugadores;
	private Carta unoDeEspada;
	private Carta unoDeBasto;
	private Carta sieteDeEspada;
	private Carta tresDeCopa;
	private Carta dosDeBasto;
	private Carta dosDeOro;
	private Carta unoDeOro;
	private Carta unoDeCopa;
	private Carta caballoDeEspada;
	private Carta sieteDeBasto;
	private Carta seisDeCopa;
	private Carta cincoDeEspada;
	private ManejadorTruco manejador = new ManejadorTruco();
	
	@Before
	public void setUp() {
		
		this.jugador1 = new Jugador("1");
		this.jugador2 = new Jugador("2");
		this.jugador3 = new Jugador("3");
		this.jugador4 = new Jugador("4");	
		
		this.jugadores = new LinkedList<Jugable>();
		this.jugadores.add(jugador1);
		this.jugadores.add(jugador2);
		this.jugadores.add(jugador3);
		this.jugadores.add(jugador4);

		
		unoDeEspada = new UnoDeEspada();
		unoDeBasto = new UnoDeBasto();
		sieteDeEspada = new SieteDeEspada();
		tresDeCopa = new Tres(Palo.COPA);
		dosDeBasto = new Dos(Palo.BASTO);
	    dosDeOro = new Dos(Palo.ORO);
		unoDeOro = new UnoDeOro();
		unoDeCopa = new UnoDeCopa();
		caballoDeEspada = new Caballo(Palo.ESPADA);
		sieteDeBasto = new SieteDeBasto();
		seisDeCopa = new Seis(Palo.COPA);
		cincoDeEspada = new Cinco(Palo.ESPADA);
		
		List<Carta> cartas = Arrays.asList(unoDeEspada, unoDeBasto, sieteDeEspada, tresDeCopa, dosDeBasto, dosDeOro, unoDeOro, unoDeCopa, caballoDeEspada, sieteDeBasto, seisDeCopa, cincoDeEspada);
		
		mesa = new Mesa(jugadores);
		
		jugador1.recibirCarta(unoDeEspada);
		jugador1.recibirCarta(dosDeBasto);
		jugador1.recibirCarta(caballoDeEspada);
		
		jugador2.recibirCarta(unoDeBasto);
		jugador2.recibirCarta(dosDeOro);
		jugador2.recibirCarta(sieteDeBasto);
		
		jugador3.recibirCarta(sieteDeEspada);
		jugador3.recibirCarta(unoDeOro);
		jugador3.recibirCarta(seisDeCopa);
		
		jugador4.recibirCarta(tresDeCopa);
		jugador4.recibirCarta(unoDeCopa);
		jugador4.recibirCarta(cincoDeEspada);

		moderador = new Moderador(mesa);
		moderador.setRotacionStrategy(new StrategyRotacionEnRonda(jugadores));
		
		for (Carta carta : cartas) {
			carta.pasaAEstar(new EnMano());
		}
		
		this.jugador1.setModerador(this.moderador);
		this.jugador2.setModerador(this.moderador);
		this.jugador3.setModerador(this.moderador);
		this.jugador4.setModerador(this.moderador);
	    equipo1 = new Equipo();
	    equipo2 = new Equipo();
		equipo1.agregarIntegrante(this.jugador1);
		equipo1.agregarIntegrante(this.jugador3);
		equipo2.agregarIntegrante(this.jugador2);
		equipo2.agregarIntegrante(this.jugador4);
		jugador1.setEquipo(equipo1);
		jugador2.setEquipo(equipo2);
		jugador3.setEquipo(equipo1);
		jugador4.setEquipo(equipo2);
		
		manejador.setJugadoresEnfrentados(jugadores);
	}
	
	@Test
	public void testGanaEquipoUno(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarPrimerCarta();
		this.jugador3.jugarTercerCarta();
		this.jugador4.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		jugador3.jugarPrimerCarta();
		jugador4.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
	}
	
	@Test
	public void testGanaElQueHizoPrimeraSiSeEmpataEnLaSegunda(){
		
		this.jugador1.jugarTercerCarta();
		this.jugador2.jugarPrimerCarta();
		this.jugador3.jugarTercerCarta();
		this.jugador4.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		jugador3.jugarSegundaCarta();
		jugador4.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador2.getEquipo());		
	}
	
	@Test
	public void testGanaElQueHaceDosDeTresEquipoUno(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarTercerCarta();
		this.jugador3.jugarTercerCarta();
		this.jugador4.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		this.jugador1.jugarTercerCarta();
		this.jugador2.jugarPrimerCarta();
		this.jugador3.jugarSegundaCarta();
		this.jugador4.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		this.jugador3.jugarPrimerCarta();
		this.jugador4.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
	}
	
	@Test
	public void testGanaElQueHaceDosDeTresEquipoDos(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarTercerCarta();
		this.jugador3.jugarTercerCarta();
		this.jugador4.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		this.jugador1.jugarSegundaCarta();
		this.jugador2.jugarPrimerCarta();
		this.jugador3.jugarPrimerCarta();
		this.jugador4.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarSegundaCarta();
		this.jugador3.jugarSegundaCarta();
		this.jugador4.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador2.getEquipo());	
	}
	
	@Test
	public void testEmpatePrimeraGanaSegundaEquipoUno(){
	
		this.jugador1.jugarSegundaCarta();
		this.jugador2.jugarSegundaCarta();
		this.jugador3.jugarSegundaCarta();
		this.jugador4.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarPrimerCarta();
		jugador2.jugarPrimerCarta();
		jugador3.jugarPrimerCarta();
		jugador4.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador3.getEquipo());	
	}
	
	@Test
	public void testEmpatePrimeraGanaSegundaEquipoDos(){
	
		this.jugador1.jugarSegundaCarta();
		this.jugador2.jugarSegundaCarta();
		this.jugador3.jugarSegundaCarta();
		this.jugador4.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarPrimerCarta();
		jugador3.jugarTercerCarta();
		jugador4.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador2.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador4.getEquipo());	
	}
	
	@Test
	public void testEmpatanTerceraDefinePrimeraMano(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarTercerCarta();
		this.jugador3.jugarTercerCarta();
		this.jugador4.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarPrimerCarta();
		jugador3.jugarPrimerCarta();
		jugador4.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		jugador3.jugarSegundaCarta();
		jugador4.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador3.getEquipo());	
	}
}
