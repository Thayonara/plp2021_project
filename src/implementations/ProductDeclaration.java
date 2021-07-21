package implementations;

import exceptions.PreviouslyDeclaredProductException;
import exceptions.UndeclaredProductException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Declaration;
import util.Lista;
import util.ProductDefinition;

import java.util.List;


public class ProductDeclaration implements Declaration {

    private Id productName;
    private List<Id> featuresSelected;

    public ProductDeclaration(Id productName, List<Id> featuresSelected){
        this.productName = productName;
        this.featuresSelected = featuresSelected;
    }

    public Id getProductName() {
        return productName;
    }

    public List<Id> getFeaturesSelected() {
        return featuresSelected;
    }

    @Override
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) throws PreviouslyDeclaredProductException, UndeclaredProductException {
        executionEnvironment.mapProdDeclaration(this.productName, new ProductDefinition(this.productName, this.featuresSelected));
        executionEnvironment.map(this.productName, new ProductDefinition(this.productName, this.featuresSelected));
        return executionEnvironment;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) {
        for(int i = 0; i < this.featuresSelected.size(); i++){
            if(compilationEnvironment.get(featuresSelected.get(i))== null){
                return false;
            }
        }

        return isFormValid(compilationEnvironment, featuresSelected);
    }


    public boolean isPresent(List<Id> featureNameDeclarationList,
                             Id featureNameDeclaration){
        boolean rt = false;
        for(int i = 0; i < featureNameDeclarationList.size(); i++){
            if(featureNameDeclarationList.get(i).getIdName().equals(featureNameDeclaration.getIdName())){
                return true;
            }
        }

        return rt;
    }

    public boolean isFormValid(CompilationEnvironment compilationEnvironment, List<Id> featureNameDeclarationList){
        boolean isRoot = false;
        for (int i = 0; i < featureNameDeclarationList.size(); i ++){
            FeatureNameDeclaration current = (FeatureNameDeclaration) compilationEnvironment.get(featureNameDeclarationList.get(i));
            isRoot = current.getNodeType().getTipo() == FNTypeClass.ROOT_TYPE.getType(compilationEnvironment);
            if (!isRoot){
                boolean isAlternative = current.getNodeType().getTipo() == FNTypeClass.ALTERNATIVE_TYPE.getType(compilationEnvironment);
                Id befNode = current.extendedNode;
                if(!(isPresent(featureNameDeclarationList, befNode))){
                    return false;
                } else{
                    List<Id> broNodes = compilationEnvironment.getChildrens(befNode, current.getFeatureName());
                    for(int j = 0; j < broNodes.size(); j++){
                        Id broCurrent = broNodes.get(j);
                        if(compilationEnvironment.get(broCurrent).getTipo().equals( FNTypeClass.MANDATORY_TYPE.getType(compilationEnvironment))){
                            if(!(isPresent(featureNameDeclarationList, broCurrent))){
                                return false;
                            } else {
                                if(compilationEnvironment.get(broCurrent).getTipo().equals( FNTypeClass.ALTERNATIVE_TYPE.getType(compilationEnvironment))){
                                    if (isPresent(featureNameDeclarationList, broCurrent)){
                                        if (isAlternative){
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }


                }

            }
        }

        return isRoot;
    }

    public CompilationEnvironment prodDeclarate(CompilationEnvironment compilationEnvironment){
        compilationEnvironment.map(this.productName, IdTypeClass.PROD_TYPE.getType(compilationEnvironment));
        return compilationEnvironment;
    }



}