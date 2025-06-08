package controller;


public class Controller {
    private static Controller instance;
    
    private Controller(){
        
        
    }
    
    public static Controller getInstance(){
        if(instance == null){
            return new Controller();
        }
        return instance;
    }
}
