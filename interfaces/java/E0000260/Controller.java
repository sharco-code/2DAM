package E0000260;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Controller {
	private Model model;
	private View view;
	private View2 view2;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		this.view.getBoton().addActionListener(e -> addDialog());
		this.view.setTextTotal("Total: " + getTotal() + "€");
		this.view.getTabla().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {

				int column = view.getTabla().getColumnModel().getColumnIndexAtX(e.getX());

				int row = e.getY() / view.getTabla().getRowHeight();
				if (row < view.getTabla().getRowCount() && row >= 0 && column < view.getTabla().getColumnCount()
						&& column >= 0) {
					Object value = view.getTabla().getValueAt(row, column);
					if (value instanceof JButton) {
						((JButton) value).doClick();
						JButton boton = (JButton) value;

						if (boton.getText().equals("Eliminar")) {
							if (view.questionJOption("¿Quiere eliminar la fila?")) {
								delRow(row);
							}

						}
						if (boton.getText().equals("Modificar")) {
							Object[] values = { view.getTabla().getValueAt(row, 0), view.getTabla().getValueAt(row, 1),
									view.getTabla().getValueAt(row, 2), view.getTabla().getValueAt(row, 3) };
							modifyDialog(values, row);
						}

					}
				}

			}

		});

	}

	private void addRow(Object[] row) {
		model.addRow(row);
		this.view.setTextTotal("Total: " + getTotal() + "€");
		model.fireTableDataChanged();
		view2.dispose();
		view2 = null;
	}

	private double getTotal() {
		double total = 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			total += (double) model.getValueAt(i, 3);
		}
		return total;
	}

	private void addDialog() {		
		view2 = new View2(view);
		view2.getButtonAñadir().addActionListener(e -> addRow(view2.getFruta()));
		view2.setVisible(true);

	}

	private void modifyDialog(Object[] values, int row) {
		view2 = new View2(view, values);
		view2.getButtonAñadir().addActionListener(e -> modifyRow(view2.getFruta(), row));
		view2.setVisible(true);
	}

	private void modifyRow(Object[] values, int row) {
		model.modifyRow(values, row);
		this.view.setTextTotal("Total: " + getTotal() + "€");
		model.fireTableDataChanged();
		view2.dispose();
		view2 = null;
	}

	private void delRow(int row) {
		model.delRow(row);
		this.view.setTextTotal("Total: " + getTotal() + "€");
		model.fireTableDataChanged();
	}

}
