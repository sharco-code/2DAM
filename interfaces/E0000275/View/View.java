package E0000275.View;

import E0000275.Controller.*;
import E0000275.Model.TableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import org.json.simple.parser.ParseException;

public class View {

	private JFrame frame;

	private JButton button_marcianito;
	private JTable table;
	private JScrollPane scrollPaneTabla;
	
	
	private TableModel model;
	private Controller controller;
	
	public View() throws ParseException, IOException {

		JTable jTable = new JTable(model);
		JScrollPane sp = new JScrollPane(jTable);

		JLabel label_titulo = new JLabel("Tabla de coches");
		label_titulo.setFont(new Font("Arial", Font.PLAIN, 30));
		JPanel panelTop = new JPanel();
		panelTop.add(label_titulo);

		JPanel panelBot = new JPanel();

		button_marcianito = new JButton("Marcianito 100% real no fake (Ventana Modal)");
		table = new JTable();

		model = new TableModel();
		table.setModel(model);

		controller = new Controller(model, this.frame);
		button_marcianito.addActionListener(controller);

		JPanel ctrlPane = new JPanel();
		panelBot.add(button_marcianito, BorderLayout.CENTER);

		scrollPaneTabla = new JScrollPane(table);

		frame = new JFrame("Programa JSON Jose Galan");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panelTop, BorderLayout.NORTH);
		frame.add(panelBot, BorderLayout.SOUTH);
		frame.add(scrollPaneTabla, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setSize(800, 400);
	}

}
