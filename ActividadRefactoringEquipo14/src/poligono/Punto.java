package poligono;

public class Punto {

	double posX;
	double posY;
	
	public Punto(double posX,double posY){
		this.posX=posX;
		this.posY=posY;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	@Override
	public String toString(){
		return "("+getPosX()+","+getPosY()+")";
	}
	
}
