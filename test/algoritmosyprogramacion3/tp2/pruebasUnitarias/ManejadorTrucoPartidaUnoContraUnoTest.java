package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Carta;
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
import algoritmosyprogramacion3.tp2.modelo.ReTruco;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeCopa;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionEnRonda;
import algoritmosyprogramacion3.tp2.modelo.Truco;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.ValeCuatro;

public class ManejadorTrucoPartidaUnoContraUnoTest {

	private Mesa mesa;
	private Moderador moderador;
	private Jugable jugador1;
	private Jugable jugador2;
	private List<Jugable> jugadores;
	private Carta unoDeEspada;
	private Carta unoDeBasto;
	private Carta dosDeBasto;
	private Carta dosDeOro;
	private Carta sieteDeBasto;
	private Carta sieteDeCopa;
	private Equipo equipo1;
	private Equipo equipo2;
	private ManejadorTruco manejador = new ManejadorTruco();
	
	@Before
	public void setUp() {
		
		this.jugador1 = new Jugador("1");
		this.jugador2 = new Jugador("2");

		
		this.jugadores = new LinkedList<Jugable>();
		this.jugadores.add(jugador1);
		this.jugadores.add(jugador2);

		
		unoDeEspada = new UnoDeEspada();
		unoDeBasto = new UnoDeBasto();
		dosDeBasto = new Dos(Palo.BASTO);
	    dosDeOro = new Dos(Palo.ORO);
		sieteDeCopa = new SieteDeCopa();
		sieteDeBasto = new SieteDeBasto();
		
		List<Carta> cartas = Arrays.asList(unoDeEspada, unoDeBasto, dosDeBasto, dosDeOro, sieteDeCopa, sieteDeBasto);
		
		mesa = new Mesa(jugadores);
		
		jugador1.recibirCarta(unoDeEspada);
		jugador1.recibirCarta(dosDeBasto);
		jugador1.recibirCarta(sieteDeCopa);
		
		jugador2.recibirCarta(unoDeBasto);
		jugador2.recibirCarta(dosDeOro);
		jugador2.recibirCarta(sieteDeBasto);
		
		
		moderador = new Moderador(mesa);
		moderador.setRotacionStrategy(new StrategyRotacionEnRonda(jugadores));
		
		for (Carta carta : cartas) {
			carta.pasaAEstar(new EnMano());
		}
		
		this.jugador1.setModerador(this.moderador);
		this.jugador2.setModerador(this.moderador);
	    equipo1 = new Equipo();
	    equipo2 = new Equipo();
		equipo1.agregarIntegrante(this.jugador1);
		equipo2.agregarIntegrante(this.jugador2);
		jugador1.setEquipo(equipo1);
		jugador2.setEquipo(equipo2);
		this.manejador.setJugadoresEnfrentados(this.jugadores);
	}
	
	@Test
	public void puntajeSinHaberCantadoDevuelveLoEsperado(){
		
		Assert.assertTrue(this.manejador.getPuntajePorGanar() == 1);
	}
	
	@Test
	public void puntajeTrucoDevuelveLoEsperado(){
		
		this.manejador.setNivelApuesta(new Truco());
		Assert.assertTrue(this.manejador.getPuntajePorGanar() == 2);
		Assert.assertTrue(this.manejador.getPuntajePorRechazar() ==  1);
	}
	
	@Test
	public void puntajeReTrucoDevuelveEsperado(){
	
		this.manejador.setNivelApuesta(new ReTruco());
		Assert.assertTrue(this.manejador.getPuntajePorGanar() == 3);
		Assert.assertTrue(this.manejador.getPuntajePorRechazar() ==  2);
	}
	
	@Test
	public void puntajeValeCuatroDevuelveLoEsperado(){
	
		this.manejador.setNivelApuesta(new ValeCuatro());
		Assert.assertTrue(this.manejador.getPuntajePorGanar() == 4);
		Assert.assertTrue(this.manejador.getPuntajePorRechazar() ==  3);
	}
	
	@Test
	public void testGanaJugadorUnoMesaDeDos(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
	}
	
	@Test
	public void testGanaElQueHizoPrimeraSiSeEmpataEnLaSegunda(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
	}
	
	@Test
	public void testGanaElQueHaceDosDeTresEquipoUno(){
		
		this.jugador1.jugarSegundaCarta();
		this.jugador2.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarPrimerCarta();
		jugador2.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
	}
	
	@Test
	public void testGanaElQueHaceDosDeTresEquipoDos(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador2.getEquipo());	
	}
	
	
	@Test
	public void testEmpatePrimeraGanaSegundaJugadorUno(){
	
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarPrimerCarta();
		jugador2.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
	}
	
	
	@Test
	public void testEmpatePrimeraGanaSegundaJugadorDos(){
	
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador2.getEquipo());	
	}
	
	@Test
	public void testEmpatanDosPrimerasDefineTerceraJugadorUno(){
		
		this.jugador1.jugarSegundaCarta();
		this.jugador2.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarPrimerCarta();
		jugador2.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
	}
	
	
	@Test
	public void testEmpatanTerceraDefinePrimeraMano(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarTercerCarta();
		jugador2.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertFalse(this.manejador.alguienGanoDosDeTres());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarSegundaCarta();
		this.manejador.resolverJugada(new Jugada());
		Assert.assertTrue(this.manejador.alguienGanoDosDeTres());
				
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
	}
	
	
	@Test
	public void testReseteaAtributosAlCambiarLaRonda(){
		
		
		manejador.setNivelApuesta(new Truco());
		Assert.assertTrue(this.manejador.getPuntajePorGanar() == 2);
		Assert.assertTrue(this.manejador.getPuntajePorRechazar() ==  1);
			
		manejador.setNivelApuesta(new ReTruco());
		Assert.assertTrue(this.manejador.getPuntajePorGanar() == 3);
		Assert.assertTrue(this.manejador.getPuntajePorRechazar() ==  2);
	 	
		manejador.setNivelApuesta(new ValeCuatro());
		Assert.assertTrue(this.manejador.getPuntajePorGanar() == 4);
		Assert.assertTrue(this.manejador.getPuntajePorRechazar() ==  3);
		
		manejador.nuevaRonda();
		Assert.assertTrue(this.manejador.getPuntajePorGanar() == 1);
			
	}
	
	@Test
	public void testReseteaGanadorAlCambiarLaRonda(){
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarPrimerCarta();
		this.manejador.resolverJugada(new Jugada());
		
		jugador1.jugarSegundaCarta();
		jugador2.jugarTercerCarta();
		this.manejador.resolverJugada(new Jugada());

		if(manejador.alguienGanoDosDeTres())
		Assert.assertTrue(this.manejador.getGanador() == jugador1.getEquipo());	
		
		manejador.nuevaRonda(); // tambien puede ser truco no querido
		Assert.assertTrue(this.manejador.getPuntajePorGanar() == 1);
		Assert.assertTrue(this.manejador.getGanador() == null);
	}
}
