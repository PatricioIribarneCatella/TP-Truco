package algoritmosyprogramacion3.tp2.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.utilitarios.GraficadorCartas;
import algoritmosyprogramacion3.tp2.vista.Imagen;

public class GraficadorCartasTest {

	@Test
	public void test() {
		
		GraficadorCartas graficador = new GraficadorCartas();
		Carta carta = new UnoDeBasto();
		Imagen imagen = graficador.getImagen(carta);
		Assert.assertNotNull(imagen);
	}
}
