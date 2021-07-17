package util;

import implementations.GeneralType;
import implementations.Id;
import implementations.Types;

public class FNDefinition {
    protected Id featureName;
    protected Id extendedNode;
    protected GeneralType nodeType;

    public FNDefinition(Id featureName, Id extendedNode, GeneralType nodeType){
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

    public GeneralType getNodeType() {
        return nodeType;
    }
}
