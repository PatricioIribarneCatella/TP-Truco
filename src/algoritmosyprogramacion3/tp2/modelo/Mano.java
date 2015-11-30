package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Mano {

	private List<Carta> cartas;
	private Carta ultimaCartaJugada;
	
	public Mano() {
		
		this.cartas = new LinkedList<Carta>();
	}
	
	private List<Carta> filtrarCartasPorPalo(Palo palo) {
		
		List<Carta> lista = new LinkedList<Carta>();
		
		Stream<Carta> cartasFiltradas = this.cartas.stream().filter(x -> palo.compararCon(x.getPalo()));
		
		cartasFiltradas.forEach(y -> lista.add(y));
		
		return lista;
	}
	
	private int calcularPuntajeEnvido(List<Carta> lista) {
		
		int puntaje = 0;
		
		for (Carta carta : lista) {
			puntaje += carta.getValorEnvido();	
		}
		
		return puntaje;
	}
	
	private int calcularPuntajeEnvidoConFlor() {
		
		int puntaje = 0;
		
		this.cartas.sort(new ComparadorCartasEnvido());
		
		puntaje = this.cartas.get(1).getValorEnvido() + this.cartas.get(2).getValorEnvido();
		
		return puntaje;
	}

	private int calcularPuntajeEnvidoMentiroso() {
		
		int puntaje = 0;
		
		Optional<Carta> maximo = this.cartas.stream().max(new ComparadorCartasEnvido());
		
		Carta carta = maximo.get();
		
		puntaje = carta.getValorEnvido();
		
		return puntaje;
	}
	
	public boolean hayFlor() {
		
		if (this.filtrarCartasPorPalo(new Espada()).size() == 3) return true;
		
		if (this.filtrarCartasPorPalo(new Basto()).size() == 3) return true;
		
		if (this.filtrarCartasPorPalo(new Oro()).size() == 3) return true;
		
		if (this.filtrarCartasPorPalo(new Copa()).size() == 3) return true;
		
		return false;
	}
	
	public String puntajeFlor() {
		
		String resultadoComoString;
		int resultadoAcumulado = 20;
		
		for (Carta carta : this.cartas) {
			resultadoAcumulado += carta.getValorFlor(); 
		}
		
		resultadoComoString = Integer.toString(resultadoAcumulado);
		
		return resultadoComoString;
	}
		
	public String puntajeEnvido() {
		
		String puntajeComoString;
		int puntaje = 20;
		int puntajeParcial = 0;
		
		List<Carta> listaEspada = this.filtrarCartasPorPalo(new Espada());
		List<Carta> listaBasto = this.filtrarCartasPorPalo(new Basto());
		List<Carta> listaOro = this.filtrarCartasPorPalo(new Oro());
		List<Carta> listaCopa = this.filtrarCartasPorPalo(new Copa());
		
		if (listaEspada.size() == 2) {
			
			puntajeParcial = this.calcularPuntajeEnvido(listaEspada);
			
		} else if (listaBasto.size() == 2) {
			
			puntajeParcial = this.calcularPuntajeEnvido(listaBasto);
			
		} else if (listaOro.size() == 2) {
			
			puntajeParcial = this.calcularPuntajeEnvido(listaOro);
			
		} else if (listaCopa.size() == 2) {
			
			puntajeParcial = this.calcularPuntajeEnvido(listaCopa);
			
		} else if (hayFlor()) {
			
			puntajeParcial = this.calcularPuntajeEnvidoConFlor();
			
		} else {
			
			puntajeParcial = this.calcularPuntajeEnvidoMentiroso();
		}
		
		puntaje += puntajeParcial;
		puntajeComoString = Integer.toString(puntaje);
		
		return puntajeComoString;
	}
	
	public void agregarCarta(Carta nuevaCarta) {
		this.cartas.add(nuevaCarta);
	}
	
	public Carta getPrimerCarta() {
		
		Carta carta = this.cartas.get(0);
		this.ultimaCartaJugada = carta;
		return carta;
	}
	
	public Carta getSegundaCarta() {

		Carta carta = this.cartas.get(1);
		this.ultimaCartaJugada = carta;
		return carta;
	}
	
	public Carta getTercerCarta() {

		Carta carta = this.cartas.get(2);
		this.ultimaCartaJugada = carta;
		return carta;
	}
	
	public void removerCartas() {
		this.cartas.clear();
	}

	public Carta getUltimaCartaJugada() {
		return this.ultimaCartaJugada;
	}
	
	public boolean hayCartasJugadas() {
		
		for (Carta carta : this.cartas) {
			if (!carta.esValidaParaSerJugada()) return true;
 		}
		return false;
	}

	public List<Carta> getCartas() {
		return this.cartas;
	}
}
