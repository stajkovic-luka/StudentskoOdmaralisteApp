package table.model;

import domain.FakturaOdmora;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelFaktura extends AbstractTableModel {

    private List<FakturaOdmora> fakture = new ArrayList<>();
    private String[] columns = {"ID", "Sluzbenik", "Student", "Ukupan iznos", "Popust", "Nakon popusta", "Napomena"};

    public TableModelFaktura() {
    }

    public TableModelFaktura(List<FakturaOdmora> fakture) {
        this.fakture = fakture;
    }

    @Override
    public int getRowCount() {
        return fakture.size();
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
        FakturaOdmora faktura = fakture.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return faktura.getIdFaktura();
            case 1:
                return faktura.getSluzbenik() != null
                        ? faktura.getSluzbenik().getIme() + " " + faktura.getSluzbenik().getPrezime()
                        : "n/a";
            case 2:
                return faktura.getStudent() != null
                        ? faktura.getStudent().getIme() + " " + faktura.getStudent().getPrezime()
                        : "n/a";
            case 3:
                return faktura.getUkupanIznos();
            case 4:
                return (faktura.getPopust() * 100) + "%";
            case 5:
                return faktura.getIznosNakonPopusta();
            case 6:
                return faktura.getNapomena() != null ? faktura.getNapomena() : "";
            default:
                return "n/a";
        }
    }

    public void setFakture(List<FakturaOdmora> fakture) {
        this.fakture = fakture;
        fireTableDataChanged();
    }

    public FakturaOdmora getFakturaAt(int rowIndex) {
        return fakture.get(rowIndex);
    }
}
