package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.FNDefinition;

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

    @Override
    public boolean evaluate(ExecutionEnvironment executionEnvironment, ProductDeclaration productDeclaration) {
        return !getFormula().evaluate(executionEnvironment, productDeclaration);
    }

    @Override
    public GeneralType getType(CompilationEnvironment compilationEnvironment) {
        return IdTypeClass.FORM_TYPE.getType(compilationEnvironment);

    }


}
