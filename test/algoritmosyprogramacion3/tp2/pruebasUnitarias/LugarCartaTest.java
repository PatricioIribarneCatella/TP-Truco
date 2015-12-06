package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.EnMano;
import algoritmosyprogramacion3.tp2.modelo.EnMazo;
import algoritmosyprogramacion3.tp2.modelo.EnMesa;
import algoritmosyprogramacion3.tp2.modelo.LugarCarta;

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
