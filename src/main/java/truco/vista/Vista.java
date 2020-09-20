package truco.vista;

import javafx.stage.Stage;

import truco.modelo.JuegoTruco;

public interface Vista {

	public void mostrar();
	
	public Stage getStage();
	
	public JuegoTruco getModelo();
	
	public void setModelo(JuegoTruco modelo);
}
