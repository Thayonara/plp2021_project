package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Declaration;
import util.Lista;
import util.ProductDefinition;


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
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) {
        executionEnvironment.mapProdDeclaration(this.productName, new ProductDefinition(this.productName, this.featuresSelected));
        return executionEnvironment;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) {
        for(int i = 0; i < this.featuresSelected.length(); i++){
            if(compilationEnvironment.getFNType(featuresSelected.getHead().getFeatureName())== null){
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
                    Lista<Id> broNodes = compilationEnvironment.getChildrens(befNode);
                    for(int j = 0; j < broNodes.length(); j++){
                        Id broCurrent = broNodes.getHead();
                        if(compilationEnvironment.getFNType(broCurrent).equals( FNTypeClass.MANDATORY_TYPE)){
                            if(!(isPresent(featureNameDeclarationList, broCurrent))){
                               return false;
                            } else {
                                if(compilationEnvironment.getFNType(broCurrent).equals( FNTypeClass.ALTERNATIVE_TYPE)){
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
        compilationEnvironment.map(this.productName, IdTypeClass.PROD_TYPE);
        return compilationEnvironment;
    }
}
