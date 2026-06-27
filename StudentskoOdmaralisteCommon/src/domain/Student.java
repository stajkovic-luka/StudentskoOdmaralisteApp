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

    @Override
    public void setGeneratedPrimaryKey(long generatedPrimaryKey) {
        this.idStudent = generatedPrimaryKey;
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
    public String toString() {
        return ime + " " + prezime;
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
    public String selectJoinColumns() {
        return "s.idStudent, s.ime, s.prezime, s.brTelefona, s.budzet, s.idFakultet, f.naziv AS fNaziv, f.mesto AS fMesto, f.akreditovan AS fAkreditovan";
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

    @Override
    public String insertColumns() {
        return "ime, prezime, brTelefona, budzet, idFakultet";
    }

    @Override
    public String insertValuesClause() {
        return "?, ?, ?, ?, ?";
    }

    @Override
    public void bindInsertParams(PreparedStatement ps) throws SQLException {
        ps.setString(1, ime);
        ps.setString(2, prezime);
        ps.setLong(3, brTelefona);
        ps.setBoolean(4, budzet);
        ps.setLong(5, fakultet.getIdFakultet());
    }

    @Override
    public String updateSetClause() {
        return "ime=?, prezime=?, brTelefona=?, budzet=?, idFakultet=?";
    }

    @Override
    public String updateWhereClause() {
        return "idStudent=?";
    }

    @Override
    public void bindUpdateParams(PreparedStatement ps) throws SQLException {
        ps.setString(1, ime);
        ps.setString(2, prezime);
        ps.setLong(3, brTelefona);
        ps.setBoolean(4, budzet);
        ps.setLong(5, fakultet.getIdFakultet());
        ps.setLong(6, idStudent);
    }

    @Override
    public String deleteWhereClause() {
        return selectWhereClause();
    }

    @Override
    public void bindDeleteParams(PreparedStatement ps) throws SQLException {
        bindSelectParams(ps);
    }

    private String searchKriterijum;
    private String searchVrednost;

    public String getSearchKriterijum() {
        return searchKriterijum;
    }

    public void setSearchKriterijum(String searchKriterijum) {
        this.searchKriterijum = searchKriterijum;
    }

    public String getSearchVrednost() {
        return searchVrednost;
    }

    public void setSearchVrednost(String searchVrednost) {
        this.searchVrednost = searchVrednost;
    }

    @Override
    public String searchWhereClause() {
        if (searchKriterijum == null || searchVrednost == null || searchVrednost.isBlank()) {
            return "";
        }
        return switch (searchKriterijum) {
            case "Ime" -> "s.ime LIKE ?";
            case "Prezime" -> "s.prezime LIKE ?";
            case "Broj telefona" -> "CAST(s.brTelefona AS CHAR) LIKE ?";
            case "Fakultet" -> "f.naziv LIKE ?";
            default -> "";
        };
    }

    @Override
    public void bindSearchParams(PreparedStatement ps) throws SQLException {
        if (searchKriterijum != null && searchVrednost != null && !searchVrednost.isBlank()) {
            ps.setString(1, "%" + searchVrednost + "%");
        }
    }

    @Override
    public String joinFromClause() {
        return "student s JOIN fakultet f ON s.idFakultet = f.idFakultet";
    }

    @Override
    public String joinWhereClause() {
        return searchWhereClause();
    }

    @Override
    public void bindJoinParams(PreparedStatement ps) throws SQLException {
        bindSearchParams(ps);
    }

    @Override
    public List<DomainObject> mapJoined(ResultSet rs) throws SQLException {
        List<DomainObject> studenti = new ArrayList<>();
        while (rs.next()) {
            studenti.add(mapStudentJoined(rs));
        }
        return studenti;
    }

    private Student mapStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        
        student.setIdStudent(rs.getLong("idStudent"));
        student.setIme(rs.getString("ime"));
        student.setPrezime(rs.getString("prezime"));
        student.setBrTelefona(rs.getLong("brTelefona"));
        student.setBudzet(rs.getBoolean("budzet"));

        Fakultet studentFakultet = new Fakultet();
        studentFakultet.setIdFakultet(rs.getLong("idFakultet"));
        student.setFakultet(studentFakultet);

        return student;
    }

    private Student mapStudentJoined(ResultSet rs) throws SQLException {
        Student student = new Student();
        
        student.setIdStudent(rs.getLong("idStudent"));
        student.setIme(rs.getString("ime"));
        student.setPrezime(rs.getString("prezime"));
        student.setBrTelefona(rs.getLong("brTelefona"));
        student.setBudzet(rs.getBoolean("budzet"));

        Fakultet studentFakultet = new Fakultet();
        studentFakultet.setIdFakultet(rs.getLong("idFakultet"));
        studentFakultet.setNaziv(rs.getString("fNaziv"));
        studentFakultet.setMesto(rs.getString("fMesto"));
        studentFakultet.setAkreditovan(rs.getBoolean("fAkreditovan"));
        student.setFakultet(studentFakultet);

        return student;
    }
}
