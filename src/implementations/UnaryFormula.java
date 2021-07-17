package implementations;

import memory.CompilationEnvironment;

public abstract class UnaryFormula implements Formula{
    private Formula formula;
    private String operator;

    public UnaryFormula(Formula formula, String operator){
        this.formula = formula;
        this.operator = operator;
    }

    public Formula getFormula() {
        return formula;
    }

    public String getOperator() {
        return operator;
    }

    public boolean typeCheck(CompilationEnvironment compilationEnvironment){
        boolean result;
        if (getFormula().typeCheck(compilationEnvironment)) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

}
