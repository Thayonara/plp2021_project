package exceptions;

import declarations.Id;

public class MultipleSelectedAlternativesFeaturesException extends Exception {
    public MultipleSelectedAlternativesFeaturesException(Id id, Id id1) {

        super("Restrição Alternativa não satisfeita com " + id + " em " + id1);
    }
}
