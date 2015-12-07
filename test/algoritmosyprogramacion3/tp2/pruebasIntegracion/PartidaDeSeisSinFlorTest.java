package algoritmosyprogramacion3.tp2.pruebasIntegracion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.PartidaSinFlorException;
import algoritmosyprogramacion3.tp2.excepciones.TurnoParaTomarDecisionEquivocadoException;
import algoritmosyprogramacion3.tp2.modelo.Caballo;
import algoritmosyprogramacion3.tp2.modelo.Cinco;
import algoritmosyprogramacion3.tp2.modelo.Cuatro;
import algoritmosyprogramacion3.tp2.modelo.Dos;
import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.modelo.Palo;
import algoritmosyprogramacion3.tp2.modelo.Rey;
import algoritmosyprogramacion3.tp2.modelo.Seis;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.Tres;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class PartidaDeSeisSinFlorTest {

	private JuegoTruco juego;
	private List<String> jugadoresEquipo1;
	private List<String> jugadoresEquipo2;
		
	@Before
	public void setUp() {
		
		this.jugadoresEquipo1 = new LinkedList<String>();
		this.jugadoresEquipo2 = new LinkedList<String>();
		this.jugadoresEquipo1.add("Juan");
		this.jugadoresEquipo1.add("Patricio");
		this.jugadoresEquipo1.add("Jorge");
		this.jugadoresEquipo2.add("Pedro");
		this.jugadoresEquipo2.add("Santiago");
		this.jugadoresEquipo2.add("Pepe");			
		
		juego = new JuegoTruco();
		juego.nuevaMesaDeSeisSinFlor("mesa1",jugadoresEquipo1,jugadoresEquipo2);
		juego.repartirCartas(Arrays.asList(new UnoDeEspada(),new Dos(Palo.BASTO),new Caballo(Palo.ESPADA),new UnoDeBasto(),new Dos(Palo.ORO),new SieteDeBasto(),new SieteDeEspada(),new UnoDeOro(),new Seis(Palo.COPA),new Tres(Palo.COPA),new UnoDeCopa(),new Cinco(Palo.ESPADA),new Tres(Palo.ESPADA),new Rey(Palo.BASTO),new Cuatro(Palo.ORO),new Dos(Palo.ESPADA),new Rey(Palo.ORO),new Cuatro(Palo.COPA)));
		                                                    
	}
	
	@Test (expected = PartidaSinFlorException.class)
	public void testCantarFlorNoDeberiaSerPosible() {
		
		juego.cantarFlorPorJugador("Juan");
	}
	
	@Test (expected = TurnoParaTomarDecisionEquivocadoException.class)
	public void testMismoJugadorCantaTrucoYAceptaNoDeberiaSerPosible() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		juego.aceptarTrucoPorJugador("Juan");
	}
	
	@Test (expected = TurnoParaTomarDecisionEquivocadoException.class)
	public void testMismoJugadorCantaEnvidoYAceptaNoDeberiaSerPosible() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		juego.aceptarVarianteEnvidoPorJugador("Juan");
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testNoDeberiaSerPosibleCantarReTrucoCuandoEmpiezaLaPartida() {
		
		juego.cantarReTrucoPorJugador("Juan");
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testNoDeberiaSerPosibleCantarValeCuatroCuandoEmpiezaLaPartida() {
		
		juego.cantarValeCuatroPorJugador("Juan");
	}
	
	@Test (expected = TurnoParaTomarDecisionEquivocadoException.class)
	public void testMismoJugadorCantaTrucoYReTruco() {
	
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		juego.cantarReTrucoPorJugador("Juan");
	}
	
	@Test
	public void testSeCantaTrucoYNoSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("1"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("1"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("1"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("0"));
	}
	
	@Test
	public void testSeCantaEnvidoNoSeLoQuiereSeCantaTrucoNoSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("0"));
	}
	
	@Test
	public void testSeCantaTrucoYSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarTrucoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Patricio"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Santiago"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Jorge"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pepe"));
		
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Patricio"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Santiago")); 
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Jorge"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pepe")); 
		// parda pero el equipo 1 hizo primera 
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("0"));

	}
	
	@Test
	public void testSeCantaTrucoSeCantaReTrucoSeLoQuiere() {
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarTrucoPorJugador("Pedro"));
		
		
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Patricio"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Santiago"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Jorge"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pepe"));//empatan la primera
	
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarTrucoPorJugador("Patricio"));
		

		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Patricio"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Santiago"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Jorge"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pepe"));//gana el equipo 1
		
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("0"));
	
	}
	
	@Test
	public void testSeCantaTrucoSeCantaReTrucoSeCantaValeCuatroSeLoQuiere() {

		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Patricio"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Santiago"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Jorge"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Pepe"));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Patricio"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Santiago"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Jorge"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pepe"));//equipo 2 hace primera
		
		
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Patricio"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Santiago"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Jorge"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pepe"));//equipo 2 gana ronda
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("4"));
	}
	
	@Test
	public void testSeCantaEnvidoSeLoAcepta() {
		
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Juan"));
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Patricio"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("2"));
		
		Assert.assertTrue(juego.mostrarPuntosEnvido("Juan").equals("21"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pedro").equals("28"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Patricio").equals("7"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Santiago").equals("24"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Jorge").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosEnvido("Pepe").equals("4"));
	}
	
	@Test
	public void testSeCantaEnvidoDosVecesSeguidasSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Patricio"));
		
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("4"));
		
	}
	
	@Test
	public void testSeCantaEnvidoTresVecesSeguidasSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Patricio"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Santiago"));
	
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("6"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("6"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("6"));	
		
	}
	
	@Test
	public void testSeCantaRealEnvidoSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarRealEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("3"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("3"));
		
	}
	
	@Test
	public void testSeCantaEnvidoTresVecesSeguidasYRealEnvidoSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Patricio"));
		Assert.assertTrue(juego.cantarRealEnvidoPorJugador("Santiago"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Jorge"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("9"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("9"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("9"));
		
	}
	
	@Test
	public void testSeCantaFaltaEnvidoSeLoAcepta() {
		
		Assert.assertTrue(juego.cantarFaltaEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.aceptarVarianteEnvidoPorJugador("Pedro"));
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("30"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("30"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("30"));
	}
	
	
	@Test
	public void testRondaComunYRondaPicaPica(){
		
		
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Juan"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteEnvidoPorJugador("Patricio"));
		
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("2"));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pedro"));
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Patricio"));
		Assert.assertTrue(juego.cantarReTrucoPorJugador("Santiago"));
		Assert.assertTrue(juego.cantarValeCuatroPorJugador("Jorge"));
		Assert.assertTrue(juego.aceptarValeCuatroPorJugador("Pepe"));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Patricio"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Santiago"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Jorge"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pepe"));//equipo 2 hace primera
		
		
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Patricio"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Santiago"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Jorge"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pepe"));//equipo 2 gana ronda
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("6"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("6"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("6"));
		
		//Ahora arranca la rotacion pica pica
		//Pedro vs Jorge
		//Patricio vs Pepe
		//Santiago vs Juan 
		juego.repartirCartas(Arrays.asList(new UnoDeBasto(),new Dos(Palo.ORO),new SieteDeBasto(),new SieteDeEspada(),new UnoDeOro(),new Seis(Palo.COPA),new Tres(Palo.COPA),new UnoDeCopa(),new Cinco(Palo.ESPADA),new Tres(Palo.ESPADA),new Rey(Palo.BASTO),new Cuatro(Palo.ORO),new Dos(Palo.ESPADA),new Rey(Palo.ORO),new Cuatro(Palo.COPA),new UnoDeEspada(),new Dos(Palo.BASTO),new Caballo(Palo.ESPADA)));
		
		Assert.assertTrue(juego.jugarTercerCartaDeJugador("Pedro"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Jorge")); // gana jorge primera
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Pedro"));
		Assert.assertTrue(juego.rechazarVarianteTrucoPorJugador("Jorge"));
		
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("7"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("7"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("0"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("7"));
		
		
		/*Ahora juegan Patricio y Pepe*/
		
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Patricio"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Pepe"));//Patricio hace primera
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Patricio"));
		Assert.assertTrue(juego.aceptarTrucoPorJugador("Pepe"));
		
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Patricio"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Pepe"));//Patricio hace Segunda
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("7"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("7"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("2"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("7"));
		
		/*Ahora juegan Santiago y Juan*/
		
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Santiago"));
		Assert.assertTrue(juego.jugarPrimerCartaDeJugador("Juan"));//Juan hace primera
		
		Assert.assertTrue(juego.cantarTrucoPorJugador("Santiago"));
		Assert.assertTrue(juego.aceptarTrucoPorJugador("Juan"));
		

		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Santiago"));
		Assert.assertTrue(juego.jugarSegundaCartaDeJugador("Juan"));//Juan hace Segunda
		
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Juan").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pedro").equals("7"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Patricio").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Santiago").equals("7"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Jorge").equals("4"));
		Assert.assertTrue(juego.mostrarPuntosDeJugador("Pepe").equals("7"));
		
		
		/*Ronda Comun de nuevo*/
		/*
		juego.repartirCartas(Arrays.asList(new SieteDeEspada(),new UnoDeOro(),new Seis(Palo.COPA),new Tres(Palo.COPA),new UnoDeCopa(),new Cinco(Palo.ESPADA),new Tres(Palo.ESPADA),new Rey(Palo.BASTO),new Cuatro(Palo.ORO),new Dos(Palo.ESPADA),new Rey(Palo.ORO),new Cuatro(Palo.COPA),new UnoDeEspada(),new Dos(Palo.BASTO),new Caballo(Palo.ESPADA),new UnoDeBasto(),new Dos(Palo.ORO),new SieteDeBasto()));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Patricio"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Santiago"));
		Assert.assertTrue(juego.cantarEnvidoPorJugador("Jorge"));
		Assert.assertTrue(juego.cantarRealEnvidoPorJugador("Pepe"));
		Assert.assertTrue(juego.cantarFaltaEnvidoPorJugador("Juan")); 
		*/
		
	}
		
}
