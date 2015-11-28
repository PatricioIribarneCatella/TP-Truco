package algoritmosyprogramacion3.tp2.pruebasIntegracion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;

public class PartidaDeSeisSinFlorTest {

	private JuegoTruco juego;
	
	@Before
	public void setUp() {
		
		juego = new JuegoTruco();
		juego.nuevaMesaDeSeisSinFlor("mesa1", Arrays.asList("Juan", "Pedro", "Jorge"), Arrays.asList("Rodolfo", "José", "Raul"));
	}

	@Test
	public void testCantarFlorNoDeberiaSerPosible() {
		
		Assert.assertFalse(juego.cantarFlorPorJugador("Juan"));
	}
}
