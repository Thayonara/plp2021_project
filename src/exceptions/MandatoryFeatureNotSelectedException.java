package exceptions;

import declarations.Id;

public class MandatoryFeatureNotSelectedException extends Exception {
    public MandatoryFeatureNotSelectedException(Id id, Id id1) {

        super("A feature obrigatória " + id + " não foi selecionada em " + id1);
    }
}
