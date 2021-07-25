package declarations;

import exceptions.PreviouslyDeclaredFNException;
import exceptions.UndeclaredFNException;
import exceptions.UndeclaredPLException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import types.FNTypeClass;
import types.GeneralType;
import types.IdTypeEnum;
import util.Declaration;
import util.FNDefinition;

import java.util.ArrayList;
import java.util.List;

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

        if(!(this.nodeType.getTipo().toString().equals("root")) && (this.extendedNode == null)){
            rt = false;
        }

        if(this.nodeType.getTipo().toString().equals("root") && hasRoot(compilationEnvironment)){
            rt = false;
        }

        compilationEnvironment.restore();
        if(rt){
            compilationEnvironment.mapFNDeclaration(this.featureName, new FNDefinition(this.featureName, this.extendedNode, this.nodeType));
            compilationEnvironment.map(this.featureName, new FNTypeClass(IdTypeEnum.FEATURENAME));
        }
        return rt;
    }

    public CompilationEnvironment fnDeclarate(CompilationEnvironment compilationEnvironment){
        compilationEnvironment.map(this.featureName, this.nodeType);
        return compilationEnvironment;
    }

    public boolean hasRoot(CompilationEnvironment compilationEnvironment){
        List<FNDefinition> fns = new ArrayList<>(compilationEnvironment.getFNDefinitions().values());
        for(int i = 0; i < fns.size(); i++){
            if(fns.get(i).getNodeType().getTipo().toString().equals("root")){
                return true;
            }
        }
        return false;
    }
}
