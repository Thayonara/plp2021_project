package exceptions;

import implementations.Id;

public class PreviouslyDeclaredPLException extends Exception{

    public PreviouslyDeclaredPLException(Id id) {
        super("PL " + id + " já declarada.");
    }

}
