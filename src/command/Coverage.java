package command;

import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import exceptions.UndeclaredProductException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Coverage implements Command{

    protected PoolGenerateCommand command;

    public Coverage(PoolGenerateCommand command){
        this.command = command;
    }

    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) throws UndeclaredPLException, UndeclaredFNException {

        command.execute(executionEnvironment);
        //recuperar produtos da PL
        float a = executionEnvironment.getPlDefinition(command.getIdPl()).getProductDeclarations().length();

        //recuperar produtos da suite
        float b = executionEnvironment.getAllPools().get(command.getIdPl().getIdName()).size();

        System.out.println("A Cobertura é: " + (a/b));

        return executionEnvironment;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) throws UndeclaredProductException {
        return this.command.typeCheck(compilationEnvironment);
    }
}
