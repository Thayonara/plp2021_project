package implementations;

public class OrForm extends BinaryFormula{
    public OrForm(Formula lformula, Formula rformula) {
        super(lformula, rformula, "or");
    }
}
