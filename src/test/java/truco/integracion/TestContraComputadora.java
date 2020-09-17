package truco.integracion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import truco.modelo.Dos;
import truco.modelo.JuegoTruco;
import truco.modelo.Palo;
import truco.modelo.SieteDeBasto;
import truco.modelo.SieteDeCopa;
import truco.modelo.UnoDeBasto;
import truco.modelo.UnoDeEspada;
import truco.excepciones.AccionInvalidaException;
import truco.excepciones.PartidaSinFlorException;
import truco.excepciones.TurnoParaTomarDecisionEquivocadoException;

public class TestContraComputadora {

private JuegoTruco juego;
	
	@Before
	public void setUp() {
		
		juego = new JuegoTruco();
		juego.nuevaMesaContraComputadoraSinFlor("mesa1", "Tomas");
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.ORO), new SieteDeBasto(), new UnoDeEspada(), new Dos(Palo.BASTO), new SieteDeCopa()));
	}
	
	@Test (expected = PartidaSinFlorException.class)
	public void testCantarFlorNoDeberiaSerPosible() {
		
		juego.cantarFlorPorJugador("Tomas");
	}
	

	@Test (expected = AccionInvalidaException.class)
	public void testNoDeberiaSerPosibleCantarReTrucoCuandoEmpiezaLaPartida() {
		
		juego.cantarReTrucoPorJugador("Tomas");
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testNoDeberiaSerPosibleCantarValeCuatroCuandoEmpiezaLaPartida() {
		
		juego.cantarValeCuatroPorJugador("Tomas");
	}
	
	@Test (expected = TurnoParaTomarDecisionEquivocadoException.class)
	public void testMismoJugadorCantaTrucoYReTruco() {
	
		Assert.assertTrue(juego.cantarTrucoPorJugador("Tomas"));
		juego.cantarReTrucoPorJugador("Tomas");
	}
	
	@Test
	public void testSeCantaTrucoYSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Tomas"));// la computadora acepta
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Tomas"));// la computadora siempre juega la primer carta, asi que tomas pierde la primera
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Tomas"));// empatan pero ya hizo primera la PC
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Tomas").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Computadora").equals("2"));
	}
	
	@Test
	public void testSeCantaEnvidoSeLoAcepta() {

		Assert.assertTrue(juego.cantarEnvidoPorJugador("Tomas")); // la computadora siempre acepta
	
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Computadora").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Tomas").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Tomas").equals("28"));
	}
	
	@Test
	public void testSeCantaRealEnvidoSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarRealEnvidoPorJugador("Tomas")); // la computadora siempre acepta
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Computadora").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Tomas").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Tomas").equals("28"));
	}

	@Test
	public void testSeCantaFaltaEnvidoSeLoAcepta() {
		
	Assert.assertTrue(juego.cantarFaltaEnvidoPorJugador("Tomas")); // la computadora siempre acepta
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Computadora").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Tomas").equals("30"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Tomas").equals("28"));
	}
}
