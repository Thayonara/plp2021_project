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

    public Formula getlFormula() {
        return lFormula;
    }

    public void setlFormula(Formula lFormula) {
        this.lFormula = lFormula;
    }

    public Formula getrFormula() {
        return rFormula;
    }

    public void setrFormula(Formula rFormula) {
        this.rFormula = rFormula;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
