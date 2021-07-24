package program;

import command.Command;
import exceptions.*;
import implementations.Id;
import implementations.PLDeclaration;
import implementations.ProductDeclaration;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import parser.*;
import util.ProductDefinition;

import java.util.HashMap;
import java.util.List;

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

    public HashMap<Id, List<ProductDeclaration>> execute(ExecutionEnvironment executionEnvironment) throws UndeclaredFNException, UndeclaredPLException, PreviouslyDeclaredPLException, PreviouslyDeclaredFNException, PreviouslyDeclaredFormException, UndeclaredFormException, PreviouslyDeclaredProductException, UndeclaredProductException {
        if(executionEnvironment == null){
            //lancar exception
        }

        executionEnvironment.increments();
        executionEnvironment = command.execute(plDeclaration.elaborate(executionEnvironment));
        executionEnvironment.restore();

        return executionEnvironment.getAllPools();


    }

}