package ochoreinas;

import java.awt.*;
//
//Eight Reinas puzzle written in Java
//Written by Tim Budd, January 1996
//revised for 1.3 event model July 2001
//

class Reina {
	// datos
	private int fila;
	private int columna;
	private Reina vecina;

	// constructor
	Reina(int columna, Reina vecina) {
		this.fila = 1;
		this.columna = columna;
		this.vecina = vecina;
	}

	public boolean buscaSolucion() {
		while (this.vecina != null && this.vecina.puedeAtacar(this.fila, this.columna)) {
			if (!avanza()) {
				return false;
			}
		}
		return true;
	}

	
	
	public boolean avanza() {
		if (this.fila < 8) {
			this.fila++;
			return buscaSolucion();
		}
		if (this.vecina == null || !this.vecina.avanza() || !this.vecina.buscaSolucion()) {
			return false;
		}
		this.fila = 1;
		return buscaSolucion();

	}

	/**
	 *
	 * @param testfila
	 * @param testcolumna
	 * @return true si puede atacar, false en caso contrario.
	 */
	private boolean puedeAtacar(int testfila, int testcolumna) {
		int columnaDiferencia = testcolumna - this.columna;
		if ((this.fila == testfila) || (this.fila + columnaDiferencia == testfila) || (this.fila - columnaDiferencia == testfila)) {
			return true;
		}
		if (this.vecina != null) {
			return this.vecina.puedeAtacar(testfila, testcolumna);
		}
		return false;
	}

	public void pintarSolucion(Graphics context) {
		// primero dibuja la vecina vecina
		if (this.vecina != null) {
			this.vecina.pintarSolucion(context);
		}
		// despues a ella misna
		// x, y is upper left corner
		int x = (this.fila - 1) * 50 + 10;
		int y = (this.columna - 1) * 50 + 40;
		pintarReina(context, x, y);
	}
	
	public static Reina calcularTablero(){
		Reina ultimaReina = null;
		for (int i = 1; i <= 8; i++) {
			ultimaReina = new Reina(i, ultimaReina);
			ultimaReina.buscaSolucion();
		}
		return ultimaReina;
	}

	/**
	 * @param context
	 * @param x
	 * @param y
	 */
	private void pintarReina(Graphics context, int x, int y) {
		context.drawLine(x + 5, y + 45, x + 45, y + 45);
		context.drawLine(x + 5, y + 45, x + 5, y + 5);
		context.drawLine(x + 45, y + 45, x + 45, y + 5);
		context.drawLine(x + 5, y + 35, x + 45, y + 35);
		context.drawLine(x + 5, y + 5, x + 15, y + 20);
		context.drawLine(x + 15, y + 20, x + 25, y + 5);
		context.drawLine(x + 25, y + 5, x + 35, y + 20);
		context.drawLine(x + 35, y + 20, x + 45, y + 5);
		context.drawOval(x + 20, y + 20, 10, 10);
	}

}
