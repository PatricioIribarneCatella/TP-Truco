package algoritmosyprogramacion3.tp2.modelo;

import java.util.Arrays;
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
	
	private String calcularPuntajeEnvidoConFlor() {
		
		int puntaje = 20;
		
		this.cartas.sort(new ComparadorCartasEnvido());
		
		puntaje += this.cartas.get(1).getValorEnvido() + this.cartas.get(2).getValorEnvido();
		
		return Integer.toString(puntaje);
	}
	
	private List<Palo> getListaPalos() {
		return Arrays.asList(new Basto(), new Oro(), new Espada(), new Copa());
	}
	
	private int calcularPuntajeEnvidoPara(Palo palo) {
	
		List<Carta> cartasFiltradas = this.filtrarCartasPorPalo(palo);
		
		if (cartasFiltradas.isEmpty()) return 0;
		if (cartasFiltradas.size() == 1) return cartasFiltradas.get(0).getValor();
		
		int puntaje = 20;
		
		for (Carta carta : cartasFiltradas) {
			puntaje += carta.getValorEnvido();
		}
		return puntaje;
	}
	
	private String calcularPuntajeEnvido() {
		
		List<Integer> envidos = new LinkedList<Integer>();
		List<Palo> palos = this.getListaPalos();
		
		for (Palo palo : palos) {
			envidos.add(this.calcularPuntajeEnvidoPara(palo));
		}
		
		Optional<Integer> maximo = envidos.stream().max(Integer::compare);
		return Integer.toString(maximo.get());
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
		
		if (hayFlor()) return this.calcularPuntajeEnvidoConFlor();
		else return this.calcularPuntajeEnvido();
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
		
		List<Carta> listaCartas = new LinkedList<Carta>();
		
		for (Carta carta : this.cartas) {
			if (carta.esValidaParaSerJugada()) listaCartas.add(carta);
		}
		
		return listaCartas;
	}

	public void vaciar() {
		
		for (Carta carta : this.cartas) {
			carta.volveAlMazo();
		}
		this.cartas.clear();
	}
}
