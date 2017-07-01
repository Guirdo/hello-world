package ventanas;

import javax.swing.*;

public class Ventana2 extends JFrame{
	JPanel panel;
	JLabel etiqueta;
	JButton boton;
	
	public Ventana2(){
		panel = new JPanel();
		etiqueta = new JLabel();
		boton = new JButton();
		
		this.add(panel);
		panel.add(etiqueta);
		panel.add(boton);
		
		etiqueta.setText("Hola mundo");
		boton.setText("Oprime");
	}
}
