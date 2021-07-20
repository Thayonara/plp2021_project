package exceptions;

import implementations.Id;

public class PreviouslyDeclaredProductException extends Exception{
    public PreviouslyDeclaredProductException(Id id) {
        super("Produto " + id + " já declarado.");
    }
}
