package exceptions;

public class PreviouslyDeclaredIdException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PreviouslyDeclaredIdException(String msg){
        super(msg);
    }
    public PreviouslyDeclaredIdException(){
        super();
    }
}
