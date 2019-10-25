package E0000250;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View2 extends JDialog {
	
	JFrame frame;
	
	View2(JFrame view) {
		super(view, true);
		JLabel label_titulo = new JLabel("HOLA, soy una ventana modal");label_titulo.setFont(new Font("Arial", Font.PLAIN, 30));
		JPanel panelTop = new JPanel();
		panelTop.add(label_titulo);

		
		frame = new JFrame("Ventana modal");

		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		frame.setSize(600, 300);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


}
