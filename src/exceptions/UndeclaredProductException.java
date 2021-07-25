package exceptions;

import declarations.Id;

public class UndeclaredProductException extends Exception{

    public UndeclaredProductException(Id id) {
        super("Produto " + id + " não declarado.");
    }
}
