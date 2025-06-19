package table;

import domain.Sluzbenik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ServerTableModel extends AbstractTableModel {

    List<Sluzbenik> listaSluzbenik;

    public ServerTableModel(List<Sluzbenik> listaSluzbenik) {
        this.listaSluzbenik = listaSluzbenik;

    }

    private String[] columnName = {"Ime", "Prezime"};

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 -> {
                return columnName[0];
            }

            case 1 -> {
                return columnName[1];
            }
            default -> {
                return "N/A";
            }
        }
    }

    @Override
    public int getRowCount() {
        return listaSluzbenik.size();

    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sluzbenik sluzbenik = listaSluzbenik.get(rowIndex);
        System.out.println("ROW:"+rowIndex);
        System.out.println(sluzbenik.getIme());
        switch (columnIndex) {
            case 0 -> {
                return sluzbenik.getIme();
            }
            case 1 -> {
                return sluzbenik.getPrezime();
            }
            default -> {
                return "N/A";
            }
        }

    }

    public void setListaSluzbenik(List<Sluzbenik> listaSluzbenik) {
        this.listaSluzbenik = listaSluzbenik;
        fireTableDataChanged();
    }
    
    

}
