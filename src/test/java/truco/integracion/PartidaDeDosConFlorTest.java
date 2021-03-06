package truco.integracion;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import truco.excepciones.AccionInvalidaException;
import truco.excepciones.TurnoParaTomarDecisionEquivocadoException;
import truco.excepciones.JugadorSinFlorException;
import truco.modelo.Carta;
import truco.modelo.Cinco;
import truco.modelo.Cuatro;
import truco.modelo.Dos;
import truco.modelo.JuegoTruco;
import truco.modelo.Palo;
import truco.modelo.Seis;
import truco.modelo.SieteDeBasto;
import truco.modelo.SieteDeCopa;
import truco.modelo.SieteDeEspada;
import truco.modelo.Tres;
import truco.modelo.UnoDeBasto;
import truco.modelo.UnoDeCopa;
import truco.modelo.UnoDeEspada;
import truco.modelo.UnoDeOro;

public class PartidaDeDosConFlorTest {

	private JuegoTruco juego;
	
	private void repartirCartas(List<Carta> cartas) {
		juego.repartirCartas(cartas);
	}
	
	@Before
	public void setUp() {
		
		juego = new JuegoTruco();
		juego.nuevaMesaDeDosConFlor("mesa1", Arrays.asList("Juan"), Arrays.asList("Pedro"));
	}

	@Test
	public void testCantarFlorDeberiaSerPosible() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.BASTO), new Tres(Palo.BASTO), new Cuatro(Palo.BASTO), new Cinco(Palo.BASTO), new Seis(Palo.BASTO)));
		Assert.assertTrue(juego.cantarFlorPorJugador("Juan"));
	}
	
	@Test (expected = JugadorSinFlorException.class)
	public void testCantarFlorSiNoSeTieneDeberiaLanzarExcepcion() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		juego.cantarFlorPorJugador("Juan");
	}
	
	@Test (expected = TurnoParaTomarDecisionEquivocadoException.class)
	public void testMismoJugadorCantaTrucoYAceptaNoDeberiaSerPosible() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		juego.aceptarTrucoPorJugador("Juan");
	}
	
	@Test (expected = TurnoParaTomarDecisionEquivocadoException.class)
	public void testMismoJugadorCantaEnvidoYAceptaNoDeberiaSerPosible() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		juego.aceptarVarianteEnvidoPorJugador("Juan");
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testNoDeberiaSerPosibleCantarReTrucoCuandoEmpiezaLaPartida() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		juego.cantarReTrucoPorJugador("Juan");
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testNoDeberiaSerPosibleCantarValeCuatroCuandoEmpiezaLaPartida() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		juego.cantarValeCuatroPorJugador("Juan");
	}
	
	@Test (expected = TurnoParaTomarDecisionEquivocadoException.class)
	public void testMismoJugadorCantaTrucoYReTruco() {
	
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		juego.cantarReTrucoPorJugador("Juan");
	}
	
	@Test
	public void testSeCantaTrucoYNoSeLoQuiere() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("1"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
	}
	
	@Test
	public void testSeCantaEnvidoNoSeLoQuiereSeCantaTrucoNoSeLoQuiere() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
	}
	
	@Test
	public void testSeCantaTrucoYSeLoQuiere() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
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
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
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
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
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
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Juan").equals("28"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pedro").equals("7"));
	}
	
	@Test
	public void testSeCantaEnvidoDosVecesSeguidasSeLoAcepta() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
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
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
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
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
		Assert.assertTrue(juego.cantarRealEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Juan").equals("28"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pedro").equals("7"));
	}
	
	@Test
	public void testSeCantaEnvidoTresVecesSeguidasYRealEnvidoSeLoAcepta() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
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
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
		Assert.assertTrue(juego.cantarFaltaEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("30"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Juan").equals("28"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pedro").equals("7"));
	}
	
	@Test
	public void testSeCantaTrucoSeCantaFlorYNoSeAcepta() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
		// Juan
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		// Pedro
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.BASTO), new Tres(Palo.BASTO), new Cuatro(Palo.BASTO), new Cinco(Palo.BASTO), new Seis(Palo.BASTO)));
		Assert.assertTrue(juego.cantarFlorPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarFlorPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("1"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("3"));
	}
	
	@Test
	public void testSeCantaTrucoSeCantaFlorYSeAcepta() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
		// Juan
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		// Pedro
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.BASTO), new Tres(Palo.BASTO), new Cuatro(Palo.BASTO), new Cinco(Palo.BASTO), new Seis(Palo.BASTO)));
		Assert.assertTrue(juego.cantarFlorPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarFlorPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("7"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
	}
	
	@Test
	public void testPartidaCompleta() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
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
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("1"));
	
		// Juan
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA), new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA)));
		
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
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA), new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA)));
		
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
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("9"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("9"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA), new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA)));
		
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
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA), new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA)));
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("5"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("13"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("6"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("13"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA), new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA)));
		
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
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA), new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA)));
		
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
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA), new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA)));
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("10"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("18"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("10"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("19"));
		
		// Juan
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA), new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA)));
		
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
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA), new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA)));
		
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
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA), new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA)));
		
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
		juego.repartirCartas(Arrays.asList( new Tres(Palo.COPA), new UnoDeCopa(), new Cinco(Palo.ESPADA), new SieteDeEspada(), new UnoDeOro(), new Seis(Palo.COPA)));
		
		Assert.assertTrue(juego.cantarFaltaEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("15"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("30"));
	}
}
