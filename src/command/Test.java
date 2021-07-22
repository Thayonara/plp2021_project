package command;

import implementations.Id;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Test implements Command{

    protected Command command;
    protected Id idProduct;

    public Test (Command command, Id idProduct){
        this.command = command;
        this.idProduct = idProduct;
    }

    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) {
        return null;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        return false;
    }
}
