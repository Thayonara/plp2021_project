package util;

import exceptions.*;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public interface Declaration {

    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) throws PreviouslyDeclaredFNException, UndeclaredFNException, PreviouslyDeclaredFormException, UndeclaredFormException, PreviouslyDeclaredProductException, UndeclaredProductException, PreviouslyDeclaredPLException, UndeclaredPLException;
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) throws PreviouslyDeclaredPLException, UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException, PreviouslyDeclaredProductException, UndeclaredProductException;

}
