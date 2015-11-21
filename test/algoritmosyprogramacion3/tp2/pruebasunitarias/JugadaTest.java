package algoritmosyprogramacion3.tp2.pruebasunitarias;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.CincoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.Jugable;
import algoritmosyprogramacion3.tp2.modelo.Jugada;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.Mesa;
import algoritmosyprogramacion3.tp2.modelo.Moderador;
import algoritmosyprogramacion3.tp2.modelo.RotacionStrategy;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionEnRonda;
import algoritmosyprogramacion3.tp2.modelo.TresDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class JugadaTest {

	private Jugador jugador1;
	private Jugador jugador2;
	private Carta unoDeEspada;
	private Carta tresDeBasto;
	private Carta unoDeOro;
	private Carta cincoDeCopa;
	private Carta unoDeBasto;
	private Carta siteDeEspada;
	private Mesa mesa;
	private Moderador moderador;
	private RotacionStrategy rotacionEnRonda;
	
	@Before
	public void setUp() {
		
		this.jugador1 = new Jugador("Pedro");
		this.cincoDeCopa = new CincoDeCopa();
		this.siteDeEspada = new SieteDeEspada();
		this.tresDeBasto = new TresDeBasto();
		this.jugador1.recibirCarta(cincoDeCopa);
		this.jugador1.recibirCarta(siteDeEspada);
		this.jugador1.recibirCarta(tresDeBasto);
		
		this.jugador2 = new Jugador("Juan");
		this.unoDeBasto = new UnoDeBasto();
		this.unoDeEspada = new UnoDeEspada();
		this.unoDeOro = new UnoDeOro();
		this.jugador2.recibirCarta(unoDeBasto);
		this.jugador2.recibirCarta(unoDeEspada);
		this.jugador2.recibirCarta(unoDeOro);
		
		this.mesa = new Mesa(Arrays.asList(this.jugador1, this.jugador2), false);
		this.rotacionEnRonda = new StrategyRotacionEnRonda(this.mesa.getJugadores());
		this.moderador = new Moderador(mesa);
		this.moderador.setRotacionStrategy(rotacionEnRonda);
		this.jugador1.setModerador(moderador);
		this.jugador2.setModerador(moderador);
		this.jugador1.setMesa(this.mesa);
		this.jugador2.setMesa(this.mesa);
		
	}
	
	@Test
	public void testConforntarDosJugadores() {
		
		this.jugador1.jugarPrimerCarta();
		this.jugador2.jugarSegundaCarta();
		
		Jugada jugada = new Jugada();
		
		Jugable jugadorGanador = jugada.confrontar(jugador1, jugador2);
		
		Assert.assertTrue(jugadorGanador == this.jugador2);
	}
}
