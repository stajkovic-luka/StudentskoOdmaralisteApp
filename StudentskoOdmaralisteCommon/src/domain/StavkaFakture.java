package domain;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class StavkaFakture extends DomainObject{
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
