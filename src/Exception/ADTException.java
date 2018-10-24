package Exception;

public class ADTException extends RuntimeException {
    String exception;
    public ADTException(String exception){
        super();
        this.exception = exception;
    }

    public String toString(){
        return exception;
    }
}
