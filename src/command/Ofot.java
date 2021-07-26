package command;

import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import declarations.*;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.PLDefinition;

import java.util.ArrayList;
import java.util.List;

public class Ofot implements PoolGenerateCommand {

    protected Id idPL;

    public Ofot(Id idPL){
        this.idPL = idPL;
    }


    @Override
    public ExecutionEnvironment execute(ExecutionEnvironment executionEnvironment) throws UndeclaredPLException, UndeclaredFNException {
        PLDefinition plDefinition = executionEnvironment.getPlDefinition(idPL);
        ProductDeclaration seed = plDefinition.getProductDeclarations().getHead();
        //a execução é apenas add um pool no ambiente
        executionEnvironment.mapPoolTest(this.idPL.getIdName(), poolTestGenerate(seed, executionEnvironment));

        return executionEnvironment;
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        return this.idPL.typeCheck(compilationEnvironment) &&
                (this.idPL.getType(compilationEnvironment).toString().equalsIgnoreCase("pl"));

    }

    public List<ProductDeclaration> poolTestGenerate(ProductDeclaration seed, ExecutionEnvironment executionEnvironment) throws UndeclaredFNException, UndeclaredPLException {
       List<ProductDeclaration> pool = new ArrayList<ProductDeclaration>();
       pool.add(seed);
       for(int i = 0; i < seed.getFeaturesSelected().size(); i++){
           FeatureNameDeclaration current = executionEnvironment.getPlDefinition(idPL).getFeatureNameDeclarations().getFN(seed.getFeaturesSelected().get(i));

           if(!(current.getNodeType().toString().equals("root"))){

               List<Id> bro = executionEnvironment.getChildrens(current.getExtendedNode(), current.getFeatureName());

               for ( int j = 0; j < bro.size(); j++){
                   List<Id> aux = new ArrayList<>();
                   for(int k = 0; k < seed.getFeaturesSelected().size(); k ++){
                       if(k == i){
                           aux.add(bro.get(j));
                       } else{
                           aux.add(seed.getFeaturesSelected().get(k));
                       }
                   }
                   ProductDeclaration productDeclaration = new ProductDeclaration(new Id("p["+i+j+"]"), aux);
                   pool.add(productDeclaration);
               }
           }

       }
            return pool;

    }

    @Override
    public Id getIdPl() {
        return this.idPL;
    }
}
