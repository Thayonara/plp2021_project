package command;

import implementations.*;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class Ofot implements Command{

    protected Id idPL;

    public Ofot(Id idPL){
        this.idPL = idPL;
    }

    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) {
        return null;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        return this.idPL.typeCheck(compilationEnvironment) &&
                (this.idPL.getType(compilationEnvironment).toString().equalsIgnoreCase("pl"));

    }
}
