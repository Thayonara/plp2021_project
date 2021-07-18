package exceptions;

public class UndeclaredIdException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UndeclaredIdException(String msg){
        super(msg);
    }
    public UndeclaredIdException(){
        super();
    }
}
