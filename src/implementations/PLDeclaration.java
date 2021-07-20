package implementations;

import exceptions.PreviouslyDeclaredPLException;
import exceptions.UndeclaredPLException;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Declaration;
import util.PLDefinition;

public class PLDeclaration implements Declaration {
    protected Id plName;
    protected FeatureNameDeclarationList featureNameDeclarations;
    protected FormDeclaration formDeclaration;
    protected ProductDeclarationList productDeclarations;


    public PLDeclaration(Id plName){
        this.plName = plName;
    }

    public PLDeclaration(Id plName, FeatureNameDeclarationList featureNameDeclarationList,
                        FormDeclaration formDeclaration,
                        ProductDeclarationList productDeclarations){
        this.plName = plName;
        this.featureNameDeclarations = featureNameDeclarationList;
        this.formDeclaration = formDeclaration;
        this.productDeclarations = productDeclarations;
    }


    @Override
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) throws PreviouslyDeclaredPLException, UndeclaredPLException {
        if (this.featureNameDeclarations == null){
            executionEnvironment.mapPLDeclaration(this.plName, new PLDefinition(this.plName));
            executionEnvironment.map(this.plName, new PLDefinition(this.plName));
        } else {
            executionEnvironment.mapPLDeclaration(this.plName, new PLDefinition(this.plName, this.featureNameDeclarations, this.formDeclaration, this.productDeclarations));
            executionEnvironment.map(this.plName, new PLDefinition(this.plName, this.featureNameDeclarations, this.formDeclaration, this.productDeclarations));
        }
        return executionEnvironment;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) throws PreviouslyDeclaredPLException, UndeclaredPLException {
        compilationEnvironment.mapPLDeclaration(this.plName, new PLDefinition(this.plName, this.featureNameDeclarations, this.formDeclaration, this.productDeclarations));
        boolean rt = false;
        compilationEnvironment.increments();
        if(compilationEnvironment.get(plName) == null){
            rt = featureNameDeclarations.typeCheck(compilationEnvironment) &&
                    formDeclaration.TypeCheck(compilationEnvironment) &&
                        productDeclarations.typeCheck(compilationEnvironment);
        }
        compilationEnvironment.restore();
        return rt;
    }
}
