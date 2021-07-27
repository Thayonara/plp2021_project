package formulas;

import declarations.ProductDeclaration;
import memory.CompilationEnvironment;
import types.GeneralType;
import types.IdTypeClass;

public class AndForm extends BinaryFormula{
    public AndForm(Formula lformula, Formula rformula)
    {
        super(lformula, rformula, "and");
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

    /*
        left = true -> right
        left = false -> false
     */
    @Override
    public boolean evaluate(CompilationEnvironment compilationEnvironment, ProductDeclaration productDeclaration) {
        if(getRight().evaluate(compilationEnvironment, productDeclaration)){
            return getLeft().evaluate(compilationEnvironment, productDeclaration);
        } else{
            return false;
        }
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        boolean result;
        if (super.typeCheck(compilationEnvironment) &&
                getLeft().typeCheck(compilationEnvironment) &&
                getRight().typeCheck(compilationEnvironment)){
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
