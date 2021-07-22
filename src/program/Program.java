package program;

import command.Command;
import exceptions.*;
import implementations.PLDeclaration;
import memory.CompilationEnvironment;
import parser.*;

public class Program {
    private PLDeclaration plDeclaration;
    private Command command;

    public Program(PLDeclaration plDeclaration, Command command){

        this.plDeclaration = plDeclaration;
        this.command = command;
    }

    public boolean typeCheck(CompilationEnvironment compilationEnvironment) throws PreviouslyDeclaredPLException, UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException, PreviouslyDeclaredProductException, UndeclaredProductException {
        boolean rt;
        if(compilationEnvironment == null) {
            //lançar exceptions
        }
        compilationEnvironment.increments();
        rt = plDeclaration.TypeCheck(compilationEnvironment) && command.typeCheck(compilationEnvironment);
        compilationEnvironment.restore();
        return rt;
    }

}