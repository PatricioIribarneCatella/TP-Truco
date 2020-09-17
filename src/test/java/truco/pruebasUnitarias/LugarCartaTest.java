package truco.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import truco.modelo.EnMano;
import truco.modelo.EnMazo;
import truco.modelo.EnMesa;
import truco.modelo.LugarCarta;

public class LugarCartaTest {

	@Test
	public void testEstadoEnMazoNoEsValidoParaSerJugada() {
		
		LugarCarta lugar = new EnMazo();
		Assert.assertFalse(lugar.sosValidoParaQueSeJuegueLaCarta());
	}
	
	@Test
	public void testEstadoEnManoEsValidoParaSerJugada() {
		
		LugarCarta lugar = new EnMano();
		Assert.assertTrue(lugar.sosValidoParaQueSeJuegueLaCarta());
	}
	
	@Test
	public void testEstadoEnMesaNoEsValidoParaSerJugada() {
		
		LugarCarta lugar = new EnMesa();
		Assert.assertFalse(lugar.sosValidoParaQueSeJuegueLaCarta());
	}
}
