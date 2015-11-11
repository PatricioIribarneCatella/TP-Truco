package algoritmosyprogramacion3.tp2.modelo;

import algoritmosyprogramacion3.tp2.excepciones.PartidaSinFlorException;

public class Moderador {
	
	private boolean partidaConFlor;
	
	public Moderador(boolean conFlor){
		
		this.partidaConFlor = conFlor;
	}
	
	public boolean seJuegaConFlor(){
		
		if(!this.partidaConFlor){
			throw new PartidaSinFlorException();
		}
		return true;
	}

}
