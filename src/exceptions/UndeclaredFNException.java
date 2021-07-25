package exceptions;

import declarations.Id;

public class UndeclaredFNException extends Exception{
    public UndeclaredFNException(Id id) {
        super("FN " + id + " não declarada.");
    }

}
