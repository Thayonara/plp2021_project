package exceptions;

import declarations.Id;

public class ExtendsNullException extends Exception{
    public ExtendsNullException(Id id) {
        super("Extends de " + id + " não foi informado.");
    }
}
