package ochoreinas;

//Eight Reinas puzzle written in Java
//Written by Tim Budd, January 1996
//revised for 1.3 event model July 2001
//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaReinas extends Frame {

	private class CloseQuit extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	private class MouseKeeper extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			//Avanzar cuando ya hay una solución dada
			ultimaReina.avanza();
			repaint();
		}
	}

	public static void main(String[] args) {
		VentanaReinas world = new VentanaReinas();
		world.show();
	}

	private Reina ultimaReina = null;

	public VentanaReinas() {
		setTitle("Problema de las ocho reinas");
		setSize(600, 500);
		
		ultimaReina = Reina.calcularTablero();
		
		addMouseListener(new MouseKeeper());
		addWindowListener(new CloseQuit());
	}

	@Override
	public void paint(Graphics context) {
		super.paint(context);
		// dibuja el tablero
		for (int i = 0; i <= 8; i++) {
			context.drawLine(50 * i + 10, 40, 50 * i + 10, 440);
			context.drawLine(10, 50 * i + 40, 410, 50 * i + 40);
		}
		context.drawString("Pulse con para una nueva solución", 20, 470);
		// dibuja las reinas
		this.ultimaReina.pintarSolucion(context);
	}
}
