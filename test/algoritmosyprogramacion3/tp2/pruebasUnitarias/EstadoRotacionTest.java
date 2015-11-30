package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.EstadoRotacion;
import algoritmosyprogramacion3.tp2.modelo.MayorQueCincoYMenorQueVenticinco;
import algoritmosyprogramacion3.tp2.modelo.MayorQueVeinticinco;
import algoritmosyprogramacion3.tp2.modelo.MenorQueCinco;

public class EstadoRotacionTest {

	@Test
	public void testEstadoMenorQueCincoNoEsValidoParaCambiarComportamiento() {
		
		EstadoRotacion estado = new MenorQueCinco();
		Assert.assertFalse(estado.esValidaParaCambiarComportamiento());
	}

	@Test
	public void testEstadoMayorQueVenticincoNoEsValidoParaCambiarComportamiento() {
		
		EstadoRotacion estado = new MayorQueVeinticinco();
		Assert.assertFalse(estado.esValidaParaCambiarComportamiento());
	}
	
	@Test
	public void testEstadoMayorQueCincoYMenorQueVenticincoEsValidoParaCambiarComportamiento() {
		
		EstadoRotacion estado = new MayorQueCincoYMenorQueVenticinco();
		Assert.assertTrue(estado.esValidaParaCambiarComportamiento());
	}
}
