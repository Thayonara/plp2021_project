package util;

import implementations.Id;
import implementations.Types;

public class FNDefinition {
    protected Id featureName;
    protected Id extendedNode;
    protected Types nodeType;

    public FNDefinition(Id featureName, Id extendedNode, Types nodeType){
        this.featureName = featureName;
        this.extendedNode = extendedNode;
        this.nodeType = nodeType;
    }

    public Id getFeatureName() {
        return featureName;
    }

    public Id getExtendedNode() {
        return extendedNode;
    }

    public Types getNodeType() {
        return nodeType;
    }
}
