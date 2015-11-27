package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Aceptar;
import algoritmosyprogramacion3.tp2.modelo.Rechazar;
import algoritmosyprogramacion3.tp2.modelo.Respuesta;

public class RespuestaTest {

	@Test
	public void testRespuestaAceptarNoInvolucarCambioDeTurno() {
		
		Respuesta aceptar = new Aceptar();
		Assert.assertFalse(aceptar.involucraCambioDeTurno());
	}
	
	@Test
	public void testRespuestaRechazarNoInvolucarCambioDeTurno() {
		
		Respuesta rechazar = new Rechazar();
		Assert.assertFalse(rechazar.involucraCambioDeTurno());
	}
}
