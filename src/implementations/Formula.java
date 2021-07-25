package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public interface Formula {

    boolean evaluate(CompilationEnvironment compilationEnvironment, ProductDeclaration productDeclaration);
    boolean typeCheck(CompilationEnvironment compilationEnvironment);
    public GeneralType getType(CompilationEnvironment compilationEnvironment);



}
