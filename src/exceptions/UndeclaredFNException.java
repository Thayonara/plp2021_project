package exceptions;

import implementations.Id;

public class UndeclaredFNException extends Exception{
    public UndeclaredFNException(Id id) {
        super("FN " + id + " não declarada.");
    }

}
