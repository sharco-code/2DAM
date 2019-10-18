package E0000250;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View {

	JFrame frame;

	double getdata(DefaultTableModel dtm) {
		double x = 0;
		for (int i = 0; i < dtm.getRowCount(); i++) {
			x += (double)dtm.getValueAt(i, 2);
		}
		return x;
	}
	
	View(Model model) {
		
		
		
		JTable jTable = new JTable(model);
		JScrollPane sp = new JScrollPane(jTable);
		
		JLabel label_titulo = new JLabel("Coches");label_titulo.setFont(new Font("Arial", Font.PLAIN, 30));
		JPanel panelTop = new JPanel();
		panelTop.add(label_titulo);
		
			JButton button_insertar = new JButton("Ventana Modal");
			button_insertar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					View2 view2 = new View2(frame);
					
				}
			});
			JPanel panelBotWEST = new JPanel();
			panelBotWEST.add(button_insertar);
			
			JLabel label_total = new JLabel("Total: €");
			JPanel panelBotEAST = new JPanel();
			panelBotEAST.add(label_total);
			
				JPanel panelBot = new JPanel(new GridLayout(1,2, 20,0));
				panelBot.add(panelBotWEST);
				panelBot.add(panelBotEAST);
		
		frame = new JFrame("Aplicacion de Jose Galan Simo 2DAM");

		frame.getContentPane().add(sp, BorderLayout.CENTER);
		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		frame.getContentPane().add(panelBot, BorderLayout.SOUTH);
		frame.setSize(900, 500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
