package algoritmosyprogramacion3.tp2.aplicacion;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import algoritmosyprogramacion3.tp2.vista.VistaInicio;
import javafx.application.Application;
import javafx.stage.Stage;

public class JuegoDelTruco extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		JuegoTruco modelo = new JuegoTruco();
		
		VistaInicio vistaPrincipal = new VistaInicio(modelo, stage);
		vistaPrincipal.mostrar();
	}

	public static void main(String[] args){
		launch(args);
	}
}
