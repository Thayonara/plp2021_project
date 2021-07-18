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
    private FeatureNameDeclarationList featuresSelected;

    public ProductDeclaration(Id productName, FeatureNameDeclarationList featuresSelected){
        this.productName = productName;
        this.featuresSelected = featuresSelected;
    }

    public Id getProductName() {
        return productName;
    }

    public FeatureNameDeclarationList getFeaturesSelected() {
        return featuresSelected;
    }

    @Override
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) throws PreviouslyDeclaredProductException, UndeclaredProductException {
        executionEnvironment.mapProdDeclaration(this.productName, new ProductDefinition(this.productName, this.featuresSelected));
        return executionEnvironment;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) {
        for(int i = 0; i < this.featuresSelected.length(); i++){
            if(compilationEnvironment.get(featuresSelected.getHead().getFeatureName())== null){
                return false;
            }
        }

        return isFormValid(compilationEnvironment, featuresSelected);
    }


    public boolean isPresent(FeatureNameDeclarationList featureNameDeclarationList,
                             Id featureNameDeclaration){
        boolean rt = false;
        if(featureNameDeclarationList.length() > 1){
            if(featureNameDeclarationList.getHead().getFeatureName().equals(featureNameDeclaration)){
                return true;
            } else{
                featureNameDeclarationList = (FeatureNameDeclarationList) featureNameDeclarationList.getTail();
                isPresent(featureNameDeclarationList, featureNameDeclaration);
            }
        }

        return rt;
    }

    public boolean isFormValid(CompilationEnvironment compilationEnvironment, FeatureNameDeclarationList featureNameDeclarationList){
        boolean hasBefNode = true;
        for (int i = 0; i < featureNameDeclarationList.length(); i ++){
            FeatureNameDeclaration current = featureNameDeclarationList.getHead();
            boolean isRoot = current.getNodeType().getTipo() == FNTypeClass.ROOT_TYPE;
            if (!isRoot){
                boolean isAlternative = current.getNodeType().getTipo() == FNTypeClass.ALTERNATIVE_TYPE;
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

        return true;
    }

    public CompilationEnvironment prodDeclarate(CompilationEnvironment compilationEnvironment){
        compilationEnvironment.map(this.productName, IdTypeClass.PROD_TYPE.getType(compilationEnvironment));
        return compilationEnvironment;
    }
}
