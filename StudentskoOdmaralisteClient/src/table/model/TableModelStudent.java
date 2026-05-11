package table.model;

import domain.Student;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelStudent extends AbstractTableModel {

    private List<Student> students = new ArrayList<>();
    private String[] columns = {"ID", "Ime", "Prezime", "Telefon", "Fakultet", "Budzet"};

    public TableModelStudent() {
    }

    public TableModelStudent(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
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
        Student student = students.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getIdStudent();
            case 1:
                return student.getIme();
            case 2:
                return student.getPrezime();
            case 3:
                return student.getBrTelefona();
            case 4:
                return student.getFakultet() != null ? student.getFakultet().toString() : "n/a";
            case 5:
                return student.isBudzet() ? "Da" : "Ne";
            default:
                return "n/a";
        }
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        fireTableDataChanged();
    }

    public Student getStudentAt(int rowIndex) {
        return students.get(rowIndex);
    }
}
