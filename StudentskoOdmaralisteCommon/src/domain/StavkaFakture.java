package domain;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StavkaFakture extends DomainObject {

    private int rb;
    private boolean dorucakUkljucen;
    private LocalDate datumOd;
    private LocalDate datumDo;
    private int brojDana;
    private double cena;
    private double iznos;
    private double dodatniTroskovi;
    private Nocenje nocenje;
    private FakturaOdmora fakturaOdmora;
    private boolean searchByFakturaOnly;

    public StavkaFakture() {
    }

    public StavkaFakture(int rb, boolean dorucakUkljucen, LocalDate datumOd, LocalDate datumDo, int brojDana, double cena, double iznos, double dodatniTroskovi, Nocenje nocenje, FakturaOdmora fakturaOdmora) {
        this.rb = rb;
        this.dorucakUkljucen = dorucakUkljucen;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.brojDana = brojDana;
        this.cena = cena;
        this.iznos = iznos;
        this.dodatniTroskovi = dodatniTroskovi;
        this.nocenje = nocenje;
        this.fakturaOdmora = fakturaOdmora;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public boolean isDorucakUkljucen() {
        return dorucakUkljucen;
    }

    public void setDorucakUkljucen(boolean dorucakUkljucen) {
        this.dorucakUkljucen = dorucakUkljucen;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public double getDodatniTroskovi() {
        return dodatniTroskovi;
    }

    public void setDodatniTroskovi(double dodatniTroskovi) {
        this.dodatniTroskovi = dodatniTroskovi;
    }

    public Nocenje getNocenje() {
        return nocenje;
    }

    public void setNocenje(Nocenje nocenje) {
        this.nocenje = nocenje;
    }

    public FakturaOdmora getFakturaOdmora() {
        return fakturaOdmora;
    }

    public void setFakturaOdmora(FakturaOdmora fakturaOdmora) {
        this.fakturaOdmora = fakturaOdmora;
    }

    public boolean isSearchByFakturaOnly() {
        return searchByFakturaOnly;
    }

    public void setSearchByFakturaOnly(boolean searchByFakturaOnly) {
        this.searchByFakturaOnly = searchByFakturaOnly;
    }

    @Override
    public String tableName() {
        return "stavkafakture";
    }

    @Override
    public String selectColumns() {
        return "idFaktura, rb, idNocenje, datumOd, datumDo, brojDana, dorucakUkljucen, cena, iznos, dodatniTroskovi";
    }

    @Override
    public List<DomainObject> mapMany(ResultSet rs) throws SQLException {
        List<DomainObject> stavke = new ArrayList<>();
        while (rs.next()) {
            stavke.add(mapStavkaFakture(rs));
        }
        return stavke;
    }

    @Override
    public DomainObject mapOne(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return mapStavkaFakture(rs);
        }
        return null;
    }

    @Override
    public String selectWhereClause() {
        return "idFaktura=? AND rb=?";
    }

    @Override
    public void bindSelectParams(PreparedStatement ps) throws SQLException {
        if (fakturaOdmora == null) {
            throw new SQLException("Faktura odmora mora biti postavljena za pretragu stavke.");
        }

        ps.setLong(1, fakturaOdmora.getIdFaktura());
        ps.setInt(2, rb);
    }

    @Override
    public boolean hasAutoIncrementPrimaryKey() {
        return false;
    }

    @Override
    public String insertColumns() {
        return "idFaktura, rb, idNocenje, datumOd, datumDo, brojDana, dorucakUkljucen, cena, iznos, dodatniTroskovi";
    }

    @Override
    public String insertValuesClause() {
        return "?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    public void bindInsertParams(PreparedStatement ps) throws SQLException {
        ps.setLong(1, fakturaOdmora.getIdFaktura());
        ps.setInt(2, rb);
        ps.setLong(3, nocenje.getIdNocenje());
        ps.setDate(4, Date.valueOf(datumOd));
        ps.setDate(5, Date.valueOf(datumDo));
        ps.setInt(6, brojDana);
        ps.setBoolean(7, dorucakUkljucen);
        ps.setDouble(8, cena);
        ps.setDouble(9, iznos);
        ps.setDouble(10, dodatniTroskovi);
    }

    @Override
    public String updateSetClause() {
        return "idNocenje=?, datumOd=?, datumDo=?, brojDana=?, dorucakUkljucen=?, cena=?, iznos=?, dodatniTroskovi=?";
    }

    @Override
    public String updateWhereClause() {
        return "idFaktura=? AND rb=?";
    }

    @Override
    public void bindUpdateParams(PreparedStatement ps) throws SQLException {
        ps.setLong(1, nocenje.getIdNocenje());
        ps.setDate(2, Date.valueOf(datumOd));
        ps.setDate(3, Date.valueOf(datumDo));
        ps.setInt(4, brojDana);
        ps.setBoolean(5, dorucakUkljucen);
        ps.setDouble(6, cena);
        ps.setDouble(7, iznos);
        ps.setDouble(8, dodatniTroskovi);
        ps.setLong(9, fakturaOdmora.getIdFaktura());
        ps.setInt(10, rb);
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
        if (searchByFakturaOnly) {
            return "idFaktura=?";
        }
        return selectWhereClause();
    }

    @Override
    public void bindSearchParams(PreparedStatement ps) throws SQLException {
        if (fakturaOdmora == null) {
            throw new SQLException("Faktura odmora mora biti postavljena za pretragu stavke.");
        }
        ps.setLong(1, fakturaOdmora.getIdFaktura());
        if (!searchByFakturaOnly) {
            ps.setInt(2, rb);
        }
    }

    @Override
    public String selectJoinColumns() {
        return "sf.idFaktura, sf.rb, sf.idNocenje, sf.datumOd, sf.datumDo, sf.brojDana, "
                + "sf.dorucakUkljucen, sf.cena, sf.iznos, sf.dodatniTroskovi, "
                + "n.cena AS nCena, n.opis AS nOpis";
    }

    @Override
    public String joinFromClause() {
        return "stavkafakture sf JOIN nocenje n ON sf.idNocenje = n.idNocenje";
    }

    @Override
    public String joinWhereClause() {
        if (searchByFakturaOnly) {
            return "sf.idFaktura=?";
        }
        return "sf." + selectWhereClause();
    }

    @Override
    public void bindJoinParams(PreparedStatement ps) throws SQLException {
        if (fakturaOdmora == null) {
            throw new SQLException("Faktura odmora mora biti postavljena za pretragu stavke.");
        }
        ps.setLong(1, fakturaOdmora.getIdFaktura());
        if (!searchByFakturaOnly) {
            ps.setInt(2, rb);
        }
    }

    @Override
    public List<DomainObject> mapJoined(ResultSet rs) throws SQLException {
        List<DomainObject> stavke = new ArrayList<>();
        while (rs.next()) {
            stavke.add(mapStavkaJoined(rs));
        }
        return stavke;
    }

    private StavkaFakture mapStavkaJoined(ResultSet rs) throws SQLException {
        StavkaFakture stavka = new StavkaFakture();
        stavka.setRb(rs.getInt("rb"));
        stavka.setDorucakUkljucen(rs.getBoolean("dorucakUkljucen"));

        Date datumOdVrednost = rs.getDate("datumOd");
        if (datumOdVrednost != null) {
            stavka.setDatumOd(datumOdVrednost.toLocalDate());
        }

        Date datumDoVrednost = rs.getDate("datumDo");
        if (datumDoVrednost != null) {
            stavka.setDatumDo(datumDoVrednost.toLocalDate());
        }

        stavka.setBrojDana(rs.getInt("brojDana"));
        stavka.setCena(rs.getDouble("cena"));
        stavka.setIznos(rs.getDouble("iznos"));
        stavka.setDodatniTroskovi(rs.getDouble("dodatniTroskovi"));

        Nocenje stavkaNocenje = new Nocenje();
        stavkaNocenje.setIdNocenje(rs.getLong("idNocenje"));
        stavkaNocenje.setCena(rs.getDouble("nCena"));
        stavkaNocenje.setOpis(rs.getString("nOpis"));
        stavka.setNocenje(stavkaNocenje);

        FakturaOdmora stavkaFaktura = new FakturaOdmora();
        stavkaFaktura.setIdFaktura(rs.getLong("idFaktura"));
        stavka.setFakturaOdmora(stavkaFaktura);

        return stavka;
    }

    private StavkaFakture mapStavkaFakture(ResultSet rs) throws SQLException {
        StavkaFakture stavka = new StavkaFakture();
        stavka.setRb(rs.getInt("rb"));
        stavka.setDorucakUkljucen(rs.getBoolean("dorucakUkljucen"));

        Date datumOdVrednost = rs.getDate("datumOd");
        if (datumOdVrednost != null) {
            stavka.setDatumOd(datumOdVrednost.toLocalDate());
        }

        Date datumDoVrednost = rs.getDate("datumDo");
        if (datumDoVrednost != null) {
            stavka.setDatumDo(datumDoVrednost.toLocalDate());
        }

        stavka.setBrojDana(rs.getInt("brojDana"));
        stavka.setCena(rs.getDouble("cena"));
        stavka.setIznos(rs.getDouble("iznos"));
        stavka.setDodatniTroskovi(rs.getDouble("dodatniTroskovi"));

        Nocenje stavkaNocenje = new Nocenje();
        stavkaNocenje.setIdNocenje(rs.getLong("idNocenje"));
        stavka.setNocenje(stavkaNocenje);

        FakturaOdmora stavkaFaktura = new FakturaOdmora();
        stavkaFaktura.setIdFaktura(rs.getLong("idFaktura"));
        stavka.setFakturaOdmora(stavkaFaktura);

        return stavka;
    }
}
