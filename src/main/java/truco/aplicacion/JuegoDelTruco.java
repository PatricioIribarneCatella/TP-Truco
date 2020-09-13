package truco.aplicacion;

import javafx.stage.Stage;
import javafx.application.Application;

import truco.modelo.JuegoTruco;
import truco.vista.VistaInicio;

public class JuegoDelTruco extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		JuegoTruco modelo = new JuegoTruco();

		VistaInicio vistaPrincipal = new VistaInicio(modelo, stage);
		vistaPrincipal.mostrar();
	}
}
