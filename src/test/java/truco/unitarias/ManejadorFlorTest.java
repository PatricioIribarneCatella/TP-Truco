package truco.unitarias;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import truco.modelo.Canto;
import truco.modelo.Carta;
import truco.modelo.Cinco;
import truco.modelo.Cuatro;
import truco.modelo.Dos;
import truco.modelo.EnMano;
import truco.modelo.Equipo;
import truco.modelo.Flor;
import truco.modelo.Jugable;
import truco.modelo.Jugador;
import truco.modelo.ManejadorFlor;
import truco.modelo.Palo;
import truco.modelo.SieteDeBasto;
import truco.modelo.SieteDeCopa;
import truco.modelo.SieteDeEspada;
import truco.modelo.UnoDeBasto;
import truco.modelo.UnoDeCopa;
import truco.modelo.UnoDeEspada;
import truco.modelo.UnoDeOro;

public class ManejadorFlorTest {

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
	private Carta cincoDeCopa;
	private Carta sieteDeCopa;
	private List<Jugable> jugadores;
	
	private ManejadorFlor manejadorFlor;
	
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
		cincoDeEspada =  new Cinco(Palo.ESPADA);
		unoDeBasto = new UnoDeBasto();
		sieteDeBasto = new SieteDeBasto();
		dosDeBasto = new Dos(Palo.BASTO);
		unoDeOro = new UnoDeOro();
		dosDeOro = new Dos(Palo.ORO);
		cuatroDeOro = new Cuatro(Palo.ORO);
		unoDeCopa = new UnoDeCopa();
		cincoDeCopa =  new Cinco(Palo.COPA);
		sieteDeCopa =  new SieteDeCopa();
		
		List<Carta> cartas = Arrays.asList(unoDeEspada, sieteDeEspada, cincoDeEspada, unoDeBasto, sieteDeBasto, dosDeBasto, unoDeOro, dosDeOro, cuatroDeOro, unoDeCopa, cincoDeCopa, sieteDeCopa);

		
		jugador1.recibirCarta(unoDeBasto); 
		jugador1.recibirCarta(sieteDeBasto);
		jugador1.recibirCarta(dosDeBasto); //el jugador 1 tiene 30 puntos de flor
		jugador2.recibirCarta(unoDeEspada);
		jugador2.recibirCarta(sieteDeEspada);
		jugador2.recibirCarta(cincoDeEspada);// el jugador 2 tiene 33 puntos de flor pero esta mas cerca del mazo que el jugador 4
		jugador3.recibirCarta(unoDeOro);
		jugador3.recibirCarta(dosDeOro);
		jugador3.recibirCarta(cuatroDeOro);// el jugador 3 tiene 27 puntos de flor
		jugador4.recibirCarta(unoDeCopa);
		jugador4.recibirCarta(cincoDeCopa);
		jugador4.recibirCarta(sieteDeCopa);// el jugador 4 tiene 33 puntos de flor
	
		for(Carta carta : cartas) {
			carta.pasaAEstar(new EnMano());
		}
		
		manejadorFlor = new ManejadorFlor();
		manejadorFlor.setJugadoresEnfrentados(jugadores);
	}
	
	@Test
	public void testJugadorDosGanaElflor() {

           Jugable jugadorGanador = this.manejadorFlor.resolverFlor();
           Assert.assertTrue(jugadorGanador == jugador2);
		
	}
	
	@Test
	public void testObtenerElPuntajeDelGanadorDevuelveElPuntajeEsperado() {

           int puntajeGanador = this.manejadorFlor.getPuntajeGanador();
           Assert.assertTrue(puntajeGanador == 33);	
	}
	
	@Test
	public void calculoDePuntajesAcumuladosConUnaSolaflor(){
		
		
		this.manejadorFlor.florCantada(new Flor());
		
		this.manejadorFlor.resolverFlor();
		
		Assert.assertTrue(this.manejadorFlor.getPuntajeAEntregar() == 3);
		Assert.assertTrue(this.manejadorFlor.calcularPuntajeAcumuladoPorRechazo() == 3);
	}
	
	@Test
	public void calculoDePuntajesAcumuladosConDosFlores(){ // seria el caso de contraflor
		
		Canto flor = new Flor();

		this.manejadorFlor.florCantada(flor);
		this.manejadorFlor.florCantada(flor);
		
		this.manejadorFlor.resolverFlor();
		
		Assert.assertTrue(this.manejadorFlor.getPuntajeAEntregar() == 6);
		Assert.assertTrue(this.manejadorFlor.calcularPuntajeAcumuladoPorRechazo() == 6);
	}
	
	

}
