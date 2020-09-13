package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.EnvidoCantado;
import algoritmosyprogramacion3.tp2.modelo.EstadoPartida;
import algoritmosyprogramacion3.tp2.modelo.FaltaEnvidoCantado;
import algoritmosyprogramacion3.tp2.modelo.PartidaFinalizada;
import algoritmosyprogramacion3.tp2.modelo.ReTrucoCantado;
import algoritmosyprogramacion3.tp2.modelo.RealEnvidoCantado;
import algoritmosyprogramacion3.tp2.modelo.TrucoCantado;
import algoritmosyprogramacion3.tp2.modelo.TurnoJugador;
import algoritmosyprogramacion3.tp2.modelo.ValeCuatroCantado;

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
