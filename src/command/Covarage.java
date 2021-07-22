package command;

import implementations.Id;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Covarage implements Command{

    protected Command command;

    public Covarage (Command command){
        this.command = command;
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
