package table.model;

import domain.StavkaFakture;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelStavke extends AbstractTableModel {

    private List<StavkaFakture> stavke = new ArrayList<>();
    private String[] columns = {"Rb", "Nocenje", "Datum od", "Datum do", "Dorucak", "Cena", "Br. dana", "Dod. troskovi", "Iznos"};

    public TableModelStavke() {
    }

    public TableModelStavke(List<StavkaFakture> stavke) {
        this.stavke = stavke;
    }

    @Override
    public int getRowCount() {
        return stavke.size();
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
        StavkaFakture s = stavke.get(rowIndex);
        switch (columnIndex) {
            case 0: return s.getRb();
            case 1: return s.getNocenje() != null ? s.getNocenje().toString() : "n/a";
            case 2: return s.getDatumOd() != null ? s.getDatumOd().toString() : "";
            case 3: return s.getDatumDo() != null ? s.getDatumDo().toString() : "";
            case 4: return s.isDorucakUkljucen() ? "Da" : "Ne";
            case 5: return s.getCena();
            case 6: return s.getBrojDana();
            case 7: return s.getDodatniTroskovi();
            case 8: return s.getIznos();
            default: return "n/a";
        }
    }

    public void setStavke(List<StavkaFakture> stavke) {
        this.stavke = stavke != null ? stavke : new ArrayList<>();
        fireTableDataChanged();
    }

    public StavkaFakture getStavkaAt(int rowIndex) {
        return stavke.get(rowIndex);
    }
}
