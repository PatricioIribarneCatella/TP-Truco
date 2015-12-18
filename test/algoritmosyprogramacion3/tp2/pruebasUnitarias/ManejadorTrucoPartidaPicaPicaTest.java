package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Caballo;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.Cinco;
import algoritmosyprogramacion3.tp2.modelo.Cuatro;
import algoritmosyprogramacion3.tp2.modelo.Dos;
import algoritmosyprogramacion3.tp2.modelo.EnMano;
import algoritmosyprogramacion3.tp2.modelo.Equipo;
import algoritmosyprogramacion3.tp2.modelo.Jugable;
import algoritmosyprogramacion3.tp2.modelo.Jugada;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.ManejadorTruco;
import algoritmosyprogramacion3.tp2.modelo.Mesa;
import algoritmosyprogramacion3.tp2.modelo.Moderador;
import algoritmosyprogramacion3.tp2.modelo.Palo;
import algoritmosyprogramacion3.tp2.modelo.Rey;
import algoritmosyprogramacion3.tp2.modelo.Seis;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionEnRonda;
import algoritmosyprogramacion3.tp2.modelo.Tres;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class ManejadorTrucoPartidaPicaPicaTest {

	private Equipo equipo1;
	private Equipo equipo2;
	private Mesa mesa;
	private Moderador moderador;
	private Jugable jugador1;
	private Jugable jugador2;
	private Jugable jugador3;
	private Jugable jugador4;
	private Jugable jugador5;
	private Jugable jugador6;
	private List<Jugable> jugadores;
	private Carta unoDeEspada;
	private Carta unoDeBasto;
	private Carta sieteDeEspada;
	private Carta tresDeCopa;
	private Carta tresDeEspada;
	private Carta dosDeEspada;
	private Carta dosDeBasto;
	private Carta dosDeOro;
	private Carta unoDeOro;
	private Carta unoDeCopa;
	private Carta reyDeBasto;
	private Carta reyDeOro;
	private Carta caballoDeEspada;
	private Carta sieteDeBasto;
	private Carta seisDeCopa;
	private Carta cincoDeEspada;
	private Carta cuatroDeOro;
	private Carta cuatroDeCopa;
	private ManejadorTruco manejador = new ManejadorTruco();
	
	@Before
	public void setUp() {
		
		this.jugador1 = new Jugador("1");
		this.jugador2 = new Jugador("2");
		this.jugador3 = new Jugador("3");
		this.jugador4 = new Jugador("4");
		this.jugador5 = new Jugador("5");
		this.jugador6 = new Jugador("6");
		
		this.jugadores = new LinkedList<Jugable>();
		
		this.jugadores.add(jugador1);
		this.jugadores.add(jugador2);
		this.jugadores.add(jugador3);
		this.jugadores.add(jugador4);
		this.jugadores.add(jugador5);
		this.jugadores.add(jugador6);
		
		unoDeEspada = new UnoDeEspada();
		unoDeBasto = new UnoDeBasto();
		sieteDeEspada = new SieteDeEspada();
		tresDeCopa = new Tres(Palo.COPA);
		tresDeEspada = new Tres(Palo.ESPADA);
		dosDeEspada = new Dos(Palo.ESPADA);
		dosDeBasto = new Dos(Palo.BASTO);
	    dosDeOro = new Dos(Palo.ORO);
		unoDeOro = new UnoDeOro();
		unoDeCopa = new UnoDeCopa();
		reyDeBasto = new Rey(Palo.BASTO);
		reyDeOro = new Rey(Palo.ORO);
		caballoDeEspada = new Caballo(Palo.ESPADA);
		sieteDeBasto = new SieteDeBasto();
		seisDeCopa = new Seis(Palo.COPA);
		cincoDeEspada = new Cinco(Palo.ESPADA);
		cuatroDeOro = new Cuatro(Palo.ORO);
		cuatroDeCopa = new Cuatro(Palo.COPA);
		
		List<Carta> cartas = Arrays.asList(unoDeEspada, unoDeBasto, sieteDeEspada, tresDeCopa, tresDeEspada, dosDeEspada, dosDeBasto, dosDeOro, unoDeOro, unoDeCopa, reyDeBasto, reyDeOro, caballoDeEspada, sieteDeBasto, seisDeCopa, cincoDeEspada, cuatroDeOro, cuatroDeCopa);
		
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
		
		jugador5.recibirCarta(tresDeEspada);
		jugador5.recibirCarta(reyDeBasto);
		jugador5.recibirCarta(cuatroDeOro);
		
		jugador6.recibirCarta(dosDeEspada);
		jugador6.recibirCarta(reyDeOro);
		jugador6.recibirCarta(cuatroDeCopa);
		
		moderador = new Moderador(mesa);
		moderador.setRotacionStrategy(new StrategyRotacionEnRonda(jugadores));
		
		for (Carta carta : cartas) {
			carta.pasaAEstar(new EnMano());
		}
		
		this.jugador1.setModerador(this.moderador);
		this.jugador2.setModerador(this.moderador);
		this.jugador3.setModerador(this.moderador);
		this.jugador4.setModerador(this.moderador);
		this.jugador5.setModerador(this.moderador);
		this.jugador6.setModerador(this.moderador);
	    equipo1 = new Equipo();
	    equipo2 = new Equipo();
		equipo1.agregarIntegrante(this.jugador1);
		equipo1.agregarIntegrante(this.jugador3);
		equipo1.agregarIntegrante(this.jugador5);
		equipo2.agregarIntegrante(this.jugador2);
		equipo2.agregarIntegrante(this.jugador4);
		equipo2.agregarIntegrante(this.jugador6);
		jugador1.setEquipo(equipo1);
		jugador2.setEquipo(equipo2);
		jugador3.setEquipo(equipo1);
		jugador4.setEquipo(equipo2);
		jugador5.setEquipo(equipo1);
		jugador6.setEquipo(equipo2);
		
		manejador.setJugadoresEnfrentados(jugadores);
		
	}
	
	@Test
	public void testGanaEquipoUno(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarPrimerCarta();
		this.jugador3.jugarTercerCarta();
		this.jugador4.jugarTercerCarta();
		this.jugador5.jugarTercerCarta();
		this.jugador6.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		jugador3.jugarPrimerCarta();
		jugador4.jugarPrimerCarta();
		jugador5.jugarSegundaCarta();
		jugador6.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador3.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador5.getEquipo());	
	}
	
	@Test
	public void testGanaElQueHizoPrimeraSiSeEmpataEnLaSegunda(){
		
		this.jugador1.jugarTercerCarta();
		this.jugador2.jugarPrimerCarta();
		this.jugador3.jugarTercerCarta();
		this.jugador4.jugarTercerCarta();
		this.jugador5.jugarTercerCarta();
		this.jugador6.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		jugador3.jugarSegundaCarta();
		jugador4.jugarSegundaCarta();
		jugador5.jugarSegundaCarta();
		jugador6.jugarSegundaCarta();

		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador2.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador4.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador6.getEquipo());
	}
	
	@Test
	public void testGanaElQueHaceDosDeTresEquipoUno(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarTercerCarta();
		this.jugador3.jugarTercerCarta();
		this.jugador4.jugarTercerCarta();
		this.jugador5.jugarTercerCarta();
		this.jugador6.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		this.jugador1.jugarTercerCarta();
		this.jugador2.jugarPrimerCarta();
		this.jugador3.jugarPrimerCarta();
		this.jugador4.jugarPrimerCarta();
		this.jugador5.jugarSegundaCarta();
		this.jugador6.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		jugador3.jugarSegundaCarta();
		jugador4.jugarSegundaCarta();
		jugador5.jugarPrimerCarta();
		jugador6.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador3.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador5.getEquipo());	
	}
	
	@Test
	public void testGanaElQueHaceDosDeTresEquipoDos(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarTercerCarta();
		this.jugador3.jugarTercerCarta();
		this.jugador4.jugarTercerCarta();
		this.jugador5.jugarTercerCarta();
		this.jugador6.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		this.jugador1.jugarSegundaCarta();
		this.jugador2.jugarPrimerCarta();
		this.jugador3.jugarPrimerCarta();
		this.jugador4.jugarSegundaCarta();
		this.jugador5.jugarPrimerCarta();
		this.jugador6.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarSegundaCarta();
		jugador3.jugarSegundaCarta();
		jugador4.jugarPrimerCarta();
		jugador5.jugarSegundaCarta();
		jugador6.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador2.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador4.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador6.getEquipo());	
	}
	
	
	@Test
	public void testEmpatePrimeraGanaSegundaEquipoUno(){
	
		this.jugador1.jugarSegundaCarta();
		this.jugador2.jugarSegundaCarta();
		this.jugador3.jugarSegundaCarta();
		this.jugador4.jugarSegundaCarta();
		this.jugador5.jugarSegundaCarta();
		this.jugador6.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarPrimerCarta();
		jugador2.jugarPrimerCarta();
		jugador3.jugarPrimerCarta();
		jugador4.jugarPrimerCarta();
		jugador5.jugarPrimerCarta();
		jugador6.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador3.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador5.getEquipo());	
	}
	
	
	@Test
	public void testEmpatePrimeraGanaSegundaEquipoDos(){
	
		this.jugador1.jugarSegundaCarta();
		this.jugador2.jugarSegundaCarta();
		this.jugador3.jugarSegundaCarta();
		this.jugador4.jugarSegundaCarta();
		this.jugador5.jugarSegundaCarta();
		this.jugador6.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarPrimerCarta();
		jugador3.jugarTercerCarta();
		jugador4.jugarPrimerCarta();
		jugador5.jugarTercerCarta();
		jugador6.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador2.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador4.getEquipo());
		Assert.assertTrue(this.manejador.getGanador() == jugador6.getEquipo());
	}
	
	
	@Test
	public void testEmpatanTerceraDefinePrimeraMano(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarTercerCarta();
		this.jugador3.jugarTercerCarta();
		this.jugador4.jugarTercerCarta();
		this.jugador5.jugarTercerCarta();
		this.jugador6.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarPrimerCarta();
		jugador3.jugarPrimerCarta();
		jugador4.jugarPrimerCarta();
		jugador5.jugarPrimerCarta();
		jugador6.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		jugador3.jugarSegundaCarta();
		jugador4.jugarSegundaCarta();
		jugador5.jugarSegundaCarta();
		jugador6.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador3.getEquipo());	
		Assert.assertTrue(this.manejador.getGanador() == jugador5.getEquipo());	
	}
	
	/*Arranco tests pero con un criterio de rotacion pica-pica*/
	
	/*@Test
	public void testRondaPicaPica(){
		
		RotacionStrategy rotacionPicaPica = new StrategyRotacionPicaPica(this.jugadores);
		moderador.setRotacionStrategy(rotacionPicaPica);
		manejador.setJugadoresEnfrentados(rotacionPicaPica.getJugadoresEnfrentados());
		
		moderador.rondaFinalizada();
		manejador.setJugadoresEnfrentados(rotacionPicaPica.getJugadoresEnfrentados());
		
		jugador2.jugarPrimerCarta();
		jugador5.jugarPrimerCarta();
		manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador2.jugarSegundaCarta();
		jugador5.jugarSegundaCarta(); //gana el jugador del equipo 2
		manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
		Assert.assertTrue(manejador.getGanador() == equipo1);
		
	} el tema con este test es que, al pedirle los jugadores a enfrentar del rotacion Strategy se me relacionan con aquellos del moderador
	 por lo tanto me tira un null pointer exception */
}
