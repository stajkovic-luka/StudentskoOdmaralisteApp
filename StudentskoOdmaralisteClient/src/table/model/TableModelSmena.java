package table.model;

import domain.Smena;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelSmena extends AbstractTableModel {

    private List<Smena> smene = new ArrayList<>();
    private String[] columns = {"ID", "Prostorija", "Komentar", "Tip smene"};

    public TableModelSmena() {
    }

    public TableModelSmena(List<Smena> smene) {
        this.smene = smene;
    }

    @Override
    public int getRowCount() {
        return smene.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Smena smena = smene.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return smena.getIdSmena();
            case 1:
                return smena.getProstorija();
            case 2:
                return smena.getKomentar();
            case 3:
                return smena.getTipSmene();
            default:
                return "n/a";
        }
    }

    public void setSmene(List<Smena> smene) {
        this.smene = smene;
        fireTableDataChanged();
    }

    public Smena getSmenaAt(int rowIndex) {
        return smene.get(rowIndex);
    }
}
