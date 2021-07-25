package implementations;

import exceptions.PreviouslyDeclaredFormException;
import exceptions.UndeclaredFormException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Declaration;
import util.FormDefinition;

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

    @Override
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) throws PreviouslyDeclaredFormException, UndeclaredFormException {
        executionEnvironment.mapFormDeclaration(this.formName, new FormDefinition(this.formName, this.formula));
        executionEnvironment.map(this.formName, new FormDefinition(this.formName, this.formula));
        return executionEnvironment;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) throws PreviouslyDeclaredFormException, UndeclaredFormException {
        boolean rt = false;
        compilationEnvironment.increments();
        rt = this.formula.typeCheck(compilationEnvironment);
        compilationEnvironment.mapFormDeclaration(this.formName, new FormDefinition(this.formName, this.formula));
        compilationEnvironment.map(this.formName, new IdTypeClass(IdTypeEnum.FORM));
        compilationEnvironment.restore();
        return rt;
    }

    public CompilationEnvironment formDeclarate(CompilationEnvironment compilationEnvironment){
        compilationEnvironment.map(this.formName, IdTypeClass.FORM_TYPE.getType(compilationEnvironment));
        return compilationEnvironment;
    }
}
