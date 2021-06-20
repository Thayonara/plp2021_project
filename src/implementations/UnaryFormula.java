package implementations;

public abstract class UnaryFormula implements Formula{
    private Formula formula;
    private String operator;

    public UnaryFormula(Formula formula, String operator){
        this.formula = formula;
        this.operator = operator;
    }



}
