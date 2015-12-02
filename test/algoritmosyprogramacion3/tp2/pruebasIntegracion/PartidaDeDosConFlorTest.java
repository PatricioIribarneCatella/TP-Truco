package algoritmosyprogramacion3.tp2.pruebasIntegracion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;
import algoritmosyprogramacion3.tp2.modelo.CincoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.CincoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeBasto;
import algoritmosyprogramacion3.tp2.modelo.DosDeBasto;
import algoritmosyprogramacion3.tp2.modelo.DosDeOro;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.modelo.SeisDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SeisDeCopa;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeCopa;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.TresDeBasto;
import algoritmosyprogramacion3.tp2.modelo.TresDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class PartidaDeDosConFlorTest {

	private JuegoTruco juego;
	
	@Before
	public void setUp() {
		
		juego = new JuegoTruco();
		juego.nuevaMesaDeDosConFlor("mesa1", Arrays.asList("Juan", "Pedro"));
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new DosDeOro(), new SieteDeBasto(), new UnoDeEspada(), new DosDeBasto(), new SieteDeCopa()));
	}

	@Test
	public void testCantarFlorDeberiaSerPosible() {
		
		Assert.assertTrue(juego.cantarFlorPorJugador("Juan"));
	}
	
	@Test (expected = TurnoParaTomarDecisionEquivocadoException.class)
	public void testMismoJugadorCantaTrucoYAceptaNoDeberiaSerPosible() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		juego.aceptarTrucoPorJugador("Juan");
	}
	
	@Test (expected = TurnoParaTomarDecisionEquivocadoException.class)
	public void testMismoJugadorCantaEnvidoYAceptaNoDeberiaSerPosible() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		juego.aceptarVarianteEnvidoPorJugador("Juan");
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testNoDeberiaSerPosibleCantarReTrucoCuandoEmpiezaLaPartida() {
		
		juego.cantarReTrucoPorJugador("Juan");
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testNoDeberiaSerPosibleCantarValeCuatroCuandoEmpiezaLaPartida() {
		
		juego.cantarValeCuatroPorJugador("Juan");
	}
	
	@Test (expected = TurnoParaTomarDecisionEquivocadoException.class)
	public void testMismoJugadorCantaTrucoYReTruco() {
	
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		juego.cantarReTrucoPorJugador("Juan");
	}
	
	@Test
	public void testSeCantaTrucoYNoSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("1"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
	}
	
	@Test
	public void testSeCantaEnvidoNoSeLoQuiereSeCantaTrucoNoSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
	}
	
	@Test
	public void testSeCantaTrucoYSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("2"));
	}
	
	@Test
	public void testSeCantaTrucoSeCantaReTrucoSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarReTrucoPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("3"));
	}
	
	@Test
	public void testSeCantaTrucoSeCantaReTrucoSeCantaValeCuatroSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("4"));
	}
	
	@Test
	public void testSeCantaEnvidoSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Juan").equals("28"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pedro").equals("7"));
	}
	
	@Test
	public void testSeCantaEnvidoDosVecesSeguidasSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Juan").equals("28"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pedro").equals("7"));
	}
	
	@Test
	public void testSeCantaEnvidoTresVecesSeguidasSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("6"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Juan").equals("28"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pedro").equals("7"));
	}
	
	@Test
	public void testSeCantaRealEnvidoSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarRealEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Juan").equals("28"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pedro").equals("7"));
	}
	
	@Test
	public void testSeCantaEnvidoTresVecesSeguidasYRealEnvidoSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarRealEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("9"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Juan").equals("28"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pedro").equals("7"));
	}
	
	@Test
	public void testSeCantaFaltaEnvidoSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarFaltaEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("30"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Juan").equals("28"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pedro").equals("7"));
	}
	
	@Test
	public void testSeCantaTrucoSeCantaFlorYNoSeAcepta() {
		
		// Juan
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new DosDeBasto(), new TresDeBasto(), new CuatroDeBasto(), new CincoDeBasto(), new SeisDeBasto()));
		Assert.assertTrue(juego.cantarFlorPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarFlorPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("1"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("3"));
	}
	
	@Test
	public void testSeCantaTrucoSeCantaFlorYSeAcepta() {
		
		// Juan
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new DosDeBasto(), new TresDeBasto(), new CuatroDeBasto(), new CincoDeBasto(), new SeisDeBasto()));
		Assert.assertTrue(juego.cantarFlorPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarFlorPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("7"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
	}
	
	@Test
	public void testPartidaCompleta() {
		
		// Juan
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("1"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new DosDeOro(), new SieteDeBasto(), new UnoDeEspada(), new DosDeBasto(), new SieteDeCopa()));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("1"));
	
		// Juan
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa(), new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada()));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro")); // Empatan pero Pedro hizo primera
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("5"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa(), new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada()));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarTrucoPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarReTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("9"));
		
		// Juan
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new DosDeOro(), new SieteDeBasto(), new UnoDeEspada(), new DosDeBasto(), new SieteDeCopa()));
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("9"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("9"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa(), new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada()));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarTrucoPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Juan"));
		
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarReTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("13"));
		
		// Juan
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa(), new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada()));
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("5"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("13"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("6"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("13"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa(), new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada()));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarTrucoPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Juan"));
		
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarReTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("6"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("17"));
		
		// Juan
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa(), new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada()));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro")); // Empatan pero Juan hizo primera
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("10"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("17"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa(), new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada()));
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("10"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("18"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("10"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("19"));
		
		// Juan
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa(), new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada()));
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("11"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("19"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro")); // Empatan pero Pedro hizo primera
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("11"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("23"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa(), new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada()));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan")); // Empatan pero Juan hizo primera
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("15"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("23"));
		
		// Juan
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa(), new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada()));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro")); // Empatan pero Pedro hizo primera
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("15"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("27"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList( new TresDeCopa(), new UnoDeCopa(), new CincoDeEspada(), new SieteDeEspada(), new UnoDeOro(), new SeisDeCopa()));
		
		Assert.assertTrue(juego.cantarFaltaEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("15"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("30"));
	}
}
