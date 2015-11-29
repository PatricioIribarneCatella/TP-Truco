package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.excepciones.AccionInvalidaException;
import algoritmosyprogramacion3.tp2.excepciones.CantidadDeEnvidosMaximosSuperadaException;
import algoritmosyprogramacion3.tp2.modelo.Jugable;
import algoritmosyprogramacion3.tp2.modelo.Jugador;
import algoritmosyprogramacion3.tp2.modelo.Mesa;
import algoritmosyprogramacion3.tp2.modelo.MesaSinFlor;
import algoritmosyprogramacion3.tp2.modelo.Moderador;
import algoritmosyprogramacion3.tp2.modelo.Partida;
import algoritmosyprogramacion3.tp2.modelo.StrategyRotacionEnRonda;

public class PartidaTest {

	private Partida partida;
	private Jugable jugador1;
	private Jugable jugador2;
	
	@Before
	public void setUp() {
		
		this.jugador1 = new Jugador("Juan");
		this.jugador2 = new Jugador("Pedro");
		
		Mesa mesa = new MesaSinFlor(Arrays.asList(this.jugador1, this.jugador2));
		Moderador moderador = new Moderador(mesa);
		moderador.setRotacionStrategy(new StrategyRotacionEnRonda(mesa.getJugadores()));
		this.partida = new Partida(moderador);	
		this.partida.iniciarPartida();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnTrucoCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarTruco(jugador1);
		partida.jugarPrimerCartaJugador(jugador1);
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnReTrucoCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarTruco(jugador1);
		partida.cantarReTruco(jugador2);
		partida.jugarPrimerCartaJugador(jugador1);
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaValeCuatroCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarTruco(jugador1);
		partida.cantarReTruco(jugador2);
		partida.cantarValeCuatro(jugador1);
		partida.jugarPrimerCartaJugador(jugador1);
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnReTrucoCantadoNoSePuedeCantarTrucoNuevamente() {
		
		partida.cantarTruco(jugador1);
		partida.cantarReTruco(jugador2);
		partida.cantarTruco(jugador1);
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnValeCuatroCantadoNoSePuedeCantarTrucoNuevamente() {
		
		partida.cantarTruco(jugador1);
		partida.cantarReTruco(jugador2);
		partida.cantarValeCuatro(jugador1);
		partida.cantarTruco(jugador2);
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnEnvidoCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarEnvido(jugador1);
		partida.jugarPrimerCartaJugador(jugador1);
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnRealEnvidoCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarEnvido(jugador1);
		partida.cantarRealEnvido(jugador2);
		partida.jugarPrimerCartaJugador(jugador1);
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnFaltaEnvidoCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarEnvido(jugador1);
		partida.cantarRealEnvido(jugador2);
		partida.cantarFaltaEnvido(jugador1);
		partida.jugarPrimerCartaJugador(jugador1);
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnRealEnvidoCantadoNoSePuedeCantaEnvidoNuevamente() {
		
		partida.cantarEnvido(jugador1);
		partida.cantarRealEnvido(jugador2);
		partida.cantarEnvido(jugador1);
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnFaltaEnvidoCantadoNoSePuedeCantaEnvidoNuevamente() {
		
		partida.cantarEnvido(jugador1);
		partida.cantarRealEnvido(jugador2);
		partida.cantarFaltaEnvido(jugador1);
		partida.cantarEnvido(jugador2);
	}
	
	@Test (expected = CantidadDeEnvidosMaximosSuperadaException.class)
	public void testPartidaCuandoSeCantanMasDeTresEnvidosDeberiaLanzarExcepcion() {
		
		partida.cantarEnvido(jugador1);
		partida.cantarEnvido(jugador2);
		partida.cantarEnvido(jugador1);
		partida.cantarEnvido(jugador2);
	}
}
