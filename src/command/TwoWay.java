package command;

import implementations.Id;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;

public class TwoWay implements PoolGenerateCommand {

    protected Id idPL;

    public TwoWay(Id idPL){
        this.idPL = idPL;
    }

    public Id getPL(){
        return this.idPL;
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

    @Override
    public Id getIdPl() {
        return this.idPL;
    }
}
