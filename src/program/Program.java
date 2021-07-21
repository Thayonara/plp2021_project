package program;

import exceptions.PreviouslyDeclaredFNException;
import exceptions.PreviouslyDeclaredPLException;
import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import implementations.PLDeclaration;
import memory.CompilationEnvironment;
import parser.*;

public class Program {
    private PLDeclaration plDeclaration;

    public Program(PLDeclaration plDeclaration){
        this.plDeclaration = plDeclaration;
    }

    public boolean typeCheck(CompilationEnvironment compilationEnvironment) throws PreviouslyDeclaredPLException, UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException {
        boolean rt;
        if(compilationEnvironment == null) {
            //lançar exceptions
        }
        compilationEnvironment.increments();
        rt = plDeclaration.TypeCheck(compilationEnvironment) ;
        compilationEnvironment.restore();
        return rt;
    }

}