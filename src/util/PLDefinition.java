package util;

import implementations.*;
import memory.CompilationEnvironment;

public class PLDefinition {
    protected Id plName;
    protected FeatureNameDeclarationList featureNameDeclarations;
    protected FormDeclaration formDeclaration;
    protected ProductDeclarationList productDeclarations;


    public PLDefinition(Id plName){
        this.plName = plName;
    }

    public PLDefinition(Id plName, FeatureNameDeclarationList featureNameDeclarationList,
                        FormDeclaration formDeclaration,
                        ProductDeclarationList productDeclarations){
        this.plName = plName;
        this.featureNameDeclarations = featureNameDeclarationList;
        this.formDeclaration = formDeclaration;
        this.productDeclarations = productDeclarations;
    }

    public Id getPlName() {
        return plName;
    }

    public FeatureNameDeclarationList getFeatureNameDeclarations() {
        return featureNameDeclarations;
    }

    public FormDeclaration getFormDeclaration() {
        return formDeclaration;
    }

    public ProductDeclarationList getProductDeclarations() {
        return productDeclarations;
    }

    public GeneralType getIdType(CompilationEnvironment compilationEnvironment){
        return IdTypeClass.PL_TYPE.getType(compilationEnvironment);
    }
}
