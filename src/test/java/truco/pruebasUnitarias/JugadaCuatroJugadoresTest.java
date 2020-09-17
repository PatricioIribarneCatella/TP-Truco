package truco.pruebasUnitarias;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import truco.modelo.Carta;
import truco.modelo.Cinco;
import truco.modelo.Dos;
import truco.modelo.EnMano;
import truco.modelo.Jugable;
import truco.modelo.Jugada;
import truco.modelo.Jugador;
import truco.modelo.Mesa;
import truco.modelo.Moderador;
import truco.modelo.Palo;
import truco.modelo.Resultado;
import truco.modelo.Rey;
import truco.modelo.RotacionStrategy;
import truco.modelo.Seis;
import truco.modelo.SieteDeEspada;
import truco.modelo.StrategyRotacionEnRonda;
import truco.modelo.Tres;
import truco.modelo.UnoDeBasto;
import truco.modelo.UnoDeCopa;
import truco.modelo.UnoDeEspada;
import truco.modelo.UnoDeOro;

public class JugadaCuatroJugadoresTest {

	private Jugable jugador1;
	private Jugable jugador2;
	private Jugable jugador3;
	private Jugable jugador4;
	private Carta unoDeEspada;
	private Carta unoDeCopa;
	private Carta unoDeOro;
	private Carta unoDeBasto;
	private Carta cincoDeCopa;
	private Carta sieteDeEspada;
	private Carta reyDeCopa;
	private Carta seisDeEspada;
	private Carta dosDeEspada;
	private Carta reyDeBasto;
	private Carta cincoDeEspada;
	private Carta tresDeEspada;
	private Mesa mesa;
	private Moderador moderador;
	private RotacionStrategy rotacionEnRonda;
	
	@Before
	public void setUp() {
		
		List<Carta> cartas = new LinkedList<Carta>();
		
		this.jugador1 = new Jugador("Pedro");
		this.cincoDeCopa = new Cinco(Palo.COPA);
		this.sieteDeEspada = new SieteDeEspada();
		this.unoDeCopa = new UnoDeCopa();
		this.jugador1.recibirCarta(cincoDeCopa);
		this.jugador1.recibirCarta(sieteDeEspada);
		this.jugador1.recibirCarta(unoDeCopa);
		cartas.add(cincoDeCopa); cartas.add(sieteDeEspada); cartas.add(unoDeCopa);
		
		this.jugador2 = new Jugador("Juan");
		this.unoDeBasto = new UnoDeBasto();
		this.unoDeEspada = new UnoDeEspada();
		this.unoDeOro = new UnoDeOro();
		this.jugador2.recibirCarta(unoDeBasto);
		this.jugador2.recibirCarta(unoDeEspada);
		this.jugador2.recibirCarta(unoDeOro);
		cartas.add(unoDeBasto); cartas.add(unoDeEspada); cartas.add(unoDeOro);
		
		this.jugador3 = new Jugador("Carlos");
		this.reyDeCopa = new Rey(Palo.COPA);
		this.seisDeEspada = new Seis(Palo.ESPADA);
		this.dosDeEspada = new Dos(Palo.ESPADA);
		this.jugador3.recibirCarta(reyDeCopa);
		this.jugador3.recibirCarta(seisDeEspada);
		this.jugador3.recibirCarta(dosDeEspada);
		cartas.add(reyDeCopa); cartas.add(seisDeEspada); cartas.add(dosDeEspada);
		
		this.jugador4 = new Jugador("Raul");
		this.reyDeBasto = new Rey(Palo.BASTO);
		this.cincoDeEspada = new Cinco(Palo.ESPADA);
		this.tresDeEspada = new Tres(Palo.ESPADA);
		this.jugador4.recibirCarta(reyDeBasto);
		this.jugador4.recibirCarta(cincoDeEspada);
		this.jugador4.recibirCarta(tresDeEspada);
		cartas.add(reyDeBasto); cartas.add(cincoDeEspada); cartas.add(tresDeEspada);
		
		this.mesa = new Mesa(Arrays.asList(this.jugador1, this.jugador2, this.jugador3, this.jugador4));
		this.rotacionEnRonda = new StrategyRotacionEnRonda(this.mesa.getJugadores());
		this.moderador = new Moderador(mesa);
		this.moderador.setRotacionStrategy(rotacionEnRonda);
		this.jugador1.setModerador(moderador);
		this.jugador2.setModerador(moderador);
		this.jugador3.setModerador(moderador);
		this.jugador4.setModerador(moderador);
		this.jugador1.setMesa(this.mesa);
		this.jugador2.setMesa(this.mesa);
		this.jugador3.setMesa(mesa);
		this.jugador4.setMesa(mesa);
		
		for (Carta carta : cartas) {
			carta.pasaAEstar(new EnMano());
		}
	}
	
	@Test
	public void testConforntarDosJugadoresHayUnGanador() {
		
		jugador1.jugarPrimerCarta();
		jugador2.jugarSegundaCarta();
		jugador3.jugarTercerCarta();
		jugador4.jugarTercerCarta();
		
		Jugada jugada = new Jugada();
		
		Resultado resultado = jugada.confrontar(this.mesa.getJugadores());
		
		Assert.assertTrue(resultado.huboGanador());
		Assert.assertTrue(resultado.getJugadorGanador() == this.jugador2);
	}
	
	@Test
	public void testConforntarDosJugadoresHayUnEmpate() {
		
		jugador1.jugarTercerCarta();
		jugador2.jugarTercerCarta();
		jugador3.jugarSegundaCarta();
		jugador4.jugarPrimerCarta();
		
		Jugada jugada = new Jugada();
		
		Resultado resultado = jugada.confrontar(this.mesa.getJugadores());
		
		Assert.assertFalse(resultado.huboGanador());
	}
}
