package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public interface Formula {

    boolean evaluate(ExecutionEnvironment executionEnvironment, ProductDeclaration productDeclaration);
    boolean typeCheck(CompilationEnvironment compilationEnvironment);
    public GeneralType getType(CompilationEnvironment compilationEnvironment);



}
