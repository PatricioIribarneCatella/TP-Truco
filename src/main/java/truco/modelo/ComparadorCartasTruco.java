package algoritmosyprogramacion3.tp2.modelo;

import java.util.Comparator;

public class ComparadorCartasTruco implements Comparator<Carta> {

	@Override
	public int compare(Carta carta1, Carta carta2) {
		
		if (carta1.jugarContra(carta2) == carta1) return 1;
		if (carta2.jugarContra(carta1) == carta2) return -1;
		return 0;
	}
}
