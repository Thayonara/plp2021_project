package implementations;

import exceptions.PreviouslyDeclaredFNException;
import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Declaration;
import util.FNDefinition;
import util.PLDefinition;

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
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) throws PreviouslyDeclaredFNException, UndeclaredFNException, UndeclaredPLException {
        if(extendedNode != null){
            executionEnvironment.mapFNDeclaration(this.featureName, new FNDefinition(this.featureName, this.extendedNode, this.nodeType));
            executionEnvironment.map(this.featureName, new FNDefinition(this.featureName, this.extendedNode, this.nodeType));
            executionEnvironment.mapBefNode(featureName, extendedNode);

        } else{
            executionEnvironment.mapFNDeclaration(this.featureName, new FNDefinition(this.featureName, this.extendedNode, this.nodeType));
            executionEnvironment.map(this.featureName, new FNDefinition(this.featureName, this.extendedNode, this.nodeType));

        }

         return executionEnvironment;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) throws UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException {
        boolean rt = false;

        if(this.extendedNode != null){
            compilationEnvironment.mapBefNode(this.featureName, this.extendedNode);
        }

        compilationEnvironment.increments();
        if(this.extendedNode != null){
            if(compilationEnvironment.getFNDefinition(this.extendedNode) != null){
                rt = this.nodeType.isValid(compilationEnvironment);
            }
        } else{
            rt = this.nodeType.isValid(compilationEnvironment);
        }

        compilationEnvironment.restore();
        compilationEnvironment.mapFNDeclaration(this.featureName, new FNDefinition(this.featureName, this.extendedNode, this.nodeType));
        compilationEnvironment.map(this.featureName, new FNTypeClass(IdTypeEnum.FEATURENAME));
        return rt;
    }

    public CompilationEnvironment fnDeclarate(CompilationEnvironment compilationEnvironment){
        compilationEnvironment.map(this.featureName, this.nodeType);
        return compilationEnvironment;
    }
}
