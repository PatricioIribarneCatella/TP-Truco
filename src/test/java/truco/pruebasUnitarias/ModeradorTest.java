package truco.pruebasUnitarias;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import truco.modelo.Jugable;
import truco.modelo.Jugador;
import truco.modelo.Mesa;
import truco.modelo.Moderador;
import truco.modelo.PartidaRondaSinFlor;
import truco.modelo.PartidaRondaYPicaPicaSinFlor;
import truco.modelo.RotacionStrategy;
import truco.modelo.StrategyRotacionEnRonda;
import truco.modelo.StrategyRotacionPicaPica;

public class ModeradorTest {

	private Mesa mesaDeDos;
	private Mesa mesaDeCuatro;
	private Mesa mesaPicaPica;
	private Jugable jugador1;
	private Jugable jugador2;
	private Jugable jugador3;
	private Jugable jugador4;
	private Jugable jugador5;
	private Jugable jugador6;
	private LinkedList<Jugable> jugadoresMesaDeDos;
	private LinkedList<Jugable> jugadoresMesaDeCuatro;
	private LinkedList<Jugable> jugadoresMesaDeSeis;
	private Moderador moderadorMesaDeDos;
	private Moderador moderadorMesaDeCuatro;
	private Moderador moderadorMesaDeSeis;
	private RotacionStrategy rotacionPicaPica;
	
