package controller;

import domain.DomainObject;
import domain.Sluzbenik;
import domain.Smena;
import java.util.List;
import so.AddShiftSO;
import so.GetAllShiftsSO;
import so.LoginSO;


public class Controller {
    
    public Sluzbenik login(Sluzbenik sluzbenik) throws Exception {
        LoginSO login = new LoginSO();
        login.execute(sluzbenik);
        return login.getSluzbenik();
    }
    
    public List<DomainObject> getAllShifts() throws Exception {
        GetAllShiftsSO so = new GetAllShiftsSO();
        so.execute(new Smena());
        return so.getShifts();
    }
    
    public void addShift(Smena smena) throws Exception {
        AddShiftSO so = new AddShiftSO();
        so.execute(smena);
    }
}
