import javax.swing.table.*;

public class idkwhatimdoingkappa extends AbstractTableModel {

	private static final long serialVersionUID = 0;

	private String[] columnNames;
	private Object[][] data;

	public idkwhatimdoingkappa(Object[][] dat, String[] colN) {
		this.columnNames = colN;
		data = dat;
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public Object getValueAt(int r, int c) {
		return data[r][c];
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

}
