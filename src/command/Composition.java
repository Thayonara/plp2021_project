package command;

import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import exceptions.UndeclaredProductException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Composition implements Command{

    protected Command command1;
    protected Command command2;

    public Composition(Command command1, Command command2){
        this.command1 = command1;
        this.command2 = command2;
    }


    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) throws UndeclaredFNException, UndeclaredPLException {
        executionEnvironment = this.command1.execute(executionEnvironment);
        executionEnvironment = this.command2.execute(executionEnvironment);

        return executionEnvironment;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) throws UndeclaredProductException {
        return this.command1.typeCheck(compilationEnvironment) &&
                this.command2.typeCheck(compilationEnvironment);
    }
}
