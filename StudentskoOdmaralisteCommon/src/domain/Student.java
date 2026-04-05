/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lukas
 */
public class Student extends DomainObject {

    private long idStudent;
    private String ime;
    private String prezime;
    private long brTelefona;    
    private boolean budzet;
    private Fakultet fakultet;

    public Student() {
    }

    public Student(long idStudent, String ime, String prezime, long brTelefona, boolean budzet, Fakultet fakultet) {
        this.idStudent = idStudent;
        this.ime = ime;
        this.prezime = prezime;
        this.brTelefona = brTelefona;
        this.budzet = budzet;
        this.fakultet = fakultet;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public long getBrTelefona() {
        return brTelefona;
    }

    public void setBrTelefona(long brTelefona) {
        this.brTelefona = brTelefona;
    }

    public boolean isBudzet() {
        return budzet;
    }

    public void setBudzet(boolean budzet) {
        this.budzet = budzet;
    }

    public Fakultet getFakultet() {
        return fakultet;
    }

    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }

    @Override
    public String tableName() {
        return "student";
    }

    @Override
    public String selectColumns() {
        return "idStudent, ime, prezime, brTelefona, budzet, idFakultet";
    }

    @Override
    public List<DomainObject> mapMany(ResultSet rs) throws SQLException {
        List<DomainObject> studenti = new ArrayList<>();
        while (rs.next()) {
            studenti.add(mapStudent(rs));
        }
        return studenti;
    }

    @Override
    public DomainObject mapOne(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return mapStudent(rs);
        }
        return null;
    }

    @Override
    public String selectWhereClause() {
        return "idStudent=?";
    }

    @Override
    public void bindSelectParams(PreparedStatement ps) throws SQLException {
        ps.setLong(1, idStudent);
    }

    private Student mapStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setIdStudent(rs.getLong("idStudent"));
        student.setIme(rs.getString("ime"));
        student.setPrezime(rs.getString("prezime"));
        student.setBrTelefona(rs.getLong("brTelefona"));
        student.setBudzet(rs.getBoolean("budzet"));

        Fakultet studentFakultet = new Fakultet();
        studentFakultet.setIdFakultet(rs.getInt("idFakultet"));
        student.setFakultet(studentFakultet);

        return student;
    }
}
