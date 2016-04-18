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
	Reina(int c, Reina n) {
		this.fila = 1;
		this.columna = c;
		this.vecina = n;
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

	public void paint(Graphics g) {
		// primero dibuja la vecina vecina
		if (this.vecina != null) {
			this.vecina.paint(g);
		}
		// despues a ella misna
		// x, y is upper left corner
		int x = (this.fila - 1) * 50 + 10;
		int y = (this.columna - 1) * 50 + 40;
		g.drawLine(x + 5, y + 45, x + 45, y + 45);
		g.drawLine(x + 5, y + 45, x + 5, y + 5);
		g.drawLine(x + 45, y + 45, x + 45, y + 5);
		g.drawLine(x + 5, y + 35, x + 45, y + 35);
		g.drawLine(x + 5, y + 5, x + 15, y + 20);
		g.drawLine(x + 15, y + 20, x + 25, y + 5);
		g.drawLine(x + 25, y + 5, x + 35, y + 20);
		g.drawLine(x + 35, y + 20, x + 45, y + 5);
		g.drawOval(x + 20, y + 20, 10, 10);
	}

}
