package command;

import exceptions.UndeclaredPLException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Covarage implements Command{

    protected PoolGenerateCommand command;

    public Covarage (PoolGenerateCommand command){
        this.command = command;
    }

    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) throws UndeclaredPLException {
        //recuperar produtos da PL
        int a = executionEnvironment.getPlDefinition(command.getIdPl()).getProductDeclarations().length();

        //recuperar produtos da suite
        int b = executionEnvironment.getPoolTesting(command.getIdPl()).size();

        System.out.println("A Cobertura é: " + (a/b));

        return executionEnvironment;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        return this.command.typeCheck(compilationEnvironment);
    }
}
