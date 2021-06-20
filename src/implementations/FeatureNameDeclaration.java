package implementations;

public class FeatureNameDeclaration {
    protected Id featureName;
    protected Id extendedNode;
    protected Types nodeType;

    public FeatureNameDeclaration(Id featureName, Id extendedNode, Types nodeType){
        this.featureName = featureName;
        this.extendedNode = extendedNode;
        this.nodeType = nodeType;
    }

}
