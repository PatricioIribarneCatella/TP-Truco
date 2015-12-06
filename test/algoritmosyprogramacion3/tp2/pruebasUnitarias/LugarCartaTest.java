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
		
		LugarCarta estado = new EnMazo();
		Assert.assertFalse(estado.sosValidoParaQueSeJuegueLaCarta());
	}
	
	@Test
	public void testEstadoEnManoEsValidoParaSerJugada() {
		
		LugarCarta estado = new EnMano();
		Assert.assertTrue(estado.sosValidoParaQueSeJuegueLaCarta());
	}
	
	@Test
	public void testEstadoEnMesaNoEsValidoParaSerJugada() {
		
		LugarCarta estado = new EnMesa();
		Assert.assertFalse(estado.sosValidoParaQueSeJuegueLaCarta());
	}
}
