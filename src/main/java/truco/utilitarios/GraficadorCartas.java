package truco.utilitarios;

import java.util.Map;
import java.util.HashMap;

import truco.modelo.Carta;
import truco.modelo.UnoDeBasto;
import truco.modelo.UnoDeCopa;
import truco.modelo.UnoDeEspada;
import truco.modelo.UnoDeOro;
import truco.modelo.Dos;
import truco.modelo.Tres;
import truco.modelo.Cuatro;
import truco.modelo.Cinco;
import truco.modelo.Seis;
import truco.modelo.SieteDeBasto;
import truco.modelo.SieteDeCopa;
import truco.modelo.SieteDeEspada;
import truco.modelo.SieteDeOro;
import truco.modelo.Sota;
import truco.modelo.Caballo;
import truco.modelo.Rey;
import truco.modelo.Palo;
import truco.vista.Imagen;

public class GraficadorCartas {

	Map<Carta,Imagen> cartasImagen;

	public GraficadorCartas() {
		this.cartasImagen = new HashMap<Carta,Imagen>();
		this.initialize();
	}

	private void initialize() {

		this.cartasImagen.put(new UnoDeEspada(), new Imagen("file:src/main/resources/imagenes/cartas/espada/uno-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new UnoDeBasto(), new Imagen("file:src/main/resources/imagenes/cartas/basto/uno-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new UnoDeCopa(), new Imagen("file:src/main/resources/imagenes/cartas/copa/uno-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new UnoDeOro(), new Imagen("file:src/main/resources/imagenes/cartas/oro/uno-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new Dos(Palo.ESPADA), new Imagen("file:src/main/resources/imagenes/cartas/espada/dos-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Dos(Palo.BASTO), new Imagen("file:src/main/resources/imagenes/cartas/basto/dos-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Dos(Palo.COPA), new Imagen("file:src/main/resources/imagenes/cartas/copa/dos-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Dos(Palo.ORO), new Imagen("file:src/main/resources/imagenes/cartas/oro/dos-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new Tres(Palo.ESPADA), new Imagen("file:src/main/resources/imagenes/cartas/espada/tres-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Tres(Palo.BASTO), new Imagen("file:src/main/resources/imagenes/cartas/basto/tres-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Tres(Palo.COPA), new Imagen("file:src/main/resources/imagenes/cartas/copa/tres-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Tres(Palo.ORO), new Imagen("file:src/main/resources/imagenes/cartas/oro/tres-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new Cuatro(Palo.ESPADA), new Imagen("file:src/main/resources/imagenes/cartas/espada/cuatro-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Cuatro(Palo.BASTO), new Imagen("file:src/main/resources/imagenes/cartas/basto/cuatro-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Cuatro(Palo.COPA), new Imagen("file:src/main/resources/imagenes/cartas/copa/cuatro-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Cuatro(Palo.ORO), new Imagen("file:src/main/resources/imagenes/cartas/oro/cuatro-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new Cinco(Palo.ESPADA), new Imagen("file:src/main/resources/imagenes/cartas/espada/cinco-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Cinco(Palo.BASTO), new Imagen("file:src/main/resources/imagenes/cartas/basto/cinco-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Cinco(Palo.COPA), new Imagen("file:src/main/resources/imagenes/cartas/copa/cinco-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Cinco(Palo.ORO), new Imagen("file:src/main/resources/imagenes/cartas/oro/cinco-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new Seis(Palo.ESPADA), new Imagen("file:src/main/resources/imagenes/cartas/espada/seis-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Seis(Palo.BASTO), new Imagen("file:src/main/resources/imagenes/cartas/basto/seis-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Seis(Palo.COPA), new Imagen("file:src/main/resources/imagenes/cartas/copa/seis-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Seis(Palo.ORO), new Imagen("file:src/main/resources/imagenes/cartas/oro/seis-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new SieteDeEspada(), new Imagen("file:src/main/resources/imagenes/cartas/espada/siete-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SieteDeBasto(), new Imagen("file:src/main/resources/imagenes/cartas/basto/siete-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SieteDeCopa(), new Imagen("file:src/main/resources/imagenes/cartas/copa/siete-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new SieteDeOro(), new Imagen("file:src/main/resources/imagenes/cartas/oro/siete-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new Sota(Palo.ESPADA), new Imagen("file:src/main/resources/imagenes/cartas/espada/diez-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Sota(Palo.BASTO), new Imagen("file:src/main/resources/imagenes/cartas/basto/diez-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Sota(Palo.COPA), new Imagen("file:src/main/resources/imagenes/cartas/copa/diez-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Sota(Palo.ORO), new Imagen("file:src/main/resources/imagenes/cartas/oro/diez-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new Caballo(Palo.ESPADA), new Imagen("file:src/main/resources/imagenes/cartas/espada/once-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Caballo(Palo.BASTO), new Imagen("file:src/main/resources/imagenes/cartas/basto/once-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Caballo(Palo.COPA), new Imagen("file:src/main/resources/imagenes/cartas/copa/once-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Caballo(Palo.ORO), new Imagen("file:src/main/resources/imagenes/cartas/oro/once-de-oro.jpg", 75, 150, false, true));
		
		this.cartasImagen.put(new Rey(Palo.ESPADA), new Imagen("file:src/main/resources/imagenes/cartas/espada/doce-de-espada.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Rey(Palo.BASTO), new Imagen("file:src/main/resources/imagenes/cartas/basto/doce-de-basto.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Rey(Palo.COPA), new Imagen("file:src/main/resources/imagenes/cartas/copa/doce-de-copa.jpg", 75, 150, false, true));
		this.cartasImagen.put(new Rey(Palo.ORO), new Imagen("file:src/main/resources/imagenes/cartas/oro/doce-de-oro.jpg", 75, 150, false, true));
	}
	
	public Imagen getImagen(Carta carta) {
		return this.cartasImagen.get(carta);
	}
}
