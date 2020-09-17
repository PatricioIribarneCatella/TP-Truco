package truco.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import truco.modelo.Aceptar;
import truco.modelo.Rechazar;
import truco.modelo.Respuesta;

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
