package poligono;

//Linea creada a partir de la pendiente y un punto.
public class Linea {
	//Punto de intercepcion en el eje de las ordenadas (y)
	private double intercepto;
	private int pendiente;
	
	public Linea (int pendiente, Punto punto){
		this.pendiente = pendiente;
		this.intercepto = -this.pendiente*punto.getPosX() + punto.getPosY();
	}
	
	//Ecuacion principal
	@Override
	public String toString(){
		return "y = "+pendiente+"x + ("+intercepto+")";
	}
	
	public String toStringEcuacionGeneral(){
		return this.pendiente+"x - y ("+intercepto+") = 0";
	}
	
	public String puntoCorte(Linea otra){
		double coordenadaX;
		double coordenadaY;
		Punto puntoCorte;
		if (this.pendiente == otra.pendiente) {
			return "paralelas o coincidentes";
		}
		coordenadaX = (this.intercepto-otra.intercepto)/(this.pendiente-otra.pendiente)*(-1);
		coordenadaY = this.pendiente*coordenadaX+this.intercepto;
		
		puntoCorte = new Punto(coordenadaX,coordenadaY);
		
		return puntoCorte.toString();
		
	}

}
