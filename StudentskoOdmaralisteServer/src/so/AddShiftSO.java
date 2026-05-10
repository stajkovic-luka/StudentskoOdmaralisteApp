package so;

import domain.Smena;

public class AddShiftSO extends AbstractSO {

    public AddShiftSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        dbb.add((Smena) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Smena)) {
            throw new Exception("Objekat nije instanca klase Smena.");
        }
    }
}
