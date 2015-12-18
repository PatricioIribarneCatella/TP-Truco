package algoritmosyprogramacion3.tp2.utilitarios;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algoritmosyprogramacion3.tp2.manejadores.BotonAceptarFlorEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonAceptarReTrucoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonAceptarRealEnvidoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonAceptarTrucoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonAceptarValeCuatroEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonAceptarEnvidoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonAceptarFaltaEnvidoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonEnvidoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonFaltaEnvidoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonReTrucoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonRealEnvidoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonRechazarVarianteTrucoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonRechazarFlorEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonRechazarVarianteEnvidoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonTrucoEventHandler;
import algoritmosyprogramacion3.tp2.manejadores.BotonValeCuatroEventHandler;
import algoritmosyprogramacion3.tp2.modelo.Partida;
import algoritmosyprogramacion3.tp2.modelo.PartidaRondaConFlor;
import algoritmosyprogramacion3.tp2.modelo.PartidaRondaSinFlor;
import algoritmosyprogramacion3.tp2.modelo.PartidaRondaYPicaPicaConFlor;
import algoritmosyprogramacion3.tp2.modelo.PartidaRondaYPicaPicaSinFlor;
import algoritmosyprogramacion3.tp2.vista.BotonEnvido;
import algoritmosyprogramacion3.tp2.vista.BotonFaltaEnvido;
import algoritmosyprogramacion3.tp2.vista.BotonFlor;
import algoritmosyprogramacion3.tp2.vista.BotonJuegoTruco;
import algoritmosyprogramacion3.tp2.vista.BotonRealEnvido;
import algoritmosyprogramacion3.tp2.vista.BotonTruco;
import algoritmosyprogramacion3.tp2.vista.VistaJuegoDeTruco;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GraficadorBotonesDeCantos {

	/* 
	 * 
	 * Mapeo de las distintas partidas con sus correspondientes configuraciones de botones al iniciar 
	 * una partida
	 * 
	 *  */
	
	@SuppressWarnings("rawtypes")
	private static Map<Class, List<BotonJuegoTruco>> partidaBotones = crearPartidaBotones(); 
	
	@SuppressWarnings("rawtypes")
	private static Map<Class, List<BotonJuegoTruco>> crearPartidaBotones() {
		
		Map<Class, List<BotonJuegoTruco>> partidaBotones = new HashMap<Class, List<BotonJuegoTruco>>();
		
		partidaBotones.put(PartidaRondaSinFlor.class, getBotonesSinFlor());
		partidaBotones.put(PartidaRondaConFlor.class, getBotonesConFlor());
		partidaBotones.put(PartidaRondaYPicaPicaSinFlor.class, getBotonesSinFlor());
		partidaBotones.put(PartidaRondaYPicaPicaConFlor.class, getBotonesConFlor());
		
		return partidaBotones;
	}
	
	private static List<BotonJuegoTruco> getBotonesSinFlor() {
		return Arrays.asList(new BotonTruco(), new BotonEnvido(), new BotonRealEnvido(), new BotonFaltaEnvido());
	}
	
	private static List<BotonJuegoTruco> getBotonesConFlor() {
		return Arrays.asList(new BotonTruco(), new BotonEnvido(), new BotonRealEnvido(), new BotonFaltaEnvido(), new BotonFlor());
	}
	
	private static List<BotonJuegoTruco> getBotones(Partida partida) {
		return partidaBotones.get(partida.getClass());
	}
	
	/* Configuración caracteríticas al botón */
	
	private static void setCaracteristicas(Button boton) {
		
		boton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		boton.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorBoton = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		boton.setBackground(new Background(fondoDeColorBoton));
		
		boton.setOnMouseEntered(e -> {
			
			boton.setScaleX(1.2);
			boton.setScaleY(1.2);
		});
		
		boton.setOnMouseExited(e -> {
			
			boton.setScaleX(1);
			boton.setScaleY(1);
		});
	}
	
	/* Construcción de los distintos botones */

	private static Button getBotonTruco(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Truco");
		
		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonTrucoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonReTruco(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Re-Truco");
		
		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonReTrucoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonValeCuatro(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Vale Cuatro");

		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonValeCuatroEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonEnvido(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Envido");

		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonEnvidoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonRealEnvido(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Real Envido");

		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonRealEnvidoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonFaltaEnvido(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Falta Envido");

		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonFaltaEnvidoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonAceptarTruco(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Aceptar");

		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonAceptarTrucoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonAceptarReTruco(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Aceptar");

		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonAceptarReTrucoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonAceptarValeCuatro(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Aceptar");

		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonAceptarValeCuatroEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonAceptarEnvido(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Aceptar");
		
		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonAceptarEnvidoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonAceptarRealEnvido(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Aceptar");
		
		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonAceptarRealEnvidoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonAceptarFaltaEnvido(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Aceptar");
		
		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonAceptarFaltaEnvidoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonAceptarFlor(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Aceptar");
		
		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonAceptarFlorEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonRechazarVarianteTruco(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Rechazar");
		
		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonRechazarVarianteTrucoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonRechazarVarianteEnvido(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Rechazar");
		
		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonRechazarVarianteEnvidoEventHandler(vista));
		
		return boton;
	}
	
	private static Button getBotonRechazarFlor(VistaJuegoDeTruco vista) {
		
		Button boton = new Button("Rechazar");
		
		setCaracteristicas(boton);
		
		boton.setOnAction(new BotonRechazarFlorEventHandler(vista));
		
		return boton;
	}
	
	/* Métodos para graficar las distintas situaciones */
	
	public static VBox graficarSituacionInicial(Partida partida, VistaJuegoDeTruco vista) {
		
		List<BotonJuegoTruco> botones = getBotones(partida);
		
		VBox contenedor = new VBox();
		
		for (BotonJuegoTruco boton : botones) {
			
			boton.setVistaAlEventHandler(vista);
			setCaracteristicas(boton);
			contenedor.getChildren().add(boton);
		}
		
		return contenedor;
	}

	public static VBox graficarSituacionTruco(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonReTruco = getBotonReTruco(vista);
		
		Button botonAceptar = getBotonAceptarTruco(vista);
		
		Button botonRechazar = getBotonRechazarVarianteTruco(vista);
		
		contenedor.getChildren().addAll(botonReTruco, botonAceptar, botonRechazar);
		
		return contenedor;
	}

	public static VBox graficarSituacionReTruco(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonValeCuatro = getBotonValeCuatro(vista);
		
		Button botonAceptar = getBotonAceptarReTruco(vista);
		
		Button botonRechazar = getBotonRechazarVarianteTruco(vista);
		
		contenedor.getChildren().addAll(botonValeCuatro, botonAceptar, botonRechazar);
		
		return contenedor;
	}

	public static VBox graficarSituacionValeCuatro(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonAceptar = getBotonAceptarValeCuatro(vista);
		
		Button botonRechazar = getBotonRechazarVarianteTruco(vista);
		
		contenedor.getChildren().addAll(botonAceptar, botonRechazar);
		
		return contenedor;
	}

	public static VBox graficarSituacionEnvido(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonEnvido = getBotonEnvido(vista);
		
		Button botonRealEnvido = getBotonRealEnvido(vista);
		
		Button botonFaltaEnvido = getBotonFaltaEnvido(vista);
		
		Button botonAceptar = getBotonAceptarEnvido(vista);
		
		Button botonRechazar = getBotonRechazarVarianteEnvido(vista);
		
		contenedor.getChildren().addAll(botonEnvido, botonRealEnvido, botonFaltaEnvido, botonAceptar, botonRechazar);
		
		return contenedor;
	}

	public static VBox graficarSituacionRealEnvido(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonFaltaEnvido = getBotonFaltaEnvido(vista);
		
		Button botonAceptar = getBotonAceptarRealEnvido(vista);
		
		Button botonRechazar = getBotonRechazarVarianteEnvido(vista);
		
		contenedor.getChildren().addAll(botonFaltaEnvido, botonAceptar, botonRechazar);
		
		return contenedor;
	}

	public static VBox graficarSituacionFaltaEnvido(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonAceptar = getBotonAceptarFaltaEnvido(vista);
		
		Button botonRechazar = getBotonRechazarVarianteEnvido(vista);
		
		contenedor.getChildren().addAll(botonAceptar, botonRechazar);
		
		return contenedor;
	}

	public static VBox graficarSituacionFlor(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonAceptar = getBotonAceptarFlor(vista);
		
		Button botonRechazar = getBotonRechazarFlor(vista);
		
		contenedor.getChildren().addAll(botonAceptar, botonRechazar);
		
		return contenedor;
	}
	
	private static VBox getBotonesSituacionPostEnvidoOFlor(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonTruco = getBotonTruco(vista);
		
		contenedor.getChildren().add(botonTruco);
		
		return contenedor;
	}

	public static VBox graficarSituacionEnvidoAceptada(VistaJuegoDeTruco vista) {
		
		return getBotonesSituacionPostEnvidoOFlor(vista);
	}

	public static VBox graficarSituacionFlorAceptada(VistaJuegoDeTruco vista) {
		
		return getBotonesSituacionPostEnvidoOFlor(vista);
	}

	public static VBox graficarSituacionTrucoAceptado(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonReTruco = getBotonReTruco(vista);
		
		contenedor.getChildren().add(botonReTruco);
		
		return contenedor;
	}

	public static VBox graficarSituacionReTrucoAceptado(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonValeCuatro = getBotonValeCuatro(vista);
		
		contenedor.getChildren().add(botonValeCuatro);
		
		return contenedor;
	}

	public static VBox graficarSituacionValeCuatroAceptado(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		return contenedor;
	}

	public static VBox graficarSituacionCartaJugada(VistaJuegoDeTruco vista) {
		
		VBox contenedor = new VBox();
		
		Button botonTruco = getBotonTruco(vista);
		
		contenedor.getChildren().add(botonTruco);
		
		return contenedor;
	}
}
