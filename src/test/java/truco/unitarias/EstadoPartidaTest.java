package truco.unitarias;

import org.junit.Assert;
import org.junit.Test;

import truco.modelo.EnvidoCantado;
import truco.modelo.EstadoPartida;
import truco.modelo.FaltaEnvidoCantado;
import truco.modelo.PartidaFinalizada;
import truco.modelo.ReTrucoCantado;
import truco.modelo.RealEnvidoCantado;
import truco.modelo.TrucoCantado;
import truco.modelo.TurnoJugador;
import truco.modelo.ValeCuatroCantado;

public class EstadoPartidaTest {
	
	@Test
	public void testEstadoPartidaFinalizadaEsUnEstadoInvalidoParaCualquierTipoDeAccion() {
		
		EstadoPartida estado = new PartidaFinalizada();
		
		Assert.assertFalse(estado.esValidoParaAceptar());
		Assert.assertFalse(estado.esValidoParaJugarCarta());
		Assert.assertFalse(estado.esValidoParaCantarEnvido());
		Assert.assertFalse(estado.esValidoParaCantarFaltaEnvido());
		Assert.assertFalse(estado.esValidoParaCantarRealEnvido());
		Assert.assertFalse(estado.esValidoParaCantarTruco());
		Assert.assertFalse(estado.esValidoParaCantarReTruco());
		Assert.assertFalse(estado.esValidoParaCantarValeCuatro());
		Assert.assertFalse(estado.esValidoParaRechazar());
	}
	
	@Test
	public void testEstadoTrucoCantadoRespondeCorrectamenteASuSignificado() {
		
		EstadoPartida estado = new TrucoCantado();
		
		Assert.assertFalse(estado.esValidoParaJugarCarta());
		Assert.assertFalse(estado.esValidoParaCantarEnvido());
		Assert.assertFalse(estado.esValidoParaCantarFaltaEnvido());
		Assert.assertFalse(estado.esValidoParaCantarRealEnvido());
		Assert.assertFalse(estado.esValidoParaCantarTruco());
		Assert.assertTrue(estado.esValidoParaCantarReTruco());
		Assert.assertFalse(estado.esValidoParaCantarValeCuatro());
		Assert.assertTrue(estado.esValidoParaAceptar());
		Assert.assertTrue(estado.esValidoParaRechazar());
	}
	
	@Test
	public void testEstadoReTrucoCantadoRespondeCorrectamenteASuSignificado() {
		
		EstadoPartida estado = new ReTrucoCantado();
		
		Assert.assertFalse(estado.esValidoParaJugarCarta());
		Assert.assertFalse(estado.esValidoParaCantarEnvido());
		Assert.assertFalse(estado.esValidoParaCantarFaltaEnvido());
		Assert.assertFalse(estado.esValidoParaCantarRealEnvido());
		Assert.assertFalse(estado.esValidoParaCantarTruco());
		Assert.assertFalse(estado.esValidoParaCantarReTruco());
		Assert.assertTrue(estado.esValidoParaCantarValeCuatro());
		Assert.assertTrue(estado.esValidoParaAceptar());
		Assert.assertTrue(estado.esValidoParaRechazar());
	}
	
	@Test
	public void testEstadoValeCuatroCantadoRespondeCorrectamenteASuSignificado() {
		
		EstadoPartida estado = new ValeCuatroCantado();
		
		Assert.assertFalse(estado.esValidoParaJugarCarta());
		Assert.assertFalse(estado.esValidoParaCantarEnvido());
		Assert.assertFalse(estado.esValidoParaCantarFaltaEnvido());
		Assert.assertFalse(estado.esValidoParaCantarRealEnvido());
		Assert.assertFalse(estado.esValidoParaCantarTruco());
		Assert.assertFalse(estado.esValidoParaCantarReTruco());
		Assert.assertFalse(estado.esValidoParaCantarValeCuatro());
		Assert.assertTrue(estado.esValidoParaAceptar());
		Assert.assertTrue(estado.esValidoParaRechazar());
	}
	
	@Test
	public void testEstadoEnvidoCantadoRespondeCorrectamenteASuSignificado() {
		
		EstadoPartida estado = new EnvidoCantado();
		
		Assert.assertFalse(estado.esValidoParaJugarCarta());
		Assert.assertTrue(estado.esValidoParaCantarEnvido());
		Assert.assertTrue(estado.esValidoParaCantarFaltaEnvido());
		Assert.assertTrue(estado.esValidoParaCantarRealEnvido());
		Assert.assertFalse(estado.esValidoParaCantarTruco());
		Assert.assertFalse(estado.esValidoParaCantarReTruco());
		Assert.assertFalse(estado.esValidoParaCantarValeCuatro());
		Assert.assertTrue(estado.esValidoParaAceptar());
		Assert.assertTrue(estado.esValidoParaRechazar());
	}
	
	@Test
	public void testEstadoRealEnvidoCantadoRespondeCorrectamenteASuSignificado() {
		
		EstadoPartida estado = new RealEnvidoCantado();
		
		Assert.assertFalse(estado.esValidoParaJugarCarta());
		Assert.assertFalse(estado.esValidoParaCantarEnvido());
		Assert.assertTrue(estado.esValidoParaCantarFaltaEnvido());
		Assert.assertFalse(estado.esValidoParaCantarRealEnvido());
		Assert.assertFalse(estado.esValidoParaCantarTruco());
		Assert.assertFalse(estado.esValidoParaCantarReTruco());
		Assert.assertFalse(estado.esValidoParaCantarValeCuatro());
		Assert.assertTrue(estado.esValidoParaAceptar());
		Assert.assertTrue(estado.esValidoParaRechazar());
	}
	
	@Test
	public void testEstadoFaltaEnvidoCantadoRespondeCorrectamenteASuSignificado() {
		
		EstadoPartida estado = new FaltaEnvidoCantado();
		
		Assert.assertFalse(estado.esValidoParaJugarCarta());
		Assert.assertFalse(estado.esValidoParaCantarEnvido());
		Assert.assertFalse(estado.esValidoParaCantarFaltaEnvido());
		Assert.assertFalse(estado.esValidoParaCantarRealEnvido());
		Assert.assertFalse(estado.esValidoParaCantarTruco());
		Assert.assertFalse(estado.esValidoParaCantarReTruco());
		Assert.assertFalse(estado.esValidoParaCantarValeCuatro());
		Assert.assertTrue(estado.esValidoParaAceptar());
		Assert.assertTrue(estado.esValidoParaRechazar());
	}
	
	@Test
	public void testEstadoTurnoJugadorRespondeCorrectamenteASuSignificado() {
		
		EstadoPartida estado = new TurnoJugador();
		
		Assert.assertTrue(estado.esValidoParaJugarCarta());
		Assert.assertTrue(estado.esValidoParaCantarEnvido());
		Assert.assertTrue(estado.esValidoParaCantarFaltaEnvido());
		Assert.assertTrue(estado.esValidoParaCantarRealEnvido());
		Assert.assertTrue(estado.esValidoParaCantarTruco());
		Assert.assertFalse(estado.esValidoParaCantarReTruco());
		Assert.assertFalse(estado.esValidoParaCantarValeCuatro());
		Assert.assertFalse(estado.esValidoParaAceptar());
		Assert.assertFalse(estado.esValidoParaRechazar());
	}
}
