package transfer;

import java.io.Serializable;

// Odgovor servera i potencijalni exception
public class Response implements Serializable {

    private Object serverResponse;
    private Exception exception;

    public Response() {
    }

    public Response(Object serverResponse, Exception exception) {
        this.serverResponse = serverResponse;
        this.exception = exception;
    }

    // Getteri i setteri
    public Object getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(Object serverResponse) {
        this.serverResponse = serverResponse;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
    // To String
    @Override
    public String toString() {
        return "Response{" + "serverResponse=" + serverResponse + ", exception=" + exception + '}';
    }
    
    

}
