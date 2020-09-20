package truco.modelo;

import java.util.LinkedList;
import java.util.List;

import truco.excepciones.CartaYaJugadaException;
import truco.utilitarios.ObservableComputadora;
import truco.utilitarios.ObserverCantos;
import truco.utilitarios.ObserverCartas;

public class ComputadoraAI extends Jugable implements ObservableComputadora {
	
	private List<ObserverCartas> observadorCartas;
	private List<ObserverCantos> observadorCantos;
	private boolean changed = false;
	
	public ComputadoraAI() {
		
		super();
		this.nombre = "Computadora";
		this.observadorCartas = new LinkedList<ObserverCartas>();
		this.observadorCantos = new LinkedList<ObserverCantos>();
	}
	
	public void darRespuestaAEnvido() {

	     this.moderador.jugadorAceptaVarianteEnvido(this);
	     setChangedComputadora();
	     notifyObserversCanto(new Aceptar());
	}
	
	public void darRespuestaARealEnvido() {
		
	     this.moderador.jugadorAceptaVarianteEnvido(this);
	     setChangedComputadora();
	     notifyObserversCanto(new Aceptar());
	}
	
	public void darRespuestaAFaltaEnvido() {
		
	     this.moderador.jugadorAceptaVarianteEnvido(this);
	     setChangedComputadora();
	     notifyObserversCanto(new Aceptar());
	}
		
	public void darRespuestaATruco() {
		
	     this.moderador.jugadorAceptaVarianteTruco(this);
	     setChangedComputadora();
	     notifyObserversCanto(new Aceptar());
	}
	
	public void darRespuestaATurno() {
		
		  this.jugarCarta();
		  setChangedComputadora();
		  notifyObserversCarta(getCartaJugada());
	}
	
	private Evento jugarCarta() {

		/*Intenta jugar una carta hasta que el juego se lo permita*/
		try{

			this.jugarPrimerCarta();
		}
		catch(CartaYaJugadaException e){
			
			try {
				
				this.jugarSegundaCarta();
			}
			catch(CartaYaJugadaException d){
				
				this.jugarTercerCarta();
			}		
		}
		catch (IndexOutOfBoundsException f) {
			// no hace nada
		}
		return new JugarCarta();
	}

	@Override
	public void addObserverParaCartas(ObserverCartas o) {
		
		if (o == null) throw new NullPointerException();
		
		if (!this.observadorCartas.contains(o)) this.observadorCartas.add(o);
	}

	@Override
	public void addObserverParaCantos(ObserverCantos o) {
		
		if (o == null) throw new NullPointerException();
		
		if (!this.observadorCantos.contains(o)) this.observadorCantos.add(o);
	}

	protected synchronized void setChangedComputadora() {
        changed = true;
    }
	
	protected synchronized void clearChanged() {
        changed = false;
    }
	
	@Override
	public void notifyObserversCarta() {
		notifyObserversCarta(null);
	}

	@Override
	public void notifyObserversCanto() {
		notifyObserversCanto(null);
	}

	@Override
	public void notifyObserversCarta(Object arg) {
		
        Object[] arrLocal;

        synchronized (this) {
        	
            if (!changed) return;
            arrLocal = observadorCartas.toArray();
            clearChanged();
        }
        
        for (int i = arrLocal.length-1; i>=0; i--) {
        	((ObserverCartas)arrLocal[i]).updateCarta(this, arg);
        } 
	}

	@Override
	public void notifyObserversCanto(Object arg) {
		
        Object[] arrLocal;

        synchronized (this) {
        	
            if (!changed) return;
            arrLocal = observadorCantos.toArray();
            clearChanged();
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            ((ObserverCantos)arrLocal[i]).updateCanto(this, arg);
	}
}
