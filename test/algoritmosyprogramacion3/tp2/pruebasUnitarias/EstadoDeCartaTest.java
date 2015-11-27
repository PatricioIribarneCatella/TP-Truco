package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.EnMano;
import algoritmosyprogramacion3.tp2.modelo.EnMazo;
import algoritmosyprogramacion3.tp2.modelo.EnMesa;
import algoritmosyprogramacion3.tp2.modelo.EstadoDeCarta;

public class EstadoDeCartaTest {

	@Test
	public void testEstadoEnMazoNoEsValidoParaSerJugada() {
		
		EstadoDeCarta estado = new EnMazo();
		Assert.assertFalse(estado.esValidoParaSerJugada());
	}
	
	@Test
	public void testEstadoEnManoEsValidoParaSerJugada() {
		
		EstadoDeCarta estado = new EnMano();
		Assert.assertTrue(estado.esValidoParaSerJugada());
	}
	
	@Test
	public void testEstadoEnMesaNoEsValidoParaSerJugada() {
		
		EstadoDeCarta estado = new EnMesa();
		Assert.assertFalse(estado.esValidoParaSerJugada());
	}
}
