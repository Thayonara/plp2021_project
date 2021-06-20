package implementations;

public class NotForm extends UnaryFormula{

    public NotForm(Formula formula) {
        super(formula, "not");
    }
}
