package exceptions;

import implementations.Id;

public class UndeclaredFormException extends Exception{
    public UndeclaredFormException(Id id) {
        super("Formula " + id + " não declarada.");
    }

}
