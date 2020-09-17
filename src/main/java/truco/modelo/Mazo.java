package truco.modelo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Mazo {

	private List<Carta> cartas;
	private int indiceDeCarta;
	
	public Mazo() {
		
		this.cartas = new LinkedList<Carta>();
		this.indiceDeCarta = 0;
		this.initialize();
	}
	
	private void initialize() {
		
		this.cartas.add(new UnoDeEspada());
		this.cartas.add(new UnoDeBasto());
		this.cartas.add(new UnoDeCopa());
		this.cartas.add(new UnoDeOro());
		
		this.cartas.add(new Dos(Palo.ESPADA));
		this.cartas.add(new Dos(Palo.BASTO));
		this.cartas.add(new Dos(Palo.COPA));
		this.cartas.add(new Dos(Palo.ORO));
		
		this.cartas.add(new Tres(Palo.ESPADA));
		this.cartas.add(new Tres(Palo.BASTO));
		this.cartas.add(new Tres(Palo.COPA));
		this.cartas.add(new Tres(Palo.ORO));
		
		this.cartas.add(new Cuatro(Palo.ESPADA));
		this.cartas.add(new Cuatro(Palo.BASTO));
		this.cartas.add(new Cuatro(Palo.COPA));
		this.cartas.add(new Cuatro(Palo.ORO));
		
		this.cartas.add(new Cinco(Palo.ESPADA));
		this.cartas.add(new Cinco(Palo.BASTO));
		this.cartas.add(new Cinco(Palo.COPA));
		this.cartas.add(new Cinco(Palo.ORO));
		
		this.cartas.add(new Seis(Palo.ESPADA));
		this.cartas.add(new Seis(Palo.BASTO));
		this.cartas.add(new Seis(Palo.COPA));
		this.cartas.add(new Seis(Palo.ORO));
		
		this.cartas.add(new SieteDeEspada());
		this.cartas.add(new SieteDeBasto());
		this.cartas.add(new SieteDeCopa());
		this.cartas.add(new SieteDeOro());
		
		this.cartas.add(new Sota(Palo.ESPADA));
		this.cartas.add(new Sota(Palo.BASTO));
		this.cartas.add(new Sota(Palo.COPA));
		this.cartas.add(new Sota(Palo.ORO));
		
		this.cartas.add(new Caballo(Palo.ESPADA));
		this.cartas.add(new Caballo(Palo.BASTO));
		this.cartas.add(new Caballo(Palo.COPA));
		this.cartas.add(new Caballo(Palo.ORO));
		
		this.cartas.add(new Rey(Palo.ESPADA));
		this.cartas.add(new Rey(Palo.BASTO));
		this.cartas.add(new Rey(Palo.COPA));
		this.cartas.add(new Rey(Palo.ORO));
		
		this.mezclarCartas();
	}
	
	private void mezclarCartas() {
		
		Collections.shuffle(this.cartas);
	}
	
	public Carta darCarta() {
		
		Carta carta = this.cartas.get(this.indiceDeCarta);
		this.indiceDeCarta++;
		carta.pasaAEstar(new EnMano());
		return carta;
	}
	
	public void barajar() {
		
		this.mezclarCartas();
		this.indiceDeCarta = 0;
	}
}
