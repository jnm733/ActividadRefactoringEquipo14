package poligono;

import java.util.ArrayList;

public class Poligono {

	ArrayList<Punto> poligono;

	public Poligono(ArrayList<Punto> poligono) {
		this.poligono = poligono;
	}

	public boolean concavo(){
		Vector vector1;
		Vector vector2;

		//Creamos vectores a partir de los primeros puntos
		vector1 = new Vector(poligono.get(0), poligono.get(1));
		vector2 = new Vector(poligono.get(1), poligono.get(2));
		double prodVectorial = vector.productoVectorial(vector);
		boolean positivo = prodVectorial >= 0;

		//Calculamos el signo de los dem�s productos vectoriales
		for (int i = 1; i < poligono.size()-2; i++) {
			vector1 = new Vector(poligono.get(i), poligono.get(i+1));
			vector2 = new Vector(poligono.get(i+1), poligono.get(i+2));
			prodVectorial = vector.productoVectorial(vec2);
			//Si tienen distinto signo es c�ncavo
			if (positivo != (prodVectorial >= 0)) {
				return true;
			}
		}
		//Calculamos el producto vectorial del �ltimo y el primer vector
		vector1 = new Vector(poligono.get(i+1), poligono.get(0));
		prodVectorial = vector2.productoVectorial(vec1);
		if (positivo != (prodVectorial >= 0)) {
			return true;
		}
		return false;
	}

	public Punto centroide(){
		double X=0;
		double Y=0;
		double A=0;
		int modulo = poligono.size();
		for (int k = 0; k < poligono.size(); k++) {
			A+=poligono.get(k).getPosX()*poligono.get((k+1)%mod).getPosY()-poligono.get((k+1)%mod).getPosX()*poligono.get(k).getPosY();
		}
		A=A/2;

		for (int k = 0; k < poligono.size(); k++) {
			X+=(poligono.get(k).getPosX()+poligono.get((k+1)%mod).getPosX())*(poligono.get(k).getPosX()*poligono.get((k+1)%mod).getPosY()-poligono.get((k+1)%mod).getPosX()*poligono.get(k).getPosY());
		}
		X=X/(6*A);

		for (int k = 0; k < poligono.size(); k++) {
			Y+=(poligono.get(k).getPosY()+poligono.get((k+1)%mod).getPosY())*(poligono.get(k).getPosX()*poligono.get((k+1)%mod).getPosY()-poligono.get((k+1)%mod).getPosX()*poligono.get(k).getPosY());
		}
		Y=Y/(6*A);
		return new Punto((int) X, (int)Y);
	}

	public String toString(){
		return poligono.toString();
	}


}
