package truco.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import truco.modelo.EstadoRotacion;
import truco.modelo.MayorQueCincoYMenorQueVenticinco;
import truco.modelo.MayorQueVeinticinco;
import truco.modelo.MenorQueCinco;

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
