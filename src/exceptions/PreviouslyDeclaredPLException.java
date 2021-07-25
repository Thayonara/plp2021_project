package exceptions;

import declarations.Id;

public class PreviouslyDeclaredPLException extends Exception{

    public PreviouslyDeclaredPLException(Id id) {
        super("PL " + id + " já declarada.");
    }

}
