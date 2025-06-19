package so;

import java.sql.SQLException;
import repository.DBBroker;
import repository.DBConnection;

public abstract class AbstractSO {

    protected DBBroker dbb;

    public AbstractSO() throws Exception {
        dbb = new DBBroker(DBConnection.getInstance().fetchConnection());
    }

    public void execute(Object object) throws SQLException, Exception{
        try {
            validate(object); // Proveri koji je objekat
            execute(object); // Izvrsi trazenu operaciju
            commit();
            DBConnection.getInstance().returnToPool(dbb.getConnection());
        } catch (Exception e) {
            rollback();
            DBConnection.getInstance().returnToPool(dbb.getConnection());

            throw e;
        }
    }

    private void rollback() throws SQLException {
        dbb.getConnection().rollback();
    }

    private void commit() throws SQLException {
        dbb.getConnection().commit();
    }

    protected abstract void executeOperation(Object object) throws Exception;

    protected abstract void validate(Object object) throws Exception;

}
