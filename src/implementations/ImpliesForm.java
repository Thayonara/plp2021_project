package implementations;

public class ImpliesForm extends BinaryFormula{
    public ImpliesForm(Formula lformula, Formula rformula) {
        super(lformula, rformula, "implies");
    }
}
