package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.utilitarios.GraficadorBotonesDeCantos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class ContenedorAccionesCantos extends VBox {

	private VistaJuegoDeTruco vista;
	private JuegoTruco modelo;
	
	public ContenedorAccionesCantos(VistaJuegoDeTruco vista, JuegoTruco modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.initialize();
	}
	
	private void initialize() {
		
		this.setConfiguracion();
		this.setElementos();
	}

	private void setConfiguracion() {
		
		this.setSpacing(15);
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.TOP_CENTER);
	}

	private void setElementos() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionInicial(this.modelo.seJuegaConFlor(), this.vista);
		
		this.getChildren().addAll(botones.getChildren());
	}
	
	public void graficarSituacionTruco() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionTruco(this.vista);
		
		this.getChildren().addAll(botones.getChildren());
	}
	
	public void graficarSituacionReTruco() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionReTruco(this.vista);
		
		this.getChildren().addAll(botones.getChildren());
	}
	
	public void graficarSituacionValeCuatro() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionValeCuatro(this.vista);
		
		this.getChildren().addAll(botones.getChildren());
	}
	
	public void graficarSituacionEnvido() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionEnvido(this.vista);
		
		this.getChildren().addAll(botones.getChildren());
	}
	
	public void graficarSituacionRealEnvido() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionRealEnvido(this.vista);
		
		this.getChildren().addAll(botones.getChildren());
	}
	
	public void graficarSituacionFaltaEnvido() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionFaltaEnvido(this.vista);
		
		this.getChildren().addAll(botones.getChildren());
	}
	
	public void graficarSituacionFlor() {
		
		VBox botones = GraficadorBotonesDeCantos.graficarSituacionFlor(this.vista);
		
		this.getChildren().addAll(botones.getChildren());
	}
}
