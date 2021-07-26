package program;

import command.Command;
import exceptions.*;
import declarations.Id;
import declarations.PLDeclaration;
import declarations.ProductDeclaration;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

import java.util.HashMap;
import java.util.List;

public class Program {
    private PLDeclaration plDeclaration;
    private Command command;

    public Program(PLDeclaration plDeclaration, Command command){

        this.plDeclaration = plDeclaration;
        this.command = command;
    }

    public boolean typeCheck(CompilationEnvironment compilationEnvironment) throws PreviouslyDeclaredPLException, UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException, PreviouslyDeclaredProductException, UndeclaredProductException, PreviouslyDeclaredFormException, UndeclaredFormException, ExtendsNullException, MultipleRootException {
        boolean rt;
        if(compilationEnvironment == null) {
            //lançar exceptions
        }
        compilationEnvironment.increments();
        if(plDeclaration != null && command != null){
            rt = plDeclaration.TypeCheck(compilationEnvironment) && command.typeCheck(compilationEnvironment);
        } else{
            rt = plDeclaration.TypeCheck(compilationEnvironment);
        }
        compilationEnvironment.restore();
        return rt;
    }

    public HashMap<Id, List<ProductDeclaration>> execute(ExecutionEnvironment executionEnvironment) throws UndeclaredFNException, UndeclaredPLException, PreviouslyDeclaredPLException, PreviouslyDeclaredFNException, PreviouslyDeclaredFormException, UndeclaredFormException, PreviouslyDeclaredProductException, UndeclaredProductException {
        if(executionEnvironment == null){
            //lancar exception
        }

        executionEnvironment.increments();
        if(command != null) {
            executionEnvironment = command.execute(plDeclaration.elaborate(executionEnvironment));
        }
        executionEnvironment.restore();

        return executionEnvironment.getAllPools();


    }

}