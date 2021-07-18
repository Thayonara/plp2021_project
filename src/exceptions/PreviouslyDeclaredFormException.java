package exceptions;

import implementations.Id;

public class PreviouslyDeclaredFormException extends Exception{

    public PreviouslyDeclaredFormException(Id id) {
        super("Formula " + id + " já declarada.");
    }
}
