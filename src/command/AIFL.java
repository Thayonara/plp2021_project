package command;

import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import declarations.FeatureNameDeclaration;
import declarations.Id;
import declarations.ProductDeclaration;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.PLDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIFL implements PoolGenerateCommand {

    protected Id idPL;

    public AIFL(Id idPL){
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

            for(int j = 0; j < seed.getFeaturesSelected().size();j++){
                if(!(current.getNodeType().toString().equals("root")) && !(seed.getFeaturesSelected().get(j).getIdName().equalsIgnoreCase(current.getFeatureName().getIdName()))){
                    FeatureNameDeclaration base = executionEnvironment.getPlDefinition(idPL).getFeatureNameDeclarations().getFN(seed.getFeaturesSelected().get(j));
                    if(!base.getNodeType().toString().equals("root")) {
                        List<Id> bro = executionEnvironment.getChildrens(base.getExtendedNode(), current.getFeatureName());
                        Random gerador = new Random();
                        List<Id> aux = new ArrayList<>();
                        for (int k = 0; k < seed.getFeaturesSelected().size(); k++) {
                            if (k == i) {
                                aux.add(bro.get(gerador.nextInt(bro.size())));
                            } else {
                                aux.add(seed.getFeaturesSelected().get(k));
                            }
                        }

                        ProductDeclaration productDefinition = new ProductDeclaration(new Id("p[" + i + "]"), aux);
                        pool.add(productDefinition);
                    }
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
