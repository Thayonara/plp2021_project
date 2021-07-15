package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Declaration;

public class PLDeclaration implements Declaration {
    protected Id pLname;

    public PLDeclaration(Id plName){
        this.pLname = plName;
    }

    public IdType getIdType(){
        return pLname.getIdType();
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