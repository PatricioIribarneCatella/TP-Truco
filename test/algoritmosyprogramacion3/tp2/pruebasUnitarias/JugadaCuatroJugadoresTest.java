package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.CincoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.CincoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.DosDeEspada;
import algoritmosyprogramacion3.tp2.modelo.Jugable;
import algoritmosyprogramacion3.tp2.modelo.Jugada;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.Mesa;
import algoritmosyprogramacion3.tp2.modelo.MesaSinFlor;
import algoritmosyprogramacion3.tp2.modelo.Moderador;
import algoritmosyprogramacion3.tp2.modelo.Resultado;
import algoritmosyprogramacion3.tp2.modelo.ReyDeBasto;
import algoritmosyprogramacion3.tp2.modelo.ReyDeCopa;
import algoritmosyprogramacion3.tp2.modelo.RotacionStrategy;
import algoritmosyprogramacion3.tp2.modelo.SeisDeEspada;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionEnRonda;
import algoritmosyprogramacion3.tp2.modelo.TresDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

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
		
		this.jugador3 = new Jugador("Carlos");
		this.reyDeCopa = new ReyDeCopa();
		this.seisDeEspada = new SeisDeEspada();
		this.dosDeEspada = new DosDeEspada();
		this.jugador3.recibirCarta(reyDeCopa);
		this.jugador3.recibirCarta(seisDeEspada);
		this.jugador3.recibirCarta(dosDeEspada);
		
		this.jugador4 = new Jugador("Raul");
		this.reyDeBasto = new ReyDeBasto();
		this.cincoDeEspada = new CincoDeEspada();
		this.tresDeEspada = new TresDeEspada();
		this.jugador4.recibirCarta(reyDeBasto);
		this.jugador4.recibirCarta(cincoDeEspada);
		this.jugador4.recibirCarta(tresDeEspada);
		
		this.mesa = new MesaSinFlor(Arrays.asList(this.jugador1, this.jugador2, this.jugador3, this.jugador4));
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
		
		cincoDeCopa.entregada();
		sieteDeEspada.entregada();
		unoDeCopa.entregada();
		unoDeBasto.entregada();
		unoDeEspada.entregada();
		unoDeOro.entregada();
		reyDeCopa.entregada();
		seisDeEspada.entregada();
		dosDeEspada.entregada();
		reyDeBasto.entregada();
		cincoDeEspada.entregada();
		tresDeEspada.entregada();
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
		Assert.assertTrue(resultado.getJugadorGandador() == this.jugador2);
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
