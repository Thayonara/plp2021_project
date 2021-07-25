package exceptions;

import declarations.Id;

public class UndeclaredPLException extends Exception{

    public UndeclaredPLException(Id id) {
        super("PL " + id + " não declarada.");
    }
}
