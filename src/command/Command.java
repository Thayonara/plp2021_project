package command;

import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public interface Command {

    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) throws UndeclaredPLException, UndeclaredFNException;
    public boolean typeCheck(CompilationEnvironment compilationEnvironment);

}
