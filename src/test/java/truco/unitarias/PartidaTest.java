package truco.unitarias;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import truco.excepciones.AccionInvalidaException;
import truco.excepciones.CantidadDeEnvidosMaximosSuperadaException;
import truco.modelo.Partida;
import truco.modelo.PartidaRondaSinFlor;

public class PartidaTest {

	private Partida partida;
	private String jugador1;
	private String jugador2;
	
	@Before
	public void setUp() {
		
		this.jugador1 = "Juan";
		this.jugador2 = "Pedro";
		this.partida = new PartidaRondaSinFlor("partida1", Arrays.asList(this.jugador1), Arrays.asList(this.jugador2));	
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
