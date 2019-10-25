package E0000250;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel {

	private final String[] columns = { "Marca", "Modelo", "Precio" };
	private ArrayList<Object[]> table;
	private static final DecimalFormat formatter = new DecimalFormat("#.00");
	
	Model() {
		table = new ArrayList<>();
		
		Object o1[] = { "Opel", "Astra", new Double(13000) };
		Object o2[] = { "Audi", "R8", new Double(13000) };
		Object o3[] = { "Ford", "Focus", new Double(1000) };
		Object o4[] = { "Ford", "Focus", new Double(1000) };
		table.add(o1);
		table.add(o2);
		table.add(o3);
		table.add(o4);
	}
	

	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return table.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return table.get(rowIndex)[columnIndex];
	}

}
