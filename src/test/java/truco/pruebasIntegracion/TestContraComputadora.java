package algoritmosyprogramacion3.tp2.pruebasIntegracion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.PartidaSinFlorException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;
import algoritmosyprogramacion3.tp2.modelo.Dos;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.modelo.Palo;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;

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
