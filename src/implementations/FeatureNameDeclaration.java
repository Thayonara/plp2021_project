package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Declaration;

public class FeatureNameDeclaration implements Declaration {
    protected Id featureName;
    protected Id extendedNode;
    protected Types nodeType;

    public FeatureNameDeclaration(Id featureName, Id extendedNode, Types nodeType){
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

    public IdType getType(){
        return featureName.getIdType();
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
