package algoritmosyprogramacion3.tp2.pruebasIntegracion;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.excepciones.PartidaSinFlorException;
import algoritmosyprogramacion3.tp2.modelo.Caballo;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.Cinco;
import algoritmosyprogramacion3.tp2.modelo.Cuatro;
import algoritmosyprogramacion3.tp2.modelo.Dos;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.modelo.Palo;
import algoritmosyprogramacion3.tp2.modelo.Rey;
import algoritmosyprogramacion3.tp2.modelo.Seis;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeOro;
import algoritmosyprogramacion3.tp2.modelo.Sota;
import algoritmosyprogramacion3.tp2.modelo.Tres;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class PartidaDeSeisSinFlorTest {

	private JuegoTruco juego;
	
	private void repartirCartas(List<Carta> cartas) {
		juego.repartirCartas(cartas);
	}
	
	@Before
	public void setUp() {
		
		juego = new JuegoTruco();
		juego.nuevaMesaDeSeisSinFlor("mesa1", Arrays.asList("Juan", "Pedro", "Jorge"), Arrays.asList("Rodolfo", "José", "Raul"));
	}

	@Test (expected = PartidaSinFlorException.class)
	public void testCantarFlorNoDeberiaSerPosible() {
		
		this.repartirCartas(Arrays.asList(new UnoDeBasto(), new Dos(Palo.BASTO), new Tres(Palo.BASTO),new Cuatro(Palo.BASTO), new Cinco(Palo.BASTO), new Seis(Palo.BASTO),new SieteDeBasto(), new Sota(Palo.BASTO), new Caballo(Palo.BASTO),new UnoDeOro(), new Dos(Palo.ORO), new Tres(Palo.ORO), new Cuatro(Palo.ORO), new Cinco(Palo.ORO), new Seis(Palo.ORO), new SieteDeOro(), new Caballo(Palo.ORO), new Rey(Palo.ORO)));
		juego.cantarFlorPorJugador("Juan");
	}
}
