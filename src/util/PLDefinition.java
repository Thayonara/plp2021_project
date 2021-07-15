package util;

import implementations.*;

public class PLDefinition {
    protected Id plName;
    protected FeatureNameDeclaration featureNameDeclarations;
    protected FormDeclaration formDeclaration;
    protected ProductDeclaration productDeclarations;


    public PLDefinition(Id plName){
        this.plName = plName;
    }

    public PLDefinition(Id plName, FeatureNameDeclaration featureNameDeclarations,
                        FormDeclaration formDeclaration,
                        ProductDeclaration productDeclarations){
        this.plName = plName;
        this.featureNameDeclarations = featureNameDeclarations;
        this.formDeclaration = formDeclaration;
        this.productDeclarations = productDeclarations;
    }

    public Id getPlName() {
        return plName;
    }

    public FeatureNameDeclaration getFeatureNameDeclarations() {
        return featureNameDeclarations;
    }

    public FormDeclaration getFormDeclaration() {
        return formDeclaration;
    }

    public ProductDeclaration getProductDeclarations() {
        return productDeclarations;
    }

    public IdType getIdType(){
        return plName.getIdType();
    }
}
