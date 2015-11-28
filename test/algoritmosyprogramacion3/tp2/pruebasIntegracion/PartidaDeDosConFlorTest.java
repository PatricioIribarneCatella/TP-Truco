package algoritmosyprogramacion3.tp2.pruebasIntegracion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;

public class PartidaDeDosConFlorTest {

	private JuegoTruco juego;
	
	@Before
	public void setUp() {
		
		juego = new JuegoTruco();
		juego.nuevaMesaDeDosConFlor("mesa1", Arrays.asList("Juan", "Pedro"));
	}

	@Test
	public void testCantarFlorDeberiaSerPosible() {
		
		Assert.assertTrue(juego.cantarFlorPorJugador("Juan"));
	}
	
	@Test
	public void testMismoJugadorCantaTrucoYAceptaNoDeberiaSerPosible() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertFalse(juego.aceptarPorJugador("Juan"));
	}
	
	@Test
	public void testMismoJugadorCantaEnvidoYAceptaNoDeberiaSerPosible() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertFalse(juego.aceptarPorJugador("Juan"));
	}
	
	@Test
	public void testNoDeberiaSerPosibleCantarReTrucoCuandoEmpiezaLaPartida() {
		
		Assert.assertFalse(juego.cantarReTrucoPorJugador("Juan"));
	}
	
	@Test
	public void testNoDeberiaSerPosibleCantarValeCuatroCuandoEmpiezaLaPartida() {
		
		Assert.assertFalse(juego.cantarValeCuatroPorJugador("Juan"));
	}
	
	@Test
	public void testMismoJugadorCantaTrucoYReTruco() {
	
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertFalse(juego.cantarReTrucoPorJugador("Juan"));
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
		Assert.assertTrue(juego.aceptarPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("2"));
	}
	
	@Test
	public void testSeCantaTrucoSeCantaReTrucoSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarPorJugador("Juan"));
		
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
		Assert.assertTrue(juego.aceptarPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("4"));
	}
	
	@Test
	public void testSeCantaEnvidoSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarPorJugador("Pedro"));
		
		int numero = juego.mostrarPuntosEnvido("Juan").compareTo(juego.mostrarPuntosEnvido("Pedro"));
		
		if (numero > 1) {
			Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
			Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("2"));
		} else {
			Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
			Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		}
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
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new UnoDeEspada()));
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("1"));
	
		// Juan
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new UnoDeEspada()));
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("5"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new UnoDeEspada()));
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("9"));
		
		// Juan
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new UnoDeEspada()));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("9"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("9"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new UnoDeEspada()));
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("13"));
		
		// Juan
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("5"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("13"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("6"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("13"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new UnoDeEspada()));
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("6"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("17"));
		
		// Juan
		juego.repartirCartas(Arrays.asList(new UnoDeEspada(), new UnoDeBasto()));
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("10"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("17"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new UnoDeEspada()));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("10"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("18"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("10"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("19"));
		
		// Juan
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new UnoDeEspada()));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarRealEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("10"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("21"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("10"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("25"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new UnoDeEspada(), new UnoDeBasto()));
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarPorJugador("Juan"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("14"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("25"));
		
		// Juan
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new UnoDeEspada()));
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("14"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("29"));
		
		// Pedro
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(), new UnoDeEspada()));
		Assert.assertTrue(juego.cantarFaltaEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Juan"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("14"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("30"));
	}
}
