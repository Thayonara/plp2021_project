package implementations;

import java.util.List;

public class ProductDeclaration {

    private Id productName;
    private List<Id> featuresSelected;

    public ProductDeclaration(Id productName, List<Id> featuresSelected){
        this.productName = productName;
        this.featuresSelected = featuresSelected;
    }
}
