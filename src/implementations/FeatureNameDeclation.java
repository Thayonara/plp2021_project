package implementations;

public class FeatureNameDeclation {
    protected Id featureName;
    protected Id extendedNode;
    protected Types nodeType;

    public FeatureNameDeclation(Id featureName, Id extendedNode, Types nodeType){
        this.featureName = featureName;
        this.extendedNode = extendedNode;
        this.nodeType = nodeType;
    }

}
