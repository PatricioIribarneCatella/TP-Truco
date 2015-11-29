package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.CaballoDeOro;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.CincoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeCopa;
import algoritmosyprogramacion3.tp2.modelo.DosDeEspada;
import algoritmosyprogramacion3.tp2.modelo.ReyDeOro;
import algoritmosyprogramacion3.tp2.modelo.SeisDeCopa;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeCopa;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.SieteDeOro;
import algoritmosyprogramacion3.tp2.modelo.SotaDeOro;
import algoritmosyprogramacion3.tp2.modelo.TresDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeCopa;
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
	public void testCompararDosCartasDeDosFormasDiferentesDeberiaDevolverSiempreLaMismaCarta() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new SieteDeBasto();
		
		Assert.assertTrue(carta1.jugarContra(carta2).equals(carta2.jugarContra(carta1)));
	}
	
	@Test
	public void testCompararDosCartasQueEmpatanDeDosFormasDiferentesDeberiaDevolverAlgunaDeEllas() {
		
		Carta carta1 = new UnoDeCopa();
		Carta carta2 = new UnoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta2);
		Assert.assertTrue(carta2.jugarContra(carta1) == carta1);
	}
	
	// Uno de Espada
	
	@Test
	public void testUnoDeEspadaGanaAUnoDeBasto() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new UnoDeBasto();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaASieteDeEspada() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new SieteDeEspada();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaASieteDeOro() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new SieteDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosTres() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new TresDeBasto();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosDos() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new DosDeEspada();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosUnosFalsos() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new UnoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosReyes() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new ReyDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosCaballos() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new CaballoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosSotas() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new SotaDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosSieteFalsos() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosSeis() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosCinco() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosCuatro() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testCompararDosCartasPorJerarquia2() {
		
		Carta carta1 = new DosDeEspada();
		Carta carta2 = new TresDeBasto();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta2);
	}
	
	// Uno de Basto
	
	@Test
	public void testUnoDeBastoGanaASieteDeEspada() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new SieteDeEspada();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaASieteDeOro() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new SieteDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosTres() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new TresDeBasto();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosDos() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new DosDeEspada();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosUnosFalsos() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new UnoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosReyes() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new ReyDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosCaballos() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new CaballoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosSotas() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new SotaDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosSietesFalsos() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosSeis() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosCinco() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosCuatro() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Siete de Espada
	
	@Test
	public void testSieteDeEspadaGanaASieteDeOro() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new SieteDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosTres() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new TresDeBasto();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosDos() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new DosDeEspada();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosUnosFalsos() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new UnoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosReyes() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new ReyDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosCaballos() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new CaballoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosSotas() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new SotaDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosSietesFalsos() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosSeis() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosCinco() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosCuatro() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Siete de Oro
	
	@Test
	public void testSieteDeOroGanaALosTres() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new TresDeBasto();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosDos() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new DosDeEspada();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosUnosFalsos() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new UnoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosReyes() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new ReyDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosCaballos() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new CaballoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosSotas() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new SotaDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosSietesFalsos() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosSeis() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosCinco() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosCuatro() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Tres
	
	@Test
	public void testTresGanaALosDos() {
		
		Carta carta1 = new TresDeBasto();
		Carta carta2 = new DosDeEspada();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosUnosFalsos() {
		
		Carta carta1 = new TresDeBasto();
		Carta carta2 = new UnoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosReyes() {
		
		Carta carta1 = new TresDeBasto();
		Carta carta2 = new ReyDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosCaballos() {
		
		Carta carta1 = new TresDeBasto();
		Carta carta2 = new CaballoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosSotas() {
		
		Carta carta1 = new TresDeBasto();
		Carta carta2 = new SotaDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosSietesFalsos() {
		
		Carta carta1 = new TresDeBasto();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosSeis() {
		
		Carta carta1 = new TresDeBasto();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosCinco() {
		
		Carta carta1 = new TresDeBasto();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosCuatro() {
		
		Carta carta1 = new TresDeBasto();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Dos
	
	@Test
	public void testDosGanaALosUnosFalsos() {
		
		Carta carta1 = new DosDeEspada();
		Carta carta2 = new UnoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosReyes() {
		
		Carta carta1 = new DosDeEspada();
		Carta carta2 = new ReyDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosCaballos() {
		
		Carta carta1 = new DosDeEspada();
		Carta carta2 = new CaballoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosSotas() {
		
		Carta carta1 = new DosDeEspada();
		Carta carta2 = new SotaDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosSietesFalsos() {
		
		Carta carta1 = new DosDeEspada();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosSeis() {
		
		Carta carta1 = new DosDeEspada();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosCinco() {
		
		Carta carta1 = new DosDeEspada();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosCuatro() {
		
		Carta carta1 = new DosDeEspada();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Unos Falsos
	
	@Test
	public void testUnosFalsosGanaALosReyes() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new ReyDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnosFalsosGanaALosCaballos() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new CaballoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnosFalsosGanaALosSotas() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new SotaDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnosFalsosGanaALosSietesFalsos() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnosFalsosGanaALosSeis() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnosFalsosGanaALosCinco() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnosFalsosGanaALosCuatro() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Rey
	
	@Test
	public void testReyGanaALosCaballos() {
		
		Carta carta1 = new ReyDeOro();
		Carta carta2 = new CaballoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testReyGanaALosSotas() {
		
		Carta carta1 = new ReyDeOro();
		Carta carta2 = new SotaDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testReyGanaALosSietesFalsos() {
		
		Carta carta1 = new ReyDeOro();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testReyGanaALosSeis() {
		
		Carta carta1 = new ReyDeOro();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testReyGanaALosCinco() {
		
		Carta carta1 = new ReyDeOro();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testReyDeOroGanaALosCuatro() {
		
		Carta carta1 = new ReyDeOro();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Caballo
	
	@Test
	public void testCaballoGanaALosSotas() {
		
		Carta carta1 = new CaballoDeOro();
		Carta carta2 = new SotaDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testCaballoGanaALosSietesFalsos() {
		
		Carta carta1 = new CaballoDeOro();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testCaballoGanaALosSeis() {
		
		Carta carta1 = new CaballoDeOro();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testCaballoGanaALosCinco() {
		
		Carta carta1 = new CaballoDeOro();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testCaballoDeOroGanaALosCuatro() {
		
		Carta carta1 = new CaballoDeOro();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Sota
	
	@Test
	public void testSotaGanaALosSietesFalsos() {
		
		Carta carta1 = new SotaDeOro();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSotaGanaALosSeis() {
		
		Carta carta1 = new SotaDeOro();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSotaGanaALosCinco() {
		
		Carta carta1 = new SotaDeOro();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSotaDeOroGanaALosCuatro() {
		
		Carta carta1 = new SotaDeOro();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Sietes Falsos
	
	@Test
	public void testSieteFalsosGanaALosSeis() {
		
		Carta carta1 = new SieteDeCopa();
		Carta carta2 = new SeisDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteFalsosGanaALosCinco() {
		
		Carta carta1 = new SieteDeCopa();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteFalsosGanaALosCuatro() {
		
		Carta carta1 = new SieteDeCopa();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Seis
	
	@Test
	public void testSeisGanaALosCinco() {
		
		Carta carta1 = new SeisDeCopa();
		Carta carta2 = new CincoDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSeisGanaALosCuatro() {
		
		Carta carta1 = new SeisDeCopa();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Cinco
	
	@Test
	public void testCincoGanaALosCuatro() {
		
		Carta carta1 = new CincoDeCopa();
		Carta carta2 = new CuatroDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
}