package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FakturaOdmora extends DomainObject {

    private long idFaktura;
    private double popust;
    private double iznosNakonPopusta;
    private double ukupanIznos;
    private String napomena;
    private Student student;
    private Sluzbenik sluzbenik;
    private List<StavkaFakture> stavkeFakture = new ArrayList<>();

    public FakturaOdmora() {
    }

    public FakturaOdmora(long idFaktura, double popust, double iznosNakonPopusta, double ukupanIznos, String napomena, Student student, Sluzbenik sluzbenik) {
        this.idFaktura = idFaktura;
        this.popust = popust;
        this.iznosNakonPopusta = iznosNakonPopusta;
        this.ukupanIznos = ukupanIznos;
        this.napomena = napomena;
        this.student = student;
        this.sluzbenik = sluzbenik;
    }

    public long getIdFaktura() {
        return idFaktura;
    }

    public void setIdFaktura(long idFaktura) {
        this.idFaktura = idFaktura;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public double getIznosNakonPopusta() {
        return iznosNakonPopusta;
    }

    public void setIznosNakonPopusta(double iznosNakonPopusta) {
        this.iznosNakonPopusta = iznosNakonPopusta;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Sluzbenik getSluzbenik() {
        return sluzbenik;
    }

    public void setSluzbenik(Sluzbenik sluzbenik) {
        this.sluzbenik = sluzbenik;
    }

    public List<StavkaFakture> getStavkeFakture() {
        return stavkeFakture;
    }

    public void setStavkeFakture(List<StavkaFakture> stavkeFakture) {
        this.stavkeFakture = stavkeFakture;
    }

    @Override
    public String tableName() {
        return "fakturaodmora";
    }

    @Override
    public String selectColumns() {
        return "idFaktura, popust, iznosNakonPopusta, ukupanIznos, napomena, idSluzbenik, idStudent";
    }

    @Override
    public List<DomainObject> mapMany(ResultSet rs) throws SQLException {
        List<DomainObject> fakture = new ArrayList<>();
        while (rs.next()) {
            fakture.add(mapFakturaOdmora(rs));
        }
        return fakture;
    }

    @Override
    public DomainObject mapOne(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return mapFakturaOdmora(rs);
        }
        return null;
    }

    @Override
    public String selectWhereClause() {
        return "idFaktura=?";
    }

    @Override
    public void bindSelectParams(PreparedStatement ps) throws SQLException {
        ps.setLong(1, idFaktura);
    }

    @Override
    public String insertColumns() {
        return "popust, iznosNakonPopusta, ukupanIznos, napomena, idSluzbenik, idStudent";
    }

    @Override
    public String insertValuesClause() {
        return "?, ?, ?, ?, ?, ?";
    }

    @Override
    public void bindInsertParams(PreparedStatement ps) throws SQLException {
        ps.setDouble(1, popust);
        ps.setDouble(2, iznosNakonPopusta);
        ps.setDouble(3, ukupanIznos);
        ps.setString(4, napomena);
        ps.setLong(5, sluzbenik.getIdSluzbenik());
        ps.setLong(6, student.getIdStudent());
    }

    @Override
    public String updateSetClause() {
        return "popust=?, iznosNakonPopusta=?, ukupanIznos=?, napomena=?, idSluzbenik=?, idStudent=?";
    }

    @Override
    public String updateWhereClause() {
        return "idFaktura=?";
    }

    @Override
    public void bindUpdateParams(PreparedStatement ps) throws SQLException {
        ps.setDouble(1, popust);
        ps.setDouble(2, iznosNakonPopusta);
        ps.setDouble(3, ukupanIznos);
        ps.setString(4, napomena);
        ps.setLong(5, sluzbenik.getIdSluzbenik());
        ps.setLong(6, student.getIdStudent());
        ps.setLong(7, idFaktura);
    }

    @Override
    public String deleteWhereClause() {
        return selectWhereClause();
    }

    @Override
    public void bindDeleteParams(PreparedStatement ps) throws SQLException {
        bindSelectParams(ps);
    }

    @Override
    public String searchWhereClause() {
        return selectWhereClause();
    }

    @Override
    public void bindSearchParams(PreparedStatement ps) throws SQLException {
        bindSelectParams(ps);
    }

    @Override
    public String selectJoinColumns() {
        return "fo.idFaktura, fo.popust, fo.iznosNakonPopusta, fo.ukupanIznos, fo.napomena, "
                + "fo.idSluzbenik, fo.idStudent, "
                + "sl.ime AS slIme, sl.prezime AS slPrezime, sl.korisnickoIme AS slKorisnickoIme, "
                + "st.ime AS stIme, st.prezime AS stPrezime, st.brTelefona AS stBrTelefona, "
                + "st.budzet AS stBudzet, st.idFakultet AS stIdFakultet";
    }

    @Override
    public String joinFromClause() {
        return "fakturaodmora fo "
                + "JOIN sluzbenik sl ON fo.idSluzbenik = sl.idSluzbenik "
                + "JOIN student st ON fo.idStudent = st.idStudent";
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
        List<DomainObject> fakture = new ArrayList<>();
        while (rs.next()) {
            fakture.add(mapFakturaJoined(rs));
        }
        return fakture;
    }

    private FakturaOdmora mapFakturaJoined(ResultSet rs) throws SQLException {
        FakturaOdmora faktura = new FakturaOdmora();
        faktura.setIdFaktura(rs.getLong("idFaktura"));
        faktura.setPopust(rs.getDouble("popust"));
        faktura.setIznosNakonPopusta(rs.getDouble("iznosNakonPopusta"));
        faktura.setUkupanIznos(rs.getDouble("ukupanIznos"));
        faktura.setNapomena(rs.getString("napomena"));

        Sluzbenik fakturaSluzbenik = new Sluzbenik();
        fakturaSluzbenik.setIdSluzbenik(rs.getInt("idSluzbenik"));
        fakturaSluzbenik.setIme(rs.getString("slIme"));
        fakturaSluzbenik.setPrezime(rs.getString("slPrezime"));
        fakturaSluzbenik.setKorisnickoIme(rs.getString("slKorisnickoIme"));
        faktura.setSluzbenik(fakturaSluzbenik);

        Student fakturaStudent = new Student();
        fakturaStudent.setIdStudent(rs.getLong("idStudent"));
        fakturaStudent.setIme(rs.getString("stIme"));
        fakturaStudent.setPrezime(rs.getString("stPrezime"));
        fakturaStudent.setBrTelefona(rs.getLong("stBrTelefona"));
        fakturaStudent.setBudzet(rs.getBoolean("stBudzet"));
        Fakultet f = new Fakultet();
        f.setIdFakultet(rs.getInt("stIdFakultet"));
        fakturaStudent.setFakultet(f);
        faktura.setStudent(fakturaStudent);

        return faktura;
    }

    private FakturaOdmora mapFakturaOdmora(ResultSet rs) throws SQLException {
        FakturaOdmora faktura = new FakturaOdmora();
        faktura.setIdFaktura(rs.getLong("idFaktura"));
        faktura.setPopust(rs.getDouble("popust"));
        faktura.setIznosNakonPopusta(rs.getDouble("iznosNakonPopusta"));
        faktura.setUkupanIznos(rs.getDouble("ukupanIznos"));
        faktura.setNapomena(rs.getString("napomena"));

        Sluzbenik fakturaSluzbenik = new Sluzbenik();
        fakturaSluzbenik.setIdSluzbenik(rs.getInt("idSluzbenik"));
        faktura.setSluzbenik(fakturaSluzbenik);

        Student fakturaStudent = new Student();
        fakturaStudent.setIdStudent(rs.getLong("idStudent"));
        faktura.setStudent(fakturaStudent);

        return faktura;
    }

}
