package exceptions;

import declarations.Id;

public class PreviouslyDeclaredProductException extends Exception{
    public PreviouslyDeclaredProductException(Id id) {
        super("Produto " + id + " já declarado.");
    }
}
