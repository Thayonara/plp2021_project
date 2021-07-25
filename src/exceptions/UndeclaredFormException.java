package exceptions;

import declarations.Id;

public class UndeclaredFormException extends Exception{
    public UndeclaredFormException(Id id) {
        super("Formula " + id + " não declarada.");
    }

}
