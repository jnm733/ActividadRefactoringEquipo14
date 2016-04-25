package poligono;

import java.util.ArrayList;

public class Poligono {

	ArrayList<Punto> poligono;

	public Poligono(ArrayList<Punto> poligono) {
		this.poligono = poligono;
	}

	public boolean concavo(){

		//Creamos vectores a partir de los primeros puntos
		boolean positivo = esProductoVectorialPositivo(new Vector(poligono.get(0), poligono.get(1)), new Vector(poligono.get(1), poligono.get(2)));

		//Calculamos el signo de los dem�s productos vectoriales
		for (int i = 1; i < poligono.size()-2; i++) {
			//Si tienen distinto signo es c�ncavo
			if (positivo != esProductoVectorialPositivo(new Vector(poligono.get(i), poligono.get(i+1)), new Vector(poligono.get(i+1), poligono.get(i+2)))) {
				return true;
			}
		}
		//Calculamos el producto vectorial del �ltimo y el primer vector
		if (positivo != esProductoVectorialPositivo(new Vector(poligono.get(poligono.size() - 2), poligono.get(poligono.size() - 1)), new Vector(poligono.get(poligono.size() - 1), poligono.get(0)))) {
			return true;
		}
		return false;
	}

	private boolean esProductoVectorialPositivo(Vector vector1, Vector vector2){
		return vector1.prodVectorial(vector2) >=0;
	}

	public Punto centroide(){
		double X=0;
		double Y=0;
		double A=0;
		int moduloulo = poligono.size();
		for (int k = 0; k < poligono.size(); k++) {
			A+=poligono.get(k).getPosX()*poligono.get((k+1)%modulo).getPosY()-poligono.get((k+1)%modulo).getPosX()*poligono.get(k).getPosY();
			X+=(poligono.get(k).getPosX()+poligono.get((k+1)%modulo).getPosX())*(poligono.get(k).getPosX()*poligono.get((k+1)%modulo).getPosY()-poligono.get((k+1)%modulo).getPosX()*poligono.get(k).getPosY());
			Y+=(poligono.get(k).getPosY()+poligono.get((k+1)%modulo).getPosY())*(poligono.get(k).getPosX()*poligono.get((k+1)%modulo).getPosY()-poligono.get((k+1)%modulo).getPosX()*poligono.get(k).getPosY());
		}
		A=A/2;
		X=X/(6*A);
		Y=Y/(6*A);
		return new Punto((int) X, (int)Y);
	}

	public String toString(){
		return poligono.toString();
	}


}
