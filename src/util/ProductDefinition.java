package util;

import implementations.Id;

import java.util.List;

public class ProductDefinition {

    private Id productName;
    private List<Id> featuresSelected;

    public ProductDefinition(Id productName, List<Id> featuresSelected){
        this.productName = productName;
        this.featuresSelected = featuresSelected;
    }

    public Id getProductName() {
        return productName;
    }

    public List<Id> getFeaturesSelected() {
        return featuresSelected;
    }
}
