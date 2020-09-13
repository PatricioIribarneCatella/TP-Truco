package algoritmosyprogramacion3.tp2.vista;

import algoritmosyprogramacion3.tp2.modelo.JuegoTruco;
import javafx.stage.Stage;

public interface Vista {

	public void mostrar();
	
	public Stage getStage();
	
	public JuegoTruco getModelo();
	
	public void setModelo(JuegoTruco modelo);
}
