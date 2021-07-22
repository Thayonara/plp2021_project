package commands;

import exceptions.PreviouslyDeclaredFNException;
import exceptions.PreviouslyDeclaredPLException;
import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import implementations.PLDeclaration;
import implementations.ProductDeclaration;
import memory.CompilationEnvironment;

public class SimplifiedOneFactor {

    private PLDeclaration plDeclaration;
    private ProductDeclaration productDeclaration;

    public void SimplifiedOneFactor(){
    }

    public boolean TypeCheckPL(CompilationEnvironment compilationEnvironment) throws PreviouslyDeclaredPLException, UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException {
        boolean pl;
        pl = plDeclaration.TypeCheck(compilationEnvironment) ;
        return pl;
    }

    public boolean TypeCheckProduct(CompilationEnvironment compilationEnvironment) {
        boolean product;
        product = plDeclaration.TypeCheck(compilationEnvironment) ;
        return product;
    }
}

