package controller;

import domain.Sluzbenik;
import repository.DBConnection;
import so.LoginSO;


public class Controller {
    
    // LOGIN (SK8)
    public Sluzbenik login(Sluzbenik sluzbenik) throws Exception {
        LoginSO login = new LoginSO();
        login.execute(sluzbenik);
        return login.getSluzbenik();
        
    }
    
    
}