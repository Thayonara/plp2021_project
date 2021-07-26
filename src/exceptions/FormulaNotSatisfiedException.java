package exceptions;

import declarations.Id;

public class FormulaNotSatisfiedException extends Exception {
    public FormulaNotSatisfiedException(Id id) {
        super("Fórmula não satisfeita em " + id);
    }
}
