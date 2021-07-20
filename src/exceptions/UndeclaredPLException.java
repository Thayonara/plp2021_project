package exceptions;

import implementations.Id;

public class UndeclaredPLException extends Exception{

    public UndeclaredPLException(Id id) {
        super("PL " + id + " não declarada.");
    }
}
