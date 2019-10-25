import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruevaEventos extends JFrame implements ActionListener, KeyListener {

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonRojo = new JButton("Rojo");
	
	public PruevaEventos() {
		setTitle("Botones y Eventos");
		
		setSize(400,200);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(0, 2));
		
		panel1.add(botonAzul);
		panel1.add(botonAmarillo);
		panel1.add(botonRojo);
		
		botonAzul.addActionListener(this);
		botonAzul.addKeyListener(this);
		
		botonRojo.addActionListener(this);
		botonAzul.addKeyListener(this);
		
		botonAmarillo.addActionListener(this);
		botonAzul.addKeyListener(this);
		
		panel1.setBackground(Color.white);

		add(panel1);
		add(panel2);
	}
	
	public static void main(String[] args) {

		PruevaEventos x = new PruevaEventos();
		
		x.setVisible(true);
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if(botonPulsado == botonAzul) panel2.setBackground(Color.blue);
		else if (botonPulsado == botonAmarillo) panel2.setBackground(Color.yellow);
		else if (botonPulsado == botonRojo) panel2.setBackground(Color.red);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		char l = e.getKeyChar();
		switch (l) {
		case 'q':
			panel1.setBackground(Color.blue);
			break;
		case 'w':
			panel1.setBackground(Color.green);
			break;
		case 'e':
			panel1.setBackground(Color.red);
			break;
		case 'r':
			panel1.setBackground(Color.pink);
			break;
		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
