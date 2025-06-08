package transfer;

import java.io.Serializable;

// Zahtev koji se salje serveru
public class Request implements Serializable {

    private Operation operation;
    private Object argument;

    public Request(Operation operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public Request() {
    }

    // Getteri i setteri
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }
    
    // To String
    @Override
    public String toString() {
        return "Request{" + "operation=" + operation + ", argument=" + argument + '}';
    }
    
    
}
