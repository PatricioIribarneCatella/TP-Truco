package algoritmosyprogramacion3.tp2.pruebasIntegracion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;

public class PartidaDeCuatroConFlorTest {

	private JuegoTruco juego;
	
	@Before
	public void setUp() {
		
		juego = new JuegoTruco();
		juego.nuevaMesaDeCuatroConFlor("mesa1", Arrays.asList("Juan", "Pedro"), Arrays.asList("Jorge", "Rodolfo"));
	}

	@Test
	public void testCantarFlorDeberiaSerPosible() {
		
		Assert.assertTrue(juego.cantarFlorPorJugador("Juan"));
	}
}
