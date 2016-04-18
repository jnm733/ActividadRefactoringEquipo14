package casoDibujable;

import java.awt.*;
import java.awt.event.*;

class VentanaCerrable extends Frame implements WindowListener {
	// constructores
	public VentanaCerrable() {
		super();
	}

	public VentanaCerrable(String title) {
		super(title);
		setSize(500, 500);
		addWindowListener(this);
	}

	
	@Override
	public void windowActivated(WindowEvent e) {
		//Metodo vac�o porque no se usa
	}
	@Override
	//Metodo vac�o porque no se usa
	public void windowClosed(WindowEvent e) {
		//Metodo vac�o porque no se usa
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		//Metodo vac�o porque no se usa
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		//Metodo vac�o porque no se usa
	}
	@Override
	public void windowIconified(WindowEvent e) {
		//Metodo vac�o porque no se usa
	}
	@Override
	public void windowOpened(WindowEvent e) {
		//Metodo vac�o porque no se usa
	}
} // fin de la clase VentanaCerrable
