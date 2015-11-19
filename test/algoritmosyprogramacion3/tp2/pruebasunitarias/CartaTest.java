package algoritmosyprogramacion3.tp2.pruebasunitarias;

import org.junit.Assert;
import org.junit.Test;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.DosDeEspada;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeCopa;
import algoritmosyprogramacion3.tp2.modelo.TresDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class CartaTest {

	@Test
	public void testCartaArrancaEnMazo() {
		
		Carta carta = new UnoDeEspada();
		
		Assert.assertFalse(carta.esValidaParaSerJugada());
	}
	
	@Test
	public void testUnaVezEnManoLaCartaSePuedeJugar() {
		
		Carta carta = new UnoDeEspada();
		
		carta.entregada();
		
		Assert.assertTrue(carta.esValidaParaSerJugada());
	}
	
	@Test
	public void testUnaVezJugadaYaNoEsPosibleJugarlaDeNuevo() {
		
		Carta carta = new UnoDeEspada();
		
		carta.entregada();
		carta.jugate();
		
		Assert.assertFalse(carta.esValidaParaSerJugada());
	}
	
	@Test
	public void testCuandoVuelveAlMazoYaNoEsPosibleJugarla() {
		
		Carta carta = new UnoDeEspada();
		
		carta.entregada();
		carta.jugate();
		carta.volveAlMazo();
		
		Assert.assertFalse(carta.esValidaParaSerJugada());
	}
	
	@Test
	public void testCompararDosCartasPorJerarquia1() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new UnoDeBasto();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}	
	
	@Test
	public void testCompararDosCartasPorJerarquia2() {
		
		Carta carta1 = new DosDeEspada();
		Carta carta2 = new TresDeBasto();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta2);
	}
	
	@Test
	public void testCompararDosCartasPorJerarquia3() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new UnoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testCompararDosCartasPorJerarquia4() {
		
		Carta carta1 = new SieteDeCopa();
		Carta carta2 = new SieteDeBasto();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta2);
	}
}