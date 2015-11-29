package algoritmosyprogramacion3.tp2.pruebasUnitarias;

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
import algoritmosyprogramacion3.tp2.modelo.MesaSinFlor;
import algoritmosyprogramacion3.tp2.modelo.Moderador;
import algoritmosyprogramacion3.tp2.modelo.Resultado;
import algoritmosyprogramacion3.tp2.modelo.RotacionStrategy;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionEnRonda;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class JugadaTest {

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
		
		this.jugador1 = new Jugador("Pedro");
		this.cincoDeCopa = new CincoDeCopa();
		this.sieteDeEspada = new SieteDeEspada();
		this.unoDeCopa = new UnoDeCopa();
		this.jugador1.recibirCarta(cincoDeCopa);
		this.jugador1.recibirCarta(sieteDeEspada);
		this.jugador1.recibirCarta(unoDeCopa);
		
		this.jugador2 = new Jugador("Juan");
		this.unoDeBasto = new UnoDeBasto();
		this.unoDeEspada = new UnoDeEspada();
		this.unoDeOro = new UnoDeOro();
		this.jugador2.recibirCarta(unoDeBasto);
		this.jugador2.recibirCarta(unoDeEspada);
		this.jugador2.recibirCarta(unoDeOro);
		
		this.mesa = new MesaSinFlor(Arrays.asList(this.jugador1, this.jugador2));
		this.rotacionEnRonda = new StrategyRotacionEnRonda(this.mesa.getJugadores());
		this.moderador = new Moderador(mesa);
		this.moderador.setRotacionStrategy(rotacionEnRonda);
		this.jugador1.setModerador(moderador);
		this.jugador2.setModerador(moderador);
		this.jugador1.setMesa(this.mesa);
		this.jugador2.setMesa(this.mesa);
		
	    cincoDeCopa.entregada();
		sieteDeEspada.entregada();
		unoDeBasto.entregada();
		unoDeEspada.entregada();
		unoDeOro.entregada();
		unoDeCopa.entregada();
		
	}
	
	@Test
	public void testConforntarDosJugadoresHayUnGanador() {
		
		jugador1.jugarPrimerCarta();
		jugador2.jugarSegundaCarta();
		
		Jugada jugada = new Jugada();
		
		Resultado resultado = jugada.confrontar(jugador1, jugador2);
		
		Assert.assertTrue(resultado.huboGanador());
		Assert.assertTrue(resultado.getJugadorGandador() == this.jugador2);
	}
	
	@Test
	public void testConforntarDosJugadoresHayUnEmpate() {
		
		jugador1.jugarTercerCarta();
		jugador2.jugarTercerCarta();
		
		Jugada jugada = new Jugada();
		
		Resultado resultado = jugada.confrontar(jugador1, jugador2);
		
		Assert.assertFalse(resultado.huboGanador());
	}
}
