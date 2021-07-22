package command;

import implementations.Id;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Sofot implements Command{

    protected Id idPL;

    public Sofot(Id idPL){
        this.idPL = idPL;
    }

    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) {
        return null;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        return false;
    }
}
