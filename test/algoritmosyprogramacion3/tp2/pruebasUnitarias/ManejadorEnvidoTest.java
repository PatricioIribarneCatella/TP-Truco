package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import java.util.LinkedList;
import java.util.List;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Canto;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.CincoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeOro;
import algoritmosyprogramacion3.tp2.modelo.DosDeBasto;
import algoritmosyprogramacion3.tp2.modelo.DosDeOro;
import algoritmosyprogramacion3.tp2.modelo.Envido;
import algoritmosyprogramacion3.tp2.modelo.Equipo;
import algoritmosyprogramacion3.tp2.modelo.Jugable;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.ManejadorEnvidos;
import algoritmosyprogramacion3.tp2.modelo.RealEnvido;
import algoritmosyprogramacion3.tp2.modelo.SeisDeCopa;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.TresDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class ManejadorEnvidoTest {

	//private static final Carta UnoDeBasto = null;
	private Jugable jugador1;
	private Jugable jugador2;
	private Jugable jugador3;
	private Jugable jugador4;
	private Carta unoDeEspada;
	private Carta sieteDeEspada;
	private Carta cincoDeEspada;
	private Carta unoDeBasto;
	private Carta sieteDeBasto;
	private Carta dosDeBasto;
	private Carta unoDeOro;
	private Carta dosDeOro;
	private Carta cuatroDeOro;
	private Carta unoDeCopa;
	private Carta seisDeCopa;
	private Carta tresDeCopa;
	private List<Jugable> jugadores;
	
	private ManejadorEnvidos manejadorEnvidos;
	
	@Before
	public void setup(){

	    jugadores = new LinkedList<Jugable>(); 	
		jugador1 = new Jugador("1");
		jugador2 = new Jugador("2");
		jugador3 = new Jugador("3");
		jugador4 = new Jugador("4");
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);
		
		Equipo equipo1 = new Equipo();
		equipo1.agregarIntegrante(jugador1);
		equipo1.agregarIntegrante(jugador3);
		Equipo equipo2 = new Equipo();
		equipo2.agregarIntegrante(jugador2);
		equipo2.agregarIntegrante(jugador4);
		
		jugador1.setEquipo(equipo1);
		jugador2.setEquipo(equipo2);
		jugador3.setEquipo(equipo1);
		jugador4.setEquipo(equipo2);
		
		
        unoDeEspada = new UnoDeEspada();
	    sieteDeEspada = new SieteDeEspada();
		cincoDeEspada =  new CincoDeEspada();
		unoDeBasto = new UnoDeBasto();
		sieteDeBasto = new SieteDeBasto();
		dosDeBasto= new DosDeBasto();
		unoDeOro = new UnoDeOro();
		dosDeOro = new DosDeOro();
		cuatroDeOro = new CuatroDeOro();
		unoDeCopa = new UnoDeCopa();
		seisDeCopa =  new SeisDeCopa();
		tresDeCopa =  new TresDeCopa();
		
		jugador1.recibirCarta(unoDeBasto); 
		jugador1.recibirCarta(sieteDeBasto);
		jugador1.recibirCarta(dosDeBasto); //el jugador 1 tiene 29 puntos de envido
		jugador2.recibirCarta(unoDeEspada);
		jugador2.recibirCarta(sieteDeEspada);
		jugador2.recibirCarta(cincoDeEspada);// el jugador 2 tiene 32 puntos de envido
		jugador3.recibirCarta(unoDeOro);
		jugador3.recibirCarta(dosDeOro);
		jugador3.recibirCarta(cuatroDeOro);// el jugador 3 tiene 26 puntos de envido
		jugador4.recibirCarta(unoDeCopa);
		jugador4.recibirCarta(seisDeCopa);
		jugador4.recibirCarta(tresDeCopa);// el jugador 4 tiene 29 de envido
	
		unoDeEspada.entregada();
	    sieteDeEspada.entregada();
		cincoDeEspada.entregada();
		unoDeBasto.entregada();
		sieteDeBasto.entregada();
		dosDeBasto.entregada();
		unoDeOro.entregada();
		dosDeOro.entregada();
		cuatroDeOro.entregada();
		unoDeCopa.entregada();
		seisDeCopa.entregada();
		tresDeCopa.entregada();
		
		manejadorEnvidos = new ManejadorEnvidos();
		manejadorEnvidos.setJugadoresEnfrentados(jugadores);
	}
	
	@Test
	public void testJugadorDosGanaElEnvido() {

           Jugable jugadorGanador = this.manejadorEnvidos.getGanador();
           Assert.assertTrue(jugadorGanador == jugador2);
		
	}
	
	@Test
	public void testObtenerElPuntajeDelGanadorDevuelveElPuntajeEsperado() {

           int puntajeGanador = this.manejadorEnvidos.getPuntajeGanador();
           Assert.assertTrue(puntajeGanador == 32);	
	}
	
	@Test
	public void calculoDePuntajesAcumuladosConUnSoloEnvido(){
		
		Canto envido = new Envido();
		
		this.manejadorEnvidos.concatenarCanto(envido);
		
		this.manejadorEnvidos.getGanador();
		
		Assert.assertTrue(this.manejadorEnvidos.calcularPuntajeAcumulado() == 2);
		Assert.assertTrue(this.manejadorEnvidos.calcularPuntajeAcumuladoPorRechazo() == 1);
	}
	
	
	@Test
	public void calculoDePuntajesAcumuladosConDosEnvidos(){
		
		Canto envido = new Envido();
		// es probable que haya que instanciar otro envido diferente
		this.manejadorEnvidos.concatenarCanto(envido);
		this.manejadorEnvidos.concatenarCanto(envido);
		
		this.manejadorEnvidos.getGanador();
		
		Assert.assertTrue(this.manejadorEnvidos.calcularPuntajeAcumulado() == 4);
		Assert.assertTrue(this.manejadorEnvidos.calcularPuntajeAcumuladoPorRechazo() == 2);
	}
	
	
	@Test
	public void calculoDePuntajesAcumuladosConTresEnvidos(){
		
		Canto envido = new Envido();
		// es probable que haya que instanciar otro envido diferente
		this.manejadorEnvidos.concatenarCanto(envido);
		this.manejadorEnvidos.concatenarCanto(envido);
		this.manejadorEnvidos.concatenarCanto(envido);
		
		this.manejadorEnvidos.getGanador();
		
		Assert.assertTrue(this.manejadorEnvidos.calcularPuntajeAcumulado() == 6);
		Assert.assertTrue(this.manejadorEnvidos.calcularPuntajeAcumuladoPorRechazo() == 3);
	}
	
	@Test
	public void calculoDePuntajesAcumuladosConRealEnvido(){
		
		Canto realEnvido = new RealEnvido();
		
		this.manejadorEnvidos.concatenarCanto(realEnvido);
		
		this.manejadorEnvidos.getGanador();
		
		Assert.assertTrue(this.manejadorEnvidos.calcularPuntajeAcumulado() == 3);
		Assert.assertTrue(this.manejadorEnvidos.calcularPuntajeAcumuladoPorRechazo() == 1);
	}
	
	@Test
	public void calculoDePuntajesAcumuladosConEnvidoYRealEnvido(){
		
		Canto envido = new Envido();
		Canto realEnvido = new RealEnvido();
		
		this.manejadorEnvidos.concatenarCanto(envido);
		this.manejadorEnvidos.concatenarCanto(envido);
		this.manejadorEnvidos.concatenarCanto(envido);
		this.manejadorEnvidos.concatenarCanto(realEnvido);
		
		this.manejadorEnvidos.getGanador();
		
		Assert.assertTrue(this.manejadorEnvidos.calcularPuntajeAcumulado() == 9);
		Assert.assertTrue(this.manejadorEnvidos.calcularPuntajeAcumuladoPorRechazo() == 4);
	}
}
