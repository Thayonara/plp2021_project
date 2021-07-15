package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Declaration;

public class FormDeclaration implements Declaration {

    private Id formName;
    private Formula formula;

    public FormDeclaration(Id formName, Formula formula){
        this.formName = formName;
        this.formula = formula;
    }

    public Id getFormName() {
        return formName;
    }

    public Formula getFormula() {
        return formula;
    }

    public IdType getType(){
        return formName.getIdType();
    }

    @Override
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) {
        return null;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) {
        return false;
    }
}
