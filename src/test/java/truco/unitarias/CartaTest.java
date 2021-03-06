package truco.unitarias;

import org.junit.Assert;
import org.junit.Test;

import truco.modelo.Carta;
import truco.modelo.UnoDeBasto;
import truco.modelo.UnoDeCopa;
import truco.modelo.UnoDeEspada;
import truco.modelo.UnoDeOro;
import truco.modelo.Dos;
import truco.modelo.EnMano;
import truco.modelo.EnMazo;
import truco.modelo.EnMesa;
import truco.modelo.Tres;
import truco.modelo.Cuatro;
import truco.modelo.Cinco;
import truco.modelo.Seis;
import truco.modelo.SieteDeBasto;
import truco.modelo.SieteDeCopa;
import truco.modelo.SieteDeEspada;
import truco.modelo.SieteDeOro;
import truco.modelo.Sota;
import truco.modelo.Caballo;
import truco.modelo.Rey;

public class CartaTest {

	@Test
	public void testDosCartasQueSonInstanciasDeLaMismaCartaTieneIgualHashCode() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new UnoDeEspada();
		
		Assert.assertTrue(carta1.hashCode() == carta2.hashCode());
	}
	
	@Test
	public void testCartaArrancaEnMazo() {
		
		Carta carta = new UnoDeEspada();
		
		Assert.assertFalse(carta.estaEnUnLugarValidoParaSerJugada());
	}
	
	@Test
	public void testUnaVezEnManoLaCartaSePuedeJugar() {
		
		Carta carta = new UnoDeEspada();
		
		carta.pasaAEstar(new EnMano());;
		
		Assert.assertTrue(carta.estaEnUnLugarValidoParaSerJugada());
	}
	
	@Test
	public void testUnaVezJugadaYaNoEsPosibleJugarlaDeNuevo() {
		
		Carta carta = new UnoDeEspada();
		
		carta.pasaAEstar(new EnMano());
		carta.pasaAEstar(new EnMesa());
		
		Assert.assertFalse(carta.estaEnUnLugarValidoParaSerJugada());
	}
	
	@Test
	public void testCuandoVuelveAlMazoYaNoEsPosibleJugarla() {
		
		Carta carta = new UnoDeEspada();
		
		carta.pasaAEstar(new EnMano());
		carta.pasaAEstar(new EnMesa());
		carta.pasaAEstar(new EnMazo());
		
		Assert.assertFalse(carta.estaEnUnLugarValidoParaSerJugada());
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
		Carta carta2 = new Tres();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosDos() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new Dos();
		
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
		Carta carta2 = new Rey();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosCaballos() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new Caballo();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosSotas() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new Sota();
		
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
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosCincos() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeEspadaGanaALosCuatros() {
		
		Carta carta1 = new UnoDeEspada();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
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
		Carta carta2 = new Tres();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosDos() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new Dos();
		
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
		Carta carta2 = new Rey();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosCaballos() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new Caballo();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosSotas() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new Sota();
		
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
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosCincos() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnoDeBastoGanaALosCuatros() {
		
		Carta carta1 = new UnoDeBasto();
		Carta carta2 = new Cuatro();
		
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
		Carta carta2 = new Tres();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosDos() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new Dos();
		
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
		Carta carta2 = new Rey();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosCaballos() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new Caballo();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosSotas() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new Sota();
		
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
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosCinco() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeEspadaGanaALosCuatro() {
		
		Carta carta1 = new SieteDeEspada();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Siete de Oro
	
	@Test
	public void testSieteDeOroGanaALosTres() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new Tres();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosDos() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new Dos();
		
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
		Carta carta2 = new Rey();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosCaballos() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new Caballo();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosSotas() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new Sota();
		
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
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosCinco() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteDeOroGanaALosCuatro() {
		
		Carta carta1 = new SieteDeOro();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Tres
	
	@Test
	public void testTresGanaALosDos() {
		
		Carta carta1 = new Tres();
		Carta carta2 = new Dos();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosUnosFalsos() {
		
		Carta carta1 = new Tres();
		Carta carta2 = new UnoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosReyes() {
		
		Carta carta1 = new Tres();
		Carta carta2 = new Rey();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosCaballos() {
		
		Carta carta1 = new Tres();
		Carta carta2 = new Caballo();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosSotas() {
		
		Carta carta1 = new Tres();
		Carta carta2 = new Sota();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosSietesFalsos() {
		
		Carta carta1 = new Tres();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosSeis() {
		
		Carta carta1 = new Tres();
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosCinco() {
		
		Carta carta1 = new Tres();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testTresGanaALosCuatro() {
		
		Carta carta1 = new Tres();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Dos
	
	@Test
	public void testDosGanaALosUnosFalsos() {
		
		Carta carta1 = new Dos();
		Carta carta2 = new UnoDeOro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosReyes() {
		
		Carta carta1 = new Dos();
		Carta carta2 = new Rey();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosCaballos() {
		
		Carta carta1 = new Dos();
		Carta carta2 = new Caballo();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosSotas() {
		
		Carta carta1 = new Dos();
		Carta carta2 = new Sota();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosSietesFalsos() {
		
		Carta carta1 = new Dos();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosSeis() {
		
		Carta carta1 = new Dos();
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosCinco() {
		
		Carta carta1 = new Dos();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testDosGanaALosCuatro() {
		
		Carta carta1 = new Dos();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Unos Falsos
	
	@Test
	public void testUnosFalsosGanaALosReyes() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new Rey();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnosFalsosGanaALosCaballos() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new Caballo();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnosFalsosGanaALosSotas() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new Sota();
		
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
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnosFalsosGanaALosCinco() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testUnosFalsosGanaALosCuatro() {
		
		Carta carta1 = new UnoDeOro();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Rey
	
	@Test
	public void testReyGanaALosCaballos() {
		
		Carta carta1 = new Rey();
		Carta carta2 = new Caballo();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testReyGanaALosSotas() {
		
		Carta carta1 = new Rey();
		Carta carta2 = new Sota();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testReyGanaALosSietesFalsos() {
		
		Carta carta1 = new Rey();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testReyGanaALosSeis() {
		
		Carta carta1 = new Rey();
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testReyGanaALosCinco() {
		
		Carta carta1 = new Rey();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testReyDeOroGanaALosCuatro() {
		
		Carta carta1 = new Rey();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Caballo
	
	@Test
	public void testCaballoGanaALosSotas() {
		
		Carta carta1 = new Caballo();
		Carta carta2 = new Sota();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testCaballoGanaALosSietesFalsos() {
		
		Carta carta1 = new Caballo();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testCaballoGanaALosSeis() {
		
		Carta carta1 = new Caballo();
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testCaballoGanaALosCinco() {
		
		Carta carta1 = new Caballo();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testCaballoDeOroGanaALosCuatro() {
		
		Carta carta1 = new Caballo();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Sota
	
	@Test
	public void testSotaGanaALosSietesFalsos() {
		
		Carta carta1 = new Sota();
		Carta carta2 = new SieteDeCopa();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSotaGanaALosSeis() {
		
		Carta carta1 = new Sota();
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSotaGanaALosCinco() {
		
		Carta carta1 = new Sota();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSotaDeOroGanaALosCuatro() {
		
		Carta carta1 = new Sota();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Sietes Falsos
	
	@Test
	public void testSieteFalsosGanaALosSeis() {
		
		Carta carta1 = new SieteDeCopa();
		Carta carta2 = new Seis();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteFalsosGanaALosCinco() {
		
		Carta carta1 = new SieteDeCopa();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSieteFalsosGanaALosCuatro() {
		
		Carta carta1 = new SieteDeCopa();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Seis
	
	@Test
	public void testSeisGanaALosCinco() {
		
		Carta carta1 = new Seis();
		Carta carta2 = new Cinco();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	@Test
	public void testSeisGanaALosCuatro() {
		
		Carta carta1 = new Seis();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
	
	// Cinco
	
	@Test
	public void testCincoGanaALosCuatro() {
		
		Carta carta1 = new Cinco();
		Carta carta2 = new Cuatro();
		
		Assert.assertTrue(carta1.jugarContra(carta2) == carta1);
	}
}
