package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.FNDefinition;

public class NotForm extends UnaryFormula{

    public NotForm(Formula formula) {
        super(formula, "not");
    }

    public Formula getFormula() {
        return getFormula();
    }

    public String getOperator() {
        return getOperator();
    }


    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        boolean result;
        if (super.typeCheck(compilationEnvironment) &&
                getFormula().typeCheck(compilationEnvironment)){
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
