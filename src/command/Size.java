package command;

import implementations.Id;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Size implements Command{

    protected Command command;

    public Size (Command command){
        this.command = command;
    }

    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) {
        return null;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
       return this.command.typeCheck(compilationEnvironment);

    }
}
