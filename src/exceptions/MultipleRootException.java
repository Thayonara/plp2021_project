package exceptions;

import declarations.Id;

public class MultipleRootException extends Exception {
    public MultipleRootException(Id id) {
        super(id + " não pode ser ROOT.");
    }
}
