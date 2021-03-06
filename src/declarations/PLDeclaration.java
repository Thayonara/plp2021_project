package declarations;

import exceptions.*;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import types.IdTypeClass;
import types.IdTypeEnum;
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
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) throws PreviouslyDeclaredPLException, UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException, PreviouslyDeclaredFormException, UndeclaredFormException, PreviouslyDeclaredProductException, UndeclaredProductException {
        if (this.featureNameDeclarations != null) {
            featureNameDeclarations.elaborate(executionEnvironment);
        }
        if (this.formDeclaration != null ){
            this.formDeclaration.elaborate(executionEnvironment);
        }
        if (this.productDeclarations != null ){
            this.productDeclarations.elaborate(executionEnvironment);
        }
            executionEnvironment.mapPLDeclaration(this.plName, new PLDefinition(this.plName, this.featureNameDeclarations, this.formDeclaration, this.productDeclarations));
            executionEnvironment.map(this.plName, new PLDefinition(this.plName, this.featureNameDeclarations, this.formDeclaration, this.productDeclarations));

        return executionEnvironment;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) throws PreviouslyDeclaredPLException, UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException, PreviouslyDeclaredProductException, UndeclaredProductException, PreviouslyDeclaredFormException, UndeclaredFormException, ExtendsNullException, MultipleRootException, FormulaNotSatisfiedException, ExtendedNodeNotFoundException, MultipleSelectedAlternativesFeaturesException, MandatoryFeatureNotSelectedException {

        compilationEnvironment.mapPLDeclaration(this.plName, new PLDefinition(this.plName, this.featureNameDeclarations, this.formDeclaration, this.productDeclarations));
        compilationEnvironment.map(this.plName, new IdTypeClass(IdTypeEnum.PL));
        boolean rt= true;
        boolean rt1 = true;
        boolean rt2 = true;
        compilationEnvironment.increments();

        if(featureNameDeclarations != null) {
            rt = featureNameDeclarations.typeCheck(compilationEnvironment);

        }

        if(formDeclaration != null){
            rt1 = formDeclaration.TypeCheck(compilationEnvironment);
        }

        if(productDeclarations != null){
            rt2 = productDeclarations.typeCheck(compilationEnvironment);
        }


        compilationEnvironment.restore();
        return rt && rt1 && rt2;

       }



}