	@Before
	public void setUp(){		
		jugador1 = new Jugador("1");
		jugador2 = new Jugador("2");
		jugador3 = new Jugador("3");
		jugador4 = new Jugador("4");
		jugador5 = new Jugador("5");
		jugador6 = new Jugador("6");
		
		jugadoresMesaDeDos = new LinkedList<Jugable>();
		jugadoresMesaDeCuatro = new LinkedList<Jugable>();
		jugadoresMesaDeSeis = new LinkedList<Jugable>();
		jugadoresMesaDeDos.add(jugador1);
		jugadoresMesaDeDos.add(jugador2);
		jugadoresMesaDeCuatro.add(jugador1);
		jugadoresMesaDeCuatro.add(jugador2);
		jugadoresMesaDeCuatro.add(jugador3);
		jugadoresMesaDeCuatro.add(jugador4);
		jugadoresMesaDeSeis.add(jugador1);
		jugadoresMesaDeSeis.add(jugador2);
		jugadoresMesaDeSeis.add(jugador3);
		jugadoresMesaDeSeis.add(jugador4);
		jugadoresMesaDeSeis.add(jugador5);
		jugadoresMesaDeSeis.add(jugador6);
		
		LinkedList<String> equipoUnoMesaDeDos = new LinkedList<String>();
		LinkedList<String> equipoDosMesaDeDos = new LinkedList<String>();
		equipoUnoMesaDeDos.add("1");
		equipoDosMesaDeDos.add("2");
		
		LinkedList<String> equipoUnoMesaDeCuatro = new LinkedList<String>();
		LinkedList<String> equipoDosMesaDeCuatro = new LinkedList<String>();
		equipoUnoMesaDeCuatro.add("1");
		equipoDosMesaDeCuatro.add("2");
		equipoUnoMesaDeCuatro.add("3");
		equipoDosMesaDeCuatro.add("4");
		
		LinkedList<String> equipoUnoMesaDeSeis = new LinkedList<String>();
		LinkedList<String> equipoDosMesaDeSeis = new LinkedList<String>();
		equipoUnoMesaDeSeis.add("1");
		equipoDosMesaDeSeis.add("2");
		equipoUnoMesaDeSeis.add("3");
		equipoDosMesaDeSeis.add("4");
		equipoUnoMesaDeSeis.add("5");
		equipoDosMesaDeSeis.add("6");
		
	    RotacionStrategy criterioRotacionMesaDeDos = new StrategyRotacionEnRonda(this.jugadoresMesaDeDos);
	    RotacionStrategy criterioRotacionMesaDeCuatro = new StrategyRotacionEnRonda(this.jugadoresMesaDeCuatro);
	    rotacionPicaPica = new StrategyRotacionPicaPica(this.jugadoresMesaDeSeis);
	    
		mesaDeDos = new Mesa(jugadoresMesaDeDos);
		mesaDeCuatro = new Mesa(jugadoresMesaDeCuatro); 
	    mesaPicaPica = new Mesa(jugadoresMesaDeSeis);
	    
	    this.moderadorMesaDeDos = new Moderador(mesaDeDos);
	    this.moderadorMesaDeCuatro = new Moderador(mesaDeCuatro);
	    this.moderadorMesaDeSeis = new Moderador(mesaPicaPica);
	    
	    this.moderadorMesaDeDos.setRotacionStrategy(criterioRotacionMesaDeDos);
	    this.moderadorMesaDeCuatro.setRotacionStrategy(criterioRotacionMesaDeCuatro);
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionPicaPica);
	    
	    
	    this.moderadorMesaDeDos.setPartida(new PartidaRondaSinFlor("", equipoUnoMesaDeDos, equipoDosMesaDeDos));
	    this.moderadorMesaDeCuatro.setPartida(new PartidaRondaSinFlor("",equipoUnoMesaDeCuatro,equipoDosMesaDeCuatro));
	    this.moderadorMesaDeSeis.setPartida(new PartidaRondaYPicaPicaSinFlor("",equipoUnoMesaDeSeis,equipoDosMesaDeSeis));
	    this.moderadorMesaDeDos.repartirCartas();
	    this.moderadorMesaDeCuatro.repartirCartas();
	    this.moderadorMesaDeSeis.repartirCartas();
	}
	
	@Test
	public void testRotacionDeTurnosPatidaDeDos() {
		
		this.jugador1.setModerador(moderadorMesaDeDos);
		this.jugador2.setModerador(moderadorMesaDeDos);
		
	    Jugable jugadorConTurno = this.moderadorMesaDeDos.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador1 == jugadorConTurno);	
		
	    this.jugador1.jugarPrimerCarta();
	    jugadorConTurno = this.moderadorMesaDeDos.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador2 == jugadorConTurno);	
	    
	    this.jugador2.jugarSegundaCarta();
	    jugadorConTurno = this.moderadorMesaDeDos.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador1 == jugadorConTurno);	
	}
	
	@Test
	public void testRotacionDeTurnosPartidaDeCuatro(){
		
		this.jugador1.setModerador(moderadorMesaDeCuatro);
		this.jugador2.setModerador(moderadorMesaDeCuatro);
		this.jugador3.setModerador(moderadorMesaDeCuatro);
		this.jugador4.setModerador(moderadorMesaDeCuatro);
			
		Jugable jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador1 == jugadorConTurno);	
		
	    this.jugador1.jugarPrimerCarta();
		jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorQueTieneTurno();
		Assert.assertTrue(jugador2 == jugadorConTurno);	
		    
		this.jugador2.jugarSegundaCarta();	
		jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorQueTieneTurno();
		Assert.assertTrue(jugador3 == jugadorConTurno);	

		this.jugador3.jugarTercerCarta();
		jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorQueTieneTurno();
		Assert.assertTrue(jugador4 == jugadorConTurno);	
		    
		this.jugador4.jugarPrimerCarta();
		jugadorConTurno = this.moderadorMesaDeCuatro.getJugadorQueTieneTurno();
		Assert.assertTrue(jugador1 == jugadorConTurno);	
	}
	
	
	@Test
	public void testRotacionDeManoPartidaDeDos(){
		
		
		 Jugable jugadorMano = this.moderadorMesaDeDos.getJugadorMano();
	     Assert.assertTrue(jugador1 == jugadorMano);
	     
	     this.moderadorMesaDeDos.rondaFinalizada();
	     jugadorMano = this.moderadorMesaDeDos.getJugadorMano();
	     Assert.assertTrue(jugador2 == jugadorMano);

	     this.moderadorMesaDeDos.rondaFinalizada();
	     jugadorMano = this.moderadorMesaDeDos.getJugadorMano();
	     Assert.assertTrue(jugador1 == jugadorMano); 
	}
	
	@Test
	public void testRotacionDeManoPartidaDeCuatro(){
		
		Jugable jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
	    Assert.assertTrue(jugador1 == jugadorMano);	
		
		this.moderadorMesaDeCuatro.rondaFinalizada();
		jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
		Assert.assertTrue(jugador2 == jugadorMano);	
		    
		this.moderadorMesaDeCuatro.rondaFinalizada();	
		jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
		Assert.assertTrue(jugador3 == jugadorMano);	

		this.moderadorMesaDeCuatro.rondaFinalizada();;	
		jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
		Assert.assertTrue(jugador4 == jugadorMano);	
		    
		this.moderadorMesaDeCuatro.rondaFinalizada();;	
		jugadorMano = this.moderadorMesaDeCuatro.getJugadorMano();
		Assert.assertTrue(jugador1 == jugadorMano);	
	}
	
	
	@Test
	public void testRotacionDeTurnosRondaPicaPica(){
		
		this.jugador1.setModerador(moderadorMesaDeSeis);
		this.jugador2.setModerador(moderadorMesaDeSeis);
		this.jugador3.setModerador(moderadorMesaDeSeis);
		this.jugador4.setModerador(moderadorMesaDeSeis);
		this.jugador5.setModerador(moderadorMesaDeSeis);
		this.jugador6.setModerador(moderadorMesaDeSeis);
		
		
		//Juega la primera pareja (jugador 1 vs jugador 4)
	    Jugable jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador1 == jugadorConTurno);
	    
	    this.jugador1.jugarPrimerCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador4 == jugadorConTurno);
	    
	    this.jugador4.jugarSegundaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador1 == jugadorConTurno);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    //Juega la segunda pareja (jugador 2 vs jugador 5)
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador2 == jugadorConTurno);
	    
	    this.jugador2.jugarPrimerCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador5 == jugadorConTurno);
	    
	    this.jugador5.jugarSegundaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador2 == jugadorConTurno);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    //Juega la tercera pareja (jugador 3 vs jugador 6)
	    //jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    Assert.assertTrue(jugador3 == this.moderadorMesaDeSeis.getJugadorQueTieneTurno());
	    
	    this.jugador3.jugarSegundaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador6 == jugadorConTurno);
	    
	    this.jugador6.jugarPrimerCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugador3 == jugadorConTurno);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	}
	
	@Test
	public void testCambioDeComportamientoDelModeradorEnMesaConPicaPica(){
		
		this.moderadorMesaDeSeis.setRotacionStrategy(new StrategyRotacionEnRonda(this.jugadoresMesaDeSeis));
		Jugable jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
		Jugable jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
		
		//Rotacion en ronda
		for(int i=0; i<5 ; i++){
			
			this.moderadorMesaDeSeis.seJugoUnaCarta();	
		}
		
		jugadorConTurno =  this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
		Assert.assertTrue(jugadorConTurno == jugador6);
		this.moderadorMesaDeSeis.rondaFinalizada();
		jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
		Assert.assertTrue(jugadorMano == jugador2);
		
		//Fin ronda ahora cambia el comportamiento
		
		//Ronda pica pica
		rotacionPicaPica  = new StrategyRotacionPicaPica(jugadoresMesaDeSeis);
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionPicaPica);
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugadorConTurno == jugador2);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugadorConTurno == jugador2);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    //jugadorConTurno = this.moderadorMesaDeSeis.getJugadorConTurno();
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugadorConTurno == jugador3);
	    Assert.assertTrue(jugadorMano == jugador3);
	    
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugadorConTurno == jugador4);
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugadorConTurno == jugador1);
	    
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    //fin ronda pica pica
	    
	    //Vuelve a rotar en ronda
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    this.moderadorMesaDeSeis.setRotacionStrategy(new StrategyRotacionEnRonda(this.jugadoresMesaDeSeis));
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
		Assert.assertTrue(jugadorConTurno == jugador3);
		Assert.assertTrue(jugadorMano == jugador3);
	    
        for(int i=0; i<5 ; i++){
			
			this.moderadorMesaDeSeis.seJugoUnaCarta();	
		}
        jugadorConTurno =  this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
		Assert.assertTrue(jugadorConTurno == jugador2);
		this.moderadorMesaDeSeis.rondaFinalizada();
		jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
		Assert.assertTrue(jugadorMano == jugador4);
		//Fin ronda comun, vuelve a pica pica
		
		//Ronda pica pica de nuevo
		rotacionPicaPica = new StrategyRotacionPicaPica(this.jugadoresMesaDeSeis);
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionPicaPica);
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugadorConTurno == jugador4);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugadorConTurno == jugador4);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    Assert.assertTrue(jugadorConTurno == jugador2);
	    Assert.assertTrue(jugadorMano == jugador5);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    //fin ronda pica pica
		
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    Assert.assertTrue(jugadorConTurno == jugador5);
	    Assert.assertTrue(jugadorMano == jugador5);
	    
	    //Vuelve a rotar en ronda
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    this.moderadorMesaDeSeis.setRotacionStrategy(new StrategyRotacionEnRonda(this.jugadoresMesaDeSeis));
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
		Assert.assertTrue(jugadorConTurno == jugador5);
		Assert.assertTrue(jugadorMano == jugador5);
	    
        for(int i=0; i<5 ; i++){
			
			this.moderadorMesaDeSeis.seJugoUnaCarta();	
		}
        jugadorConTurno =  this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
		Assert.assertTrue(jugadorConTurno == jugador4);
		this.moderadorMesaDeSeis.rondaFinalizada();
		jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
		Assert.assertTrue(jugadorMano == jugador6);
		//Fin ronda comun, vuelve a pica pica
	    
		//Ronda pica pica de nuevo
		rotacionPicaPica = new StrategyRotacionPicaPica(this.jugadoresMesaDeSeis);
	    this.moderadorMesaDeSeis.setRotacionStrategy(rotacionPicaPica);
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugadorConTurno == jugador6);
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    Assert.assertTrue(jugadorConTurno == jugador3);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    
	    this.moderadorMesaDeSeis.seJugoUnaCarta();
	    jugadorConTurno = this.moderadorMesaDeSeis.getJugadorQueTieneTurno();
	    jugadorMano = this.moderadorMesaDeSeis.getJugadorMano();
	    Assert.assertTrue(jugadorConTurno == jugador4);
	    Assert.assertTrue(jugadorMano == jugador1);
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    this.moderadorMesaDeSeis.rondaFinalizada();
	    //fin ronda pica pica
	}
}
