package interfaz;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Boton extends JButton {

	public Boton(String nombre) {
		super(nombre);
		miBoton();
	}
	
	public void miBoton() {
		this.setBackground(new Color(222, 222, 222));
		this.setBorder(new LineBorder(Color.GRAY));
	}
	
}
