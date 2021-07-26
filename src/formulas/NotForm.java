package formulas;

import declarations.ProductDeclaration;
import memory.CompilationEnvironment;
import types.GeneralType;
import types.IdTypeClass;

public class NotForm extends UnaryFormula{

    public NotForm(Formula formula) {
        super(formula, "not");
    }

    public Formula getFormula() {
        return super.getFormula();
    }

    public String getOperator() {
        return super.getOperator();
    }

    @Override
    protected boolean checaTipoElementoTerminal(CompilationEnvironment compilationEnvironment) {
        getFormula().getType(compilationEnvironment).isValid(compilationEnvironment);
        return (getFormula().getType(compilationEnvironment).isValid(compilationEnvironment));

    }

    /*
      form = true -> false
      form = false -> true
   */
    @Override
    public boolean evaluate(CompilationEnvironment compilationEnvironment, ProductDeclaration productDeclaration) {
        return !getFormula().evaluate(compilationEnvironment, productDeclaration);
    }

    @Override
    public GeneralType getType(CompilationEnvironment compilationEnvironment) {
        return IdTypeClass.FORM_TYPE.getType(compilationEnvironment);

    }


}
