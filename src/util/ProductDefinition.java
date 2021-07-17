package util;

import implementations.FeatureNameDeclarationList;
import implementations.Id;

import java.util.List;

public class ProductDefinition {

    private Id productName;
    private FeatureNameDeclarationList featuresSelected;

    public ProductDefinition(Id productName, FeatureNameDeclarationList featuresSelected){
        this.productName = productName;
        this.featuresSelected = featuresSelected;
    }

    public Id getProductName() {
        return productName;
    }

    public FeatureNameDeclarationList getFeaturesSelected() {
        return featuresSelected;
    }
}
