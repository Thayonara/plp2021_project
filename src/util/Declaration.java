package util;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public interface Declaration {

    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment);
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment);

}
