package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Lista;

public class FeatureNameDeclarationList extends Lista<FeatureNameDeclaration> {

    public FeatureNameDeclarationList(){}
    public FeatureNameDeclarationList(FeatureNameDeclaration featureNameDeclaration){
        super(featureNameDeclaration, null);
    }


    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) {
        ExecutionEnvironment rt;
        if(getHead() != null) {
            if(getTail() != null) {
                rt = ((FeatureNameDeclarationList)getTail()).elaborate(getHead().elaborate(executionEnvironment));
            }
            else {
                rt = getHead().elaborate(executionEnvironment);
            }
        }
        else {
            rt  = executionEnvironment;
        }
        return rt;
    }

    public boolean typeCheck(CompilationEnvironment compilationEnvironment){
        boolean rt;
        if(getHead() != null) {
            if(getTail() != null) {
                rt = getHead().TypeCheck(compilationEnvironment) &&
                        ((FeatureNameDeclarationList)getTail()).typeCheck(compilationEnvironment);
            }
            else {
                rt = getHead().TypeCheck(compilationEnvironment);
            }
        }
        else {
            rt = true;
        }
        return rt;
    }

    public CompilationEnvironment fnDeclarate(CompilationEnvironment compilationEnvironment){
        CompilationEnvironment rt;
        if(getHead() != null) {
            if(getTail() != null) {
                rt = ((FeatureNameDeclarationList)getTail()).fnDeclarate(getHead().fnDeclarate(compilationEnvironment));
            }
            else {
                rt = getHead().fnDeclarate(compilationEnvironment);
            }
        }
        else {
            rt = compilationEnvironment;
        }
        return rt;
    }






}
