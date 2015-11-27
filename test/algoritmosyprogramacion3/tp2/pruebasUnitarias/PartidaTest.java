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
		this.partida = new Partida(moderador);	
		this.partida.iniciarPartida();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnTrucoCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarTruco();
		partida.jugarCarta();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnReTrucoCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarTruco();
		partida.cantarReTruco();
		partida.jugarCarta();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaValeCuatroCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarTruco();
		partida.cantarReTruco();
		partida.cantarValeCuatro();
		partida.jugarCarta();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnReTrucoCantadoNoSePuedeCantarTrucoNuevamente() {
		
		partida.cantarTruco();
		partida.cantarReTruco();
		partida.cantarTruco();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnValeCuatroCantadoNoSePuedeCantarTrucoNuevamente() {
		
		partida.cantarTruco();
		partida.cantarReTruco();
		partida.cantarValeCuatro();
		partida.cantarTruco();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnEnvidoCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarEnvido();
		partida.jugarCarta();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnRealEnvidoCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarEnvido();
		partida.cantarRealEnvido();
		partida.jugarCarta();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnFaltaEnvidoCantadoNoSePuedeJugarUnaCarta() {
		
		partida.cantarEnvido();
		partida.cantarRealEnvido();
		partida.cantarFaltaEnvido();
		partida.jugarCarta();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnRealEnvidoCantadoNoSePuedeCantaEnvidoNuevamente() {
		
		partida.cantarEnvido();
		partida.cantarRealEnvido();
		partida.cantarEnvido();
	}
	
	@Test (expected = AccionInvalidaException.class)
	public void testPartidaSiSeEstaEnFaltaEnvidoCantadoNoSePuedeCantaEnvidoNuevamente() {
		
		partida.cantarEnvido();
		partida.cantarRealEnvido();
		partida.cantarFaltaEnvido();
		partida.cantarEnvido();
	}
	
	@Test (expected = CantidadDeEnvidosMaximosSuperadaException.class)
	public void testPartidaCuandoSeCantanMasDeTresEnvidosDeberiaLanzarExcepcion() {
		
		partida.cantarEnvido();
		partida.cantarEnvido();
		partida.cantarEnvido();
		partida.cantarEnvido();
	}
}
