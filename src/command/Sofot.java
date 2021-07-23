package command;

import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import implementations.Id;
import implementations.ProductDeclaration;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.FNDefinition;
import util.PLDefinition;
import util.ProductDefinition;

import java.util.List;
import java.util.Random;

public class Sofot implements PoolGenerateCommand {

    protected Id idPL;

    public Sofot(Id idPL){
        this.idPL = idPL;
    }


    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) throws UndeclaredPLException, UndeclaredFNException {
        PLDefinition plDefinition = executionEnvironment.getPlDefinition(idPL);
        ProductDeclaration seed = plDefinition.getProductDeclarations().getHead();
        //a execução é apenas add um pool no ambiente
        executionEnvironment.mapPoolTest(this.idPL, poolTestGenerate(seed, executionEnvironment));

        return executionEnvironment;


    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        return this.idPL.typeCheck(compilationEnvironment) &&
                (this.idPL.getType(compilationEnvironment).toString().equalsIgnoreCase("pl"));
    }


    public List<ProductDefinition> poolTestGenerate(ProductDeclaration seed, ExecutionEnvironment executionEnvironment) throws UndeclaredFNException {
        List<ProductDefinition> pool = null;
        for(int i = 0; i < seed.getFeaturesSelected().size(); i++){
            FNDefinition current = executionEnvironment.getFNDefinition(seed.getFeaturesSelected().get(i));

            if(!(current.getNodeType().toString().equals("root"))){

                List<Id> bro = executionEnvironment.getChildrens(current.getExtendedNode(), current.getFeatureName());
                Random gerador = new Random();
                seed.getFeaturesSelected().set(i, bro.get(gerador.nextInt(bro.size())));
                ProductDefinition productDefinition = new ProductDefinition(new Id("p["+i+"]"), seed.getFeaturesSelected());
                pool.add(productDefinition);
                }
            }
        return pool;

    }

    @Override
    public Id getIdPl() {
        return this.idPL;
    }
}
