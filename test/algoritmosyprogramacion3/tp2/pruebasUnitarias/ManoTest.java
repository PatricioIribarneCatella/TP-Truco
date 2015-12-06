package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.Cinco;
import algoritmosyprogramacion3.tp2.modelo.Mano;
import algoritmosyprogramacion3.tp2.modelo.Palo;
import algoritmosyprogramacion3.tp2.modelo.Seis;
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
		
		Carta carta1 = new Cinco(Palo.ESPADA);
		Carta carta2 = new Seis(Palo.ESPADA);
		Carta carta3 = new SieteDeEspada();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertTrue(mano.hayFlor());
	}

	@Test
	public void testAgregarCartasNoFormandoFlorDeberiaDevolverFalseSiSePreguntaEso() {
		
		Carta carta1 = new Cinco(Palo.ORO);
		Carta carta2 = new Seis(Palo.ESPADA);
		Carta carta3 = new SieteDeEspada();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertFalse(mano.hayFlor());
	}
	
	@Test
	public void testAgregarCartasFormandoFlorDeberiaDevolverElPuntajeCorrecto() {
		
		Carta carta1 = new Cinco(Palo.ESPADA);
		Carta carta2 = new Seis(Palo.ESPADA);
		Carta carta3 = new SieteDeEspada();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertTrue(mano.puntajeFlor().equals("38"));
	}
	
	@Test
	public void testAgregarCartasFormandoEnvidoConDosCartasDelMismoPaloDeberiaDevolverElPuntajeCorrecto() {
		
		Carta carta1 = new Cinco(Palo.ORO);
		Carta carta2 = new Seis(Palo.ESPADA);
		Carta carta3 = new SieteDeEspada();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertTrue(mano.puntajeEnvido().equals("33"));
	}
	
	@Test
	public void testAgregarCartasFormandoUnaFlorPeroCantandoEnvidoDeberiaDevolverElPuntajeCorrecto() {
		
		Carta carta1 = new Cinco(Palo.ESPADA);
		Carta carta2 = new Seis(Palo.ESPADA);
		Carta carta3 = new SieteDeEspada();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertTrue(mano.puntajeEnvido().equals("33"));
	}
	
	@Test
	public void testAgregarCartasDeDiferentePaloYCantarEnvidoDeberiaDevolverElMaximoValorDeLasCartas() {
		
		Carta carta1 = new Cinco(Palo.ORO);
		Carta carta2 = new Seis(Palo.ESPADA);
		Carta carta3 = new SieteDeCopa();
		
		mano.agregarCarta(carta1);
		mano.agregarCarta(carta2);
		mano.agregarCarta(carta3);
		
		Assert.assertTrue(mano.puntajeEnvido().equals("7"));
	}	
}
