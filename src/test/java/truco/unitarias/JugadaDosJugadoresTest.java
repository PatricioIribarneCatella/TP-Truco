package truco.unitarias;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import truco.modelo.Carta;
import truco.modelo.Cinco;
import truco.modelo.EnMano;
import truco.modelo.Jugable;
import truco.modelo.Jugada;
import truco.modelo.Jugador;
import truco.modelo.Mesa;
import truco.modelo.Moderador;
import truco.modelo.Palo;
import truco.modelo.Resultado;
import truco.modelo.RotacionStrategy;
import truco.modelo.SieteDeEspada;
import truco.modelo.StrategyRotacionEnRonda;
import truco.modelo.UnoDeBasto;
import truco.modelo.UnoDeCopa;
import truco.modelo.UnoDeEspada;
import truco.modelo.UnoDeOro;

public class JugadaDosJugadoresTest {

	private Jugable jugador1;
	private Jugable jugador2;
	private Carta unoDeEspada;
	private Carta unoDeCopa;
	private Carta unoDeOro;
	private Carta cincoDeCopa;
	private Carta unoDeBasto;
	private Carta sieteDeEspada;
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
		
		this.mesa = new Mesa(Arrays.asList(this.jugador1, this.jugador2));
		this.rotacionEnRonda = new StrategyRotacionEnRonda(this.mesa.getJugadores());
		this.moderador = new Moderador(mesa);
		this.moderador.setRotacionStrategy(rotacionEnRonda);
		this.jugador1.setModerador(moderador);
		this.jugador2.setModerador(moderador);
		this.jugador1.setMesa(this.mesa);
		this.jugador2.setMesa(this.mesa);
		
	    for (Carta carta : cartas) {
	    	carta.pasaAEstar(new EnMano());
	    }
	}
	
	@Test
	public void testConforntarDosJugadoresHayUnGanador() {
		
		jugador1.jugarPrimerCarta();
		jugador2.jugarSegundaCarta();
		
		Jugada jugada = new Jugada();
		
		Resultado resultado = jugada.confrontar(this.mesa.getJugadores());
		
		Assert.assertTrue(resultado.huboGanador());
		Assert.assertTrue(resultado.getJugadorGanador() == this.jugador2);
	}
	
	@Test
	public void testConforntarDosJugadoresHayUnEmpate() {
		
		jugador1.jugarTercerCarta();
		jugador2.jugarTercerCarta();
		
		Jugada jugada = new Jugada();
		
		Resultado resultado = jugada.confrontar(this.mesa.getJugadores());
		
		Assert.assertFalse(resultado.huboGanador());
	}
}
