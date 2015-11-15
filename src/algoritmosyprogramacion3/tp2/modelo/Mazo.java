package algoritmosyprogramacion3.tp2.modelo;

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
		
		this.cartas.add(new DosDeEspada());
		this.cartas.add(new DosDeBasto());
		this.cartas.add(new DosDeCopa());
		this.cartas.add(new DosDeOro());
		
		this.cartas.add(new TresDeEspada());
		this.cartas.add(new TresDeBasto());
		this.cartas.add(new TresDeCopa());
		this.cartas.add(new TresDeOro());
		
		this.cartas.add(new CuatroDeEspada());
		this.cartas.add(new CuatroDeBasto());
		this.cartas.add(new CuatroDeCopa());
		this.cartas.add(new CuatroDeOro());
		
		this.cartas.add(new CincoDeEspada());
		this.cartas.add(new CincoDeBasto());
		this.cartas.add(new CincoDeCopa());
		this.cartas.add(new CincoDeOro());
		
		this.cartas.add(new SeisDeEspada());
		this.cartas.add(new SeisDeBasto());
		this.cartas.add(new SeisDeCopa());
		this.cartas.add(new SeisDeOro());
		
		this.cartas.add(new SieteDeEspada());
		this.cartas.add(new SieteDeBasto());
		this.cartas.add(new SieteDeCopa());
		this.cartas.add(new SieteDeOro());
		
		this.cartas.add(new SotaDeEspada());
		this.cartas.add(new SotaDeBasto());
		this.cartas.add(new SotaDeCopa());
		this.cartas.add(new SotaDeOro());
		
		this.cartas.add(new CaballoDeEspada());
		this.cartas.add(new CaballoDeBasto());
		this.cartas.add(new CaballoDeCopa());
		this.cartas.add(new CaballoDeOro());
		
		this.cartas.add(new ReyDeEspada());
		this.cartas.add(new ReyDeBasto());
		this.cartas.add(new ReyDeCopa());
		this.cartas.add(new ReyDeOro());
		
		this.mezclarCartas();
	}
	
	private void mezclarCartas() {
		
		Collections.shuffle(this.cartas);
	}
	
	public Carta darCarta() {
		
		Carta carta = this.cartas.get(this.indiceDeCarta);
		this.indiceDeCarta++;
		return carta;
	}
	
	public void barajar() {
		
		this.mezclarCartas();
		this.indiceDeCarta = 0;
	}
}
