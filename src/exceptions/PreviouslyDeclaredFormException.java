package exceptions;

import declarations.Id;

public class PreviouslyDeclaredFormException extends Exception{

    public PreviouslyDeclaredFormException(Id id) {
        super("Formula " + id + " já declarada.");
    }
}
