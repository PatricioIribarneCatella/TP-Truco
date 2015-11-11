package algoritmosyprogramacion3.tp2.pruebasunitarias;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.CincoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.CincoDeOro;
import algoritmosyprogramacion3.tp2.modelo.Mano;
import algoritmosyprogramacion3.tp2.modelo.SeisDeEspada;
import algoritmosyprogramacion3.tp2.modelo.SieteDeCopa;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;

public class ManoTest {

	private Mano mano;
	
	@Before
	public void setUp() {
		this.mano = new Mano();
	}
	
	@Test
	public void testAgregarCartasFormandoFlorDeberiaSerTrueSiSePreguntaEso() {
		
		Carta carta1 = new CincoDeEspada();
		Carta carta2 = new SeisDeEspada();
		Carta carta3 = new SieteDeEspada();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertTrue(mano.hayFlor());
	}

	@Test
	public void testAgregarCartasNoFormandoFlorDeberiaDevolverFalseSiSePreguntaEso() {
		
		Carta carta1 = new CincoDeOro();
		Carta carta2 = new SeisDeEspada();
		Carta carta3 = new SieteDeEspada();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertFalse(mano.hayFlor());
	}
	
	@Test
	public void testAgregarCartasFormandoFlorDeberiaDevolverElPuntajeCorrecto() {
		
		Carta carta1 = new CincoDeEspada();
		Carta carta2 = new SeisDeEspada();
		Carta carta3 = new SieteDeEspada();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertTrue(mano.puntajeFlor().equals("38"));
	}
	
	@Test
	public void testAgregarCartasFormandoEnvidoConDosCartasDelMismoPaloDeberiaDevolverElPuntajeCorrecto() {
		
		Carta carta1 = new CincoDeOro();
		Carta carta2 = new SeisDeEspada();
		Carta carta3 = new SieteDeEspada();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertTrue(mano.puntajeEnvido().equals("33"));
	}
	
	@Test
	public void testAgregarCartasFormandoUnaFlorPeroCantandoEnvidoDeberiaDevolverElPuntajeCorrecto() {
		
		Carta carta1 = new CincoDeEspada();
		Carta carta2 = new SeisDeEspada();
		Carta carta3 = new SieteDeEspada();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertTrue(mano.puntajeEnvido().equals("33"));
	}
	
	@Test
	public void testAgregarCartasDeDiferentePaloYCantarEnvidoDeberiaDevolverElMaximoValorDeLasCartas() {
		
		Carta carta1 = new CincoDeOro();
		Carta carta2 = new SeisDeEspada();
		Carta carta3 = new SieteDeCopa();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertTrue(mano.puntajeEnvido().equals("27"));
	}	
}
