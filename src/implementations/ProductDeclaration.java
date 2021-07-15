package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Declaration;

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

    public IdType getTypeId(){
        return productName.getIdType();
    }

    @Override
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) {
        return null;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) {
        return false;
    }
}
