package exceptions;

import declarations.Id;

public class ExtendedNodeNotFoundException extends Exception {
    public ExtendedNodeNotFoundException(Id id, Id id1) {

        super("O nó pai de " + id + " não encontrado em " + id1);
    }
}

