package truco.pruebasUnitarias;

import org.junit.Assert;
import org.junit.Test;

import truco.modelo.Carta;
import truco.modelo.UnoDeBasto;
import truco.utilitarios.GraficadorCartas;
import truco.vista.Imagen;

public class GraficadorCartasTest {

	@Test
	public void test() {
		
		GraficadorCartas graficador = new GraficadorCartas();
		Carta carta = new UnoDeBasto();
		Imagen imagen = graficador.getImagen(carta);
		Assert.assertNotNull(imagen);
	}
}
