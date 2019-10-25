package E0000260;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel {

	private final String columns[] = { "ID", "Marca", "Modelo", "Precio", "Menu desplegable", "Eliminar", "Modificar" };

	private ArrayList<Object[]> table;
	
	private final String[] comboValues = { "Valor 1", "Valor 2", "Valor 3" };
	
	private JButton button_Modify = new JButton("Modificar");
	private JButton button_Delete = new JButton("Eliminar");
	
	private JComboBox comboBox = new JComboBox(comboValues);

	Model() {

		table = new ArrayList<>();

		Object o1[] = { "0", "Opel", "Astra", new Double(1300000), comboBox, button_Delete, button_Modify };
		Object o2[] = { "1", "Audi", "R8", new Double(1300011), comboBox, button_Delete, button_Modify };
		Object o3[] = { "2", "Ford", "Focus", new Double(102210), comboBox, button_Delete, button_Modify };
		Object o4[] = { "3", "Ford", "Fiesta", new Double(102110), comboBox, button_Delete, button_Modify };
		table.add(o1);
		table.add(o2);
		table.add(o3);
		table.add(o4);

	}

	@Override
	public String getColumnName(int col) {
		return columns[col];
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return table.size();
	}

	@Override
	public Object getValueAt(int x, int y) {
		return table.get(x)[y];
	}

	public void addRow(Object[] row) {
		Object _row[] = { row[0], row[1], row[2], row[3], comboBox, button_Delete, button_Modify };
		table.add(_row);
	}

	public void delRow(int row) {
		table.remove(row);
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public String[] getComboValues() {
		return comboValues;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (columnIndex == 4)
			return true;
		return super.isCellEditable(rowIndex, columnIndex);
	}

	public void modifyRow(Object[] values, int row) {
		Object[] newValues = { values[0], values[1], values[2], values[3], comboBox, button_Delete, button_Modify };
		table.set(row, newValues);

	}


}
