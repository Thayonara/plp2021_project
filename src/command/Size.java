package command;

import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import exceptions.UndeclaredProductException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Size implements Command{

    protected PoolGenerateCommand command;

    public Size (PoolGenerateCommand command){
        this.command = command;
    }

    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) throws UndeclaredFNException, UndeclaredPLException {

        //recuperar produtos da suite
        command.execute(executionEnvironment);
        int b = executionEnvironment.getAllPools().get(command.getIdPl().getIdName()).size();

        System.out.println("O tamanho é : " + (b));

        return executionEnvironment;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) throws UndeclaredProductException {
       return this.command.typeCheck(compilationEnvironment);

    }
}
