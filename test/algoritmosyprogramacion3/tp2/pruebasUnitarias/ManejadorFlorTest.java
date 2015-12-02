package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Canto;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.CincoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.CincoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeOro;
import algoritmosyprogramacion3.tp2.modelo.DosDeBasto;
import algoritmosyprogramacion3.tp2.modelo.DosDeOro;
import algoritmosyprogramacion3.tp2.modelo.Equipo;
import algoritmosyprogramacion3.tp2.modelo.Flor;
import algoritmosyprogramacion3.tp2.modelo.Jugable;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.ManejadorFlor;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeCopa;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class ManejadorFlorTest {

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
		cincoDeEspada =  new CincoDeEspada();
		unoDeBasto = new UnoDeBasto();
		sieteDeBasto = new SieteDeBasto();
		dosDeBasto= new DosDeBasto();
		unoDeOro = new UnoDeOro();
		dosDeOro = new DosDeOro();
		cuatroDeOro = new CuatroDeOro();
		unoDeCopa = new UnoDeCopa();
		cincoDeCopa =  new CincoDeCopa();
		sieteDeCopa =  new SieteDeCopa();
		
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
		cincoDeCopa.entregada();
		sieteDeCopa.entregada();
		
		manejadorFlor = new ManejadorFlor();
		manejadorFlor.setJugadoresEnfrentados(jugadores);
	}
	
	@Test
	public void testJugadorDosGanaElflor() {

           Jugable jugadorGanador = this.manejadorFlor.getGanador();
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
		
		this.manejadorFlor.getGanador();
		
		Assert.assertTrue(this.manejadorFlor.getPuntajeAEntregar() == 3);
		Assert.assertTrue(this.manejadorFlor.calcularPuntajeAcumuladoPorRechazo() == 3);
	}
	
	@Test
	public void calculoDePuntajesAcumuladosConDosFlores(){ // seria el caso de contraflor
		
		Canto flor = new Flor();

		this.manejadorFlor.florCantada(flor);
		this.manejadorFlor.florCantada(flor);
		
		this.manejadorFlor.getGanador();
		
		Assert.assertTrue(this.manejadorFlor.getPuntajeAEntregar() == 6);
		Assert.assertTrue(this.manejadorFlor.calcularPuntajeAcumuladoPorRechazo() == 6);
	}
	
	

}
