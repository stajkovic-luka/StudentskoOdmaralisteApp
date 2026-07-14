package so.invoice;

// SK3
import domain.DomainObject;
import domain.FakturaOdmora;
import domain.StavkaFakture;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

public class UpdateInvoiceSO extends AbstractSO {

    public UpdateInvoiceSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        FakturaOdmora faktura = (FakturaOdmora) object;

        dbb.update(faktura);

        StavkaFakture search = new StavkaFakture();
        search.setFakturaOdmora(faktura);
        search.setSearchByFakturaOnly(true);

        List<DomainObject> existingStavke = dbb.getAllJoinTablesWhere(search);
        List<StavkaFakture> postojece = new ArrayList<>();
        for (DomainObject d : existingStavke) {
            postojece.add((StavkaFakture) d);
        }

        List<StavkaFakture> nove = faktura.getStavkeFakture();

        for (StavkaFakture nova : nove) {
            nova.setFakturaOdmora(faktura);
            boolean postoji = postojece.stream()
                    .anyMatch(p -> p.getRb() == nova.getRb());

            if (postoji) {
                dbb.update(nova);
            } else {
                dbb.add(nova);
            }
        }

        for (StavkaFakture stara : postojece) {
            boolean ostaje = nove.stream()
                    .anyMatch(n -> n.getRb() == stara.getRb());
            if (!ostaje) {
                dbb.delete(stara);
            }
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof FakturaOdmora)) {
            throw new Exception("Objekat nije instanca klase FakturaOdmora.");
        }
        FakturaOdmora faktura = (FakturaOdmora) object;
        if (faktura.getStudent() == null) {
            throw new Exception("Nije izabran student.");
        }
        if (faktura.getSluzbenik() == null) {
            throw new Exception("Nije izabran sluzbenik.");
        }
        if (faktura.getStavkeFakture() == null || faktura.getStavkeFakture().isEmpty()) {
            throw new Exception("Nisu unesene stavke fakture.");
        }
    }
}
