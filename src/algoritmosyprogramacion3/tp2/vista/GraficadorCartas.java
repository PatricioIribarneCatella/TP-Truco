package algoritmosyprogramacion3.tp2.vista;

import java.util.HashMap;
import java.util.Map;

import algoritmosyprogramacion3.tp2.modelo.CaballoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.CaballoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.CaballoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.CaballoDeOro;
import algoritmosyprogramacion3.tp2.modelo.Carta;
import algoritmosyprogramacion3.tp2.modelo.CincoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.CincoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.CincoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.CincoDeOro;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeBasto;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeCopa;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeEspada;
import algoritmosyprogramacion3.tp2.modelo.CuatroDeOro;
import algoritmosyprogramacion3.tp2.modelo.DosDeBasto;
import algoritmosyprogramacion3.tp2.modelo.DosDeCopa;
import algoritmosyprogramacion3.tp2.modelo.DosDeEspada;
import algoritmosyprogramacion3.tp2.modelo.DosDeOro;
import algoritmosyprogramacion3.tp2.modelo.ReyDeBasto;
import algoritmosyprogramacion3.tp2.modelo.ReyDeCopa;
import algoritmosyprogramacion3.tp2.modelo.ReyDeEspada;
import algoritmosyprogramacion3.tp2.modelo.ReyDeOro;
import algoritmosyprogramacion3.tp2.modelo.SeisDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SeisDeCopa;
import algoritmosyprogramacion3.tp2.modelo.SeisDeEspada;
import algoritmosyprogramacion3.tp2.modelo.SeisDeOro;
import algoritmosyprogramacion3.tp2.modelo.SieteDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SieteDeCopa;
import algoritmosyprogramacion3.tp2.modelo.SieteDeEspada;
import algoritmosyprogramacion3.tp2.modelo.SieteDeOro;
import algoritmosyprogramacion3.tp2.modelo.SotaDeBasto;
import algoritmosyprogramacion3.tp2.modelo.SotaDeCopa;
import algoritmosyprogramacion3.tp2.modelo.SotaDeEspada;
import algoritmosyprogramacion3.tp2.modelo.SotaDeOro;
import algoritmosyprogramacion3.tp2.modelo.TresDeBasto;
import algoritmosyprogramacion3.tp2.modelo.TresDeCopa;
import algoritmosyprogramacion3.tp2.modelo.TresDeEspada;
import algoritmosyprogramacion3.tp2.modelo.TresDeOro;
import algoritmosyprogramacion3.tp2.modelo.UnoDeBasto;
import algoritmosyprogramacion3.tp2.modelo.UnoDeCopa;
import algoritmosyprogramacion3.tp2.modelo.UnoDeEspada;
import algoritmosyprogramacion3.tp2.modelo.UnoDeOro;

public class GraficadorCartas {

	Map<Carta,Imagen> cartasImagen;
	
	public GraficadorCartas() {
		this.cartasImagen = new HashMap<Carta,Imagen>();
		this.initialize();
	}

	private void initialize() {
		
		this.cartasImagen.put(new UnoDeEspada(), new Imagen("file:resources/imagenes/cartas/espada/uno-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new UnoDeBasto(), new Imagen("file:resources/imagenes/cartas/basto/uno-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new UnoDeCopa(), new Imagen("file:resources/imagenes/cartas/copa/uno-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new UnoDeOro(), new Imagen("file:resources/imagenes/cartas/oro/uno-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new DosDeEspada(), new Imagen("file:resources/imagenes/cartas/espada/dos-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new DosDeBasto(), new Imagen("file:resources/imagenes/cartas/basto/dos-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new DosDeCopa(), new Imagen("file:resources/imagenes/cartas/copa/dos-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new DosDeOro(), new Imagen("file:resources/imagenes/cartas/oro/dos-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new TresDeEspada(), new Imagen("file:resources/imagenes/cartas/espada/tres-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new TresDeBasto(), new Imagen("file:resources/imagenes/cartas/basto/tres-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new TresDeCopa(), new Imagen("file:resources/imagenes/cartas/copa/tres-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new TresDeOro(), new Imagen("file:resources/imagenes/cartas/oro/tres-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new CuatroDeEspada(), new Imagen("file:resources/imagenes/cartas/espada/cuatro-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new CuatroDeBasto(), new Imagen("file:resources/imagenes/cartas/basto/cuatro-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new CuatroDeCopa(), new Imagen("file:resources/imagenes/cartas/copa/cuatro-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new CuatroDeOro(), new Imagen("file:resources/imagenes/cartas/oro/cuatro-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new CincoDeEspada(), new Imagen("file:resources/imagenes/cartas/espada/cinco-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new CincoDeBasto(), new Imagen("file:resources/imagenes/cartas/basto/cinco-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new CincoDeCopa(), new Imagen("file:resources/imagenes/cartas/copa/cinco-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new CincoDeOro(), new Imagen("file:resources/imagenes/cartas/oro/cinco-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new SeisDeEspada(), new Imagen("file:resources/imagenes/cartas/espada/seis-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SeisDeBasto(), new Imagen("file:resources/imagenes/cartas/basto/seis-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SeisDeCopa(), new Imagen("file:resources/imagenes/cartas/copa/seis-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SeisDeOro(), new Imagen("file:resources/imagenes/cartas/oro/seis-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new SieteDeEspada(), new Imagen("file:resources/imagenes/cartas/espada/siete-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SieteDeBasto(), new Imagen("file:resources/imagenes/cartas/basto/siete-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SieteDeCopa(), new Imagen("file:resources/imagenes/cartas/copa/siete-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SieteDeOro(), new Imagen("file:resources/imagenes/cartas/oro/siete-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new SotaDeEspada(), new Imagen("file:resources/imagenes/cartas/espada/diez-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SotaDeBasto(), new Imagen("file:resources/imagenes/cartas/basto/diez-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SotaDeCopa(), new Imagen("file:resources/imagenes/cartas/copa/diez-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SotaDeOro(), new Imagen("file:resources/imagenes/cartas/oro/diez-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new CaballoDeEspada(), new Imagen("file:resources/imagenes/cartas/espada/once-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new CaballoDeBasto(), new Imagen("file:resources/imagenes/cartas/basto/once-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new CaballoDeCopa(), new Imagen("file:resources/imagenes/cartas/copa/once-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new CaballoDeOro(), new Imagen("file:resources/imagenes/cartas/oro/once-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new ReyDeEspada(), new Imagen("file:resources/imagenes/cartas/espada/doce-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new ReyDeBasto(), new Imagen("file:resources/imagenes/cartas/basto/doce-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new ReyDeCopa(), new Imagen("file:resources/imagenes/cartas/copa/doce-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new ReyDeOro(), new Imagen("file:resources/imagenes/cartas/oro/doce-de-oro.jpg", 75, 150, false, true));
	}
	
	public Imagen getImagen(Carta carta) {
		return this.cartasImagen.get(carta);
	}
}
