package implementations;

import memory.CompilationEnvironment;

public class OrForm extends BinaryFormula{
    public OrForm(Formula lformula, Formula rformula) {

        super(lformula, rformula, "or");
    }

    public Formula getLeft() {
        return getlFormula();
    }

    public Formula getRight() {
        return getrFormula();
    }

    public String getOperator() {
        return getOperator();
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        boolean result;
        if (super.typeCheck(compilationEnvironment) &&
                getlFormula().typeCheck(compilationEnvironment) &&
                getrFormula().typeCheck(compilationEnvironment)){
            result = true;
        }
        else {
            result = false;
        }
        return result;    }

    @Override
    public GeneralType getType(CompilationEnvironment compilationEnvironment) {
        return IdTypeClass.FORM_TYPE.getType(compilationEnvironment);

    }
}
