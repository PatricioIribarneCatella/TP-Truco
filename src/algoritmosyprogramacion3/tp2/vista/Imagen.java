package algoritmosyprogramacion3.tp2.vista;

public class Imagen {

	private String url;
	private double width;
	private double heigth;
	private boolean preserveRatio;
	private boolean smooth;
	
	public Imagen(String url, double width, double heigth, boolean preserveRatio, boolean smooth) {
		
		this.url = url;
		this.width = width;
		this.heigth = heigth;
		this.preserveRatio = preserveRatio;
		this.smooth = smooth;
	}

	public String getUrl() {
		return this.url;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeigth() {
		return this.heigth;
	}
	
	public boolean getPreserveRatio() {
		return this.preserveRatio;
	}
	
	public boolean getSmooth() {
		return this.smooth;
	}
}
