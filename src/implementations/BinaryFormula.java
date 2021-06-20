package implementations;

public abstract class BinaryFormula implements Formula {

    private Formula lFormula;
    private Formula rFormula;
    private String operator;

    public BinaryFormula(Formula lformula, Formula rformula, String operator){
        this.lFormula = lformula;
        this.rFormula = rformula;
        this.operator = operator;
    }
}
