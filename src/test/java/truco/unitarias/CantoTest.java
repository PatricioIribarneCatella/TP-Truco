package truco.unitarias;

import org.junit.Assert;
import org.junit.Test;

import truco.modelo.Envido;
import truco.modelo.Evento;
import truco.modelo.FaltaEnvido;
import truco.modelo.ReTruco;
import truco.modelo.RealEnvido;
import truco.modelo.Truco;
import truco.modelo.ValeCuatro;

public class CantoTest {

	@Test
	public void testEventoTrucoSeLePuedeSubirLaApuesta() {
		
		Evento truco = new Truco();
		Assert.assertTrue(truco.esPosibleSubirLaApuesta());
	}
	
	@Test
	public void testEventoReTrucoSeLePuedeSubirLaApuesta() {
		
		Evento reTruco = new ReTruco();
		Assert.assertTrue(reTruco.esPosibleSubirLaApuesta());
	}
	
	@Test
	public void testEventoValeCuatroNoSeLePuedeSubirLaApuesta() {
		
		Evento valeCuatro = new ValeCuatro();
		Assert.assertFalse(valeCuatro.esPosibleSubirLaApuesta());
	}
	
	@Test
	public void testEventoEnvidoSeLePuedeSubirLaApuesta() {
		
		Evento envido = new Envido();
		Assert.assertTrue(envido.esPosibleSubirLaApuesta());
	}
	
	@Test
	public void testEventoRealEnvidoSeLePuedeSubirLaApuesta() {
		
		Evento realEnvido = new RealEnvido();
		Assert.assertTrue(realEnvido.esPosibleSubirLaApuesta());
	}
	
	@Test
	public void testEventoFaltaEnvidoNoSeLePuedeSubirLaApuesta() {
		
		Evento faltaEnvido = new FaltaEnvido();
		Assert.assertFalse(faltaEnvido.esPosibleSubirLaApuesta());
	}
	
	@Test
	public void testEventoTrucoNoInvolucraCambioDeTurno() {
		
		Evento truco = new Truco();
		Assert.assertFalse(truco.involucraCambioDeTurno());
	}
	
	@Test
	public void testEventoReTrucoNoInvolucraCambioDeTurno() {
		
		Evento reTruco = new ReTruco();
		Assert.assertFalse(reTruco.involucraCambioDeTurno());
	}
	
	@Test
	public void testEventoValeCuatroNoInvolucraCambioDeTurno() {
		
		Evento valeCuatro = new ValeCuatro();
		Assert.assertFalse(valeCuatro.involucraCambioDeTurno());
	}
	
	@Test
	public void testEventoEnvidoNoInvolucraCambioDeTurno() {
		
		Evento envido = new Envido();
		Assert.assertFalse(envido.involucraCambioDeTurno());
	}
	
	@Test
	public void testEventoRealEnvidoNoInvolucraCambioDeTurno() {
		
		Evento realEnvido = new RealEnvido();
		Assert.assertFalse(realEnvido.involucraCambioDeTurno());
	}
	
	@Test
	public void testEventoFaltaEnvidoNoInvolucraCambioDeTurno() {
		
		Evento faltaEnvido = new FaltaEnvido();
		Assert.assertFalse(faltaEnvido.involucraCambioDeTurno());
	}
}
