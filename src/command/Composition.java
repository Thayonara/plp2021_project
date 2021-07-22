package command;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Composition implements Command{

    protected Command command1;
    protected Command command2;

    public Composition(Command command1, Command command2){
        this.command1 = command1;
        this.command2 = command2;
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
