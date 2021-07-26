package formulas;

import declarations.ProductDeclaration;
import memory.CompilationEnvironment;
import types.GeneralType;

public interface Formula {

    boolean evaluate(CompilationEnvironment compilationEnvironment, ProductDeclaration productDeclaration);
    boolean typeCheck(CompilationEnvironment compilationEnvironment);
    public GeneralType getType(CompilationEnvironment compilationEnvironment);



}
