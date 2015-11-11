package algoritmosyprogramacion3.tp2.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Mano {

	private List<Carta> cartas;
	
	public Mano() {
		
		this.cartas = new LinkedList<Carta>();
	}
	
	private List<Carta> filtrarCartasPorPalo(Palo palo) {
		
		List<Carta> lista = new LinkedList<Carta>();
		
		Stream<Carta> cartasFiltradas = this.cartas.stream().filter(x -> palo.compararCon(x.getPalo()));
		
		cartasFiltradas.forEach(y -> lista.add(y));
		
		return lista;
	}
	
	private void calcularPuntajeEnvido(List<Carta> lista, int puntaje) {
		
		for (Carta carta : lista) {
			puntaje += carta.getValorEnvido();	
		}
	}
	
	private void calcularPuntajeEnvidoConFlor(int puntaje) {
		
		this.cartas.sort(new ComparadorCartas());
		
		puntaje = this.cartas.get(1).getValorEnvido() + this.cartas.get(2).getValorEnvido();
	}

	private void calcularPuntajeEnvidoMentiroso(int puntaje) {
		
		this.cartas.sort(new ComparadorCartas());
		
		puntaje = this.cartas.get(2).getValorEnvido();
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
		
		List<Carta> listaEspada = this.filtrarCartasPorPalo(new Espada());
		List<Carta> listaBasto = this.filtrarCartasPorPalo(new Basto());
		List<Carta> listaOro = this.filtrarCartasPorPalo(new Oro());
		List<Carta> listaCopa = this.filtrarCartasPorPalo(new Copa());
		
		if (listaEspada.size() == 2) {
			
			this.calcularPuntajeEnvido(listaEspada, puntaje);
			
		} else if (listaBasto.size() == 2) {
			
			this.calcularPuntajeEnvido(listaBasto, puntaje);
			
		} else if (listaOro.size() == 2) {
			
			this.calcularPuntajeEnvido(listaOro, puntaje);
			
		} else if (listaCopa.size() == 2) {
			
			this.calcularPuntajeEnvido(listaCopa, puntaje);
			
		} else if (hayFlor()) {
			
			this.calcularPuntajeEnvidoConFlor(puntaje);
			
		} else {
			
			this.calcularPuntajeEnvidoMentiroso(puntaje);
		}
		
		puntajeComoString = Integer.toString(puntaje);
		
		return puntajeComoString;
	}
	
	public void agregarCarta(Carta nuevaCarta) {
		this.cartas.add(nuevaCarta);
	}
	
	public void removerCartas() {
		this.cartas.clear();
	}
}
