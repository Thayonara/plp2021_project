package command;

import implementations.Id;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Size implements Command{

    protected PoolGenerateCommand command;

    public Size (PoolGenerateCommand command){
        this.command = command;
    }

    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) {

        //recuperar produtos da suite
        int b = executionEnvironment.getPoolTesting(command.getIdPl()).size();

        System.out.println("O tamanho é : " + (b));

        return executionEnvironment;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
       return this.command.typeCheck(compilationEnvironment);

    }
}
