package command;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public interface Command {

    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment);
    public boolean typeCheck(CompilationEnvironment compilationEnvironment);

}
