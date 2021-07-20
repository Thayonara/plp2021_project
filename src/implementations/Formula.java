package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public interface Formula {

    //ExecutionEnvironment evaluate(ExecutionEnvironment executionEnvironment);
    boolean typeCheck(CompilationEnvironment compilationEnvironment);
    public GeneralType getType(CompilationEnvironment compilationEnvironment);



}
