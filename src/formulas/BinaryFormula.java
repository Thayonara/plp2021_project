package formulas;

import memory.CompilationEnvironment;

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

    public Formula getrFormula() {
        return rFormula;
    }

    public String getOperator() {
        return operator;
    }

    public boolean typeCheck(CompilationEnvironment compilationEnvironment){
        boolean result;
        if (getlFormula().typeCheck(compilationEnvironment) &&
                getrFormula().typeCheck(compilationEnvironment)) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }
}
