package algoritmosyprogramacion3.tp2.pruebasIntegracion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;

public class PartidaDeCuatroSinFlorTest {

	private JuegoTruco juego;
	
	@Before
	public void setUp() {
		
		juego = new JuegoTruco();
		juego.nuevaMesaDeCuatroSinFlor(Arrays.asList("Juan", "Pedro"), Arrays.asList("Jorge", "Rodolfo"));
	}

	@Test
	public void testCantarFlorNoDeberiaSerPosible() {
		
		Assert.assertFalse(juego.cantarFlorPorJugador("Juan"));
	}
}
