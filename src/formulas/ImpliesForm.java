package formulas;

import declarations.ProductDeclaration;
import memory.CompilationEnvironment;
import types.GeneralType;
import types.IdTypeClass;

public class ImpliesForm extends BinaryFormula{
    public ImpliesForm(Formula lformula, Formula rformula) {

        super(lformula, rformula, "implies");
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
     right = false -> true
  */
    @Override
    public boolean evaluate(CompilationEnvironment compilationEnvironment, ProductDeclaration productDeclaration) {
        if(getLeft().evaluate(compilationEnvironment, productDeclaration)){
            return getRight().evaluate(compilationEnvironment, productDeclaration);
        } else{
            return true;
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
