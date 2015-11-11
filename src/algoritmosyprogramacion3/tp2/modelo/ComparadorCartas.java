package algoritmosyprogramacion3.tp2.modelo;

import java.util.Comparator;

public class ComparadorCartas implements Comparator<Carta> {

	@Override
	public int compare(Carta carta1, Carta carta2) {
		
		if (carta1.getValorEnvido() < carta2.getValorEnvido()) return 1;
		if (carta1.getValorEnvido() > carta2.getValorEnvido()) return -1;
		return 0;
	}
}
