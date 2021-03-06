package truco.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import truco.modelo.JuegoTruco;
import truco.utilitarios.GraficadorBotonesDeCantos;

public abstract class ContenedorAccionesCantos extends VBox {

	protected VistaJuegoDeTruco vista;
	protected JuegoTruco modelo;
	
	public ContenedorAccionesCantos(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.initialize();
	}
	
	private void initialize() {
		
		this.setConfiguracion();
	}

	private void setConfiguracion() {
		
		this.setSpacing(15);
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.TOP_CENTER);
	}
	
	public void limpiarBotones() {
		this.getChildren().clear();
	}
	
	public void graficarBotones(VBox botones) {
		
		this.getChildren().addAll(botones.getChildren());
	}
	
	public VBox getSituacionInicial() {
		
		return GraficadorBotonesDeCantos.graficarSituacionInicial(this.modelo.getPartida(), this.vista);
	}
	
	public void graficarSituacionInicial() {
		
		VBox botones = getSituacionInicial();
		
		limpiarBotones();
		this.getChildren().addAll(botones.getChildren());
	}
	
	protected abstract void cambiarTurnoDeDecision(VBox botones, String nombreJugador);
	
	public void graficarSituacionTruco() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionTruco(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConDecisionTruco());
	}
	
	public void graficarSituacionReTruco() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionReTruco(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConDecisionTruco());
	}
	
	public void graficarSituacionValeCuatro() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionValeCuatro(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConDecisionTruco());
	}
	
	public void graficarSituacionEnvido() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionEnvido(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConDecisionEnvido());
	}
	
	public void graficarSituacionRealEnvido() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionRealEnvido(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConDecisionEnvido());
	}
	
	public void graficarSituacionFaltaEnvido() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionFaltaEnvido(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConDecisionEnvido());
	}
	
	public void graficarSituacionFlor() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionFlor(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConDecisionFlor());
	}

	public void graficarSituacionEnvidoAceptada() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionEnvidoAceptada(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConTurno());
	}

	public void graficarSituacionTrucoAceptado() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionTrucoAceptado(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConTurno());
	}

	public void graficarSituacionReTrucoAceptado() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionReTrucoAceptado(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConTurno());
	}

	public void graficarSituacionValeCuatroAceptado() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionValeCuatroAceptado(this.vista);
		
		limpiarBotones();
		this.cambiarTurnoDeDecision(botones, this.modelo.getNombreJugadorConTurno());
	}
}
