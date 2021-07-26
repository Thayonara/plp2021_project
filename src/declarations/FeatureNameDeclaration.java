package declarations;

import exceptions.*;
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
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) throws UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException, ExtendsNullException, MultipleRootException {
        boolean rt = false;
        compilationEnvironment.increments();
        if(this.extendedNode != null){
            if(compilationEnvironment.getFNDefinition(this.extendedNode) != null){
                rt = this.nodeType.isValid(compilationEnvironment);
            } else{
                throw new UndeclaredFNException(this.extendedNode);
            }
        } else{
            //o tipo do nó tem que ser válido
            rt = this.nodeType.isValid(compilationEnvironment);
        }

        //todos, exceto o root, tem que extender de algum nó
        if(!(this.nodeType.getTipo().toString().equals("root")) && (this.extendedNode == null)){
          throw new ExtendsNullException(this.featureName);
        }
        //só pode haver um root
        if(this.nodeType.getTipo().toString().equals("root") && hasRoot(compilationEnvironment)){
            throw new MultipleRootException(this.featureName);
        }
        compilationEnvironment.restore();

        //add mapeamento da fn com o extended node
        if(this.extendedNode != null){
            compilationEnvironment.mapBefNode(this.featureName, this.extendedNode);
        }

        compilationEnvironment.mapFNDeclaration(this.featureName, new FNDefinition(this.featureName, this.extendedNode, this.nodeType));
        compilationEnvironment.map(this.featureName, new FNTypeClass(IdTypeEnum.FEATURENAME));

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
