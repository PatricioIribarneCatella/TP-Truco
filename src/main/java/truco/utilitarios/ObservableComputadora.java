package truco.utilitarios;

public interface ObservableComputadora {

	public void notifyObserversCarta();
	
	public void notifyObserversCanto();
	
	public void notifyObserversCarta(Object arg);
	
	public void notifyObserversCanto(Object arg);
	
	public void addObserverParaCartas(ObserverCartas o);
	
	public void addObserverParaCantos(ObserverCantos o);
}
