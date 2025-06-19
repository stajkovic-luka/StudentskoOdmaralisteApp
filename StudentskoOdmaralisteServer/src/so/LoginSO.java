package so;

// Prijava sluzbenika na sistem - SK8
import domain.DomainObject;
import domain.Sluzbenik;

public class LoginSO extends AbstractSO {

    private Sluzbenik sluzbenik;

    public LoginSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        DomainObject domainObject = dbb.getSingleInstance((DomainObject) object);
        
        if(domainObject instanceof Sluzbenik){
            sluzbenik = (Sluzbenik) domainObject;
        }else{
            throw new Exception("Pogresni podaci sluzbenika");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if(!(object instanceof  Sluzbenik)){
            throw new Exception("Objekat nije validan");
        }
    }

    public Sluzbenik getSluzbenik() {
        return sluzbenik;
    }
}
