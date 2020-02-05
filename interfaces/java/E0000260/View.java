package E0000260;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class View extends JFrame {

	private JTable jTable;
	private JFrame frame;

	private TableColumn column;
	private JComboBox comboBox;
	
	private JButton button_insertar;
	private JLabel label_total;
	
	View(Model model) {

		jTable = new JTable(model);

		comboBox = new JComboBox<>(model.getComboValues());

		column = jTable.getColumnModel().getColumn(4);
		column.setCellEditor(new DefaultCellEditor(comboBox));

		jTable.setDefaultRenderer(Object.class, new Render());
		JScrollPane sp = new JScrollPane(jTable);

		JLabel label_titulo = new JLabel("Coches");
		label_titulo.setFont(new Font("Arial", Font.PLAIN, 30));
		JPanel panelTop = new JPanel();
		panelTop.add(label_titulo);

		button_insertar = new JButton("Ventana Modal");
		button_insertar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				View2 view2 = new View2(frame);

			}
		});

		JPanel panelBotWEST = new JPanel();
		panelBotWEST.add(button_insertar);

		label_total = new JLabel("Total: €");
		JPanel panelBotEAST = new JPanel();
		panelBotEAST.add(label_total);

		JPanel panelBot = new JPanel(new GridLayout(1, 2, 20, 0));
		panelBot.add(panelBotWEST);
		panelBot.add(panelBotEAST);

		frame = new JFrame("Aplicacion de sharco");

		frame.getContentPane().add(sp, BorderLayout.CENTER);
		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		frame.getContentPane().add(panelBot, BorderLayout.SOUTH);
		frame.setSize(900, 500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;

	}

	public JTable getTabla() {
		return jTable;
	}

	public JButton getBoton() {
		return button_insertar;
	}

	public void setTextTotal(String total) {
		label_total.setText(total);
	}

	public boolean questionJOption(String text) {
		int valor = JOptionPane.showConfirmDialog(this, text + "");
		if (valor == 0)
			return true;
		return false;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	class Render extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub

			if (value instanceof JButton) {
				JButton boton = (JButton) value;
				return boton;
			}
			if (value instanceof JComboBox) {
				JComboBox JComboBox = (JComboBox) value;
				return JComboBox;
			}
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	}

	// -------------------------------------------------------------------

}
