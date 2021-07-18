package implementations;

import exceptions.PreviouslyDeclaredFNException;
import exceptions.UndeclaredFNException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Declaration;
import util.FNDefinition;

public class FeatureNameDeclaration implements Declaration {
    protected Id featureName;
    protected Id extendedNode;
    protected GeneralType nodeType;

    public FeatureNameDeclaration(Id featureName, Id extendedNode, GeneralType nodeType){
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


    @Override
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) throws PreviouslyDeclaredFNException, UndeclaredFNException {
        executionEnvironment.mapFNDeclaration(this.featureName, new FNDefinition(this.featureName, this.extendedNode, this.nodeType));
        return executionEnvironment;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) {
        boolean rt = false;
        if(compilationEnvironment.get(this.extendedNode) != null){
            rt = this.nodeType.isValid(compilationEnvironment);
        }

        return rt;
    }

    public CompilationEnvironment fnDeclarate(CompilationEnvironment compilationEnvironment){
        compilationEnvironment.map(this.featureName, this.nodeType);
        return compilationEnvironment;
    }
}
