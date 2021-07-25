package exceptions;

import declarations.Id;

public class PreviouslyDeclaredFNException extends Exception{
    public PreviouslyDeclaredFNException(Id id) {
        super("FN " + id + " já declarada.");
    }
}
