package algoritmosyprogramacion3.tp2.pruebasIntegracion;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.CaballoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.CaballoDeOro;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.CincoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.CincoDeOro;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeBasto;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeOro;
import algoritmosyprogramacion3.tp2.modelo.DosDeBasto;
import algoritmosyprogramacion3.tp2.modelo.DosDeOro;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.modelo.ReyDeOro;
import algoritmosyprogramacion3.tp2.modelo.SeisDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SeisDeOro;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeOro;
import algoritmosyprogramacion3.tp2.modelo.SotaDeBasto;
import algoritmosyprogramacion3.tp2.modelo.TresDeBasto;
import algoritmosyprogramacion3.tp2.modelo.TresDeOro;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class PartidaDeSeisConFlorTest {

	private JuegoTruco juego;
	
	private void repartirCartas(List<Carta> cartas) {
		juego.repartirCartas(cartas);
	}

	@Before
	public void setUp() {
		
		juego = new JuegoTruco();
		juego.nuevaMesaDeSeisConFlor("mesa1", Arrays.asList("Juan", "Pedro", "Jorge"), Arrays.asList("Rodolfo", "José", "Raul"));
	}

	@Test
	public void testCantarFlorDeberiaSerPosible() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new DosDeBasto(), new TresDeBasto(),new CuatroDeBasto(), new CincoDeBasto(), new SeisDeBasto(),new SieteDeBasto(), new SotaDeBasto(), new CaballoDeBasto(),new UnoDeOro(), new DosDeOro(), new TresDeOro(), new CuatroDeOro(), new CincoDeOro(), new SeisDeOro(), new SieteDeOro(), new CaballoDeOro(), new ReyDeOro()));
		Assert.assertTrue(juego.cantarFlorPorJugador("Juan"));
	}
}
