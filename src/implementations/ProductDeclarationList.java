package implementations;

import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Lista;

public class ProductDeclarationList extends Lista<ProductDeclaration> {

    public ProductDeclarationList(){}
    public ProductDeclarationList(ProductDeclaration productDeclaration){
        super(productDeclaration, null);
    }

    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) {
        ExecutionEnvironment rt;
        if(getHead() != null) {
            if(getTail() != null) {
                rt = ((ProductDeclarationList) getTail()).elaborate(getHead().elaborate(executionEnvironment));
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
                        ((ProductDeclarationList)getTail()).typeCheck(compilationEnvironment);
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

    public CompilationEnvironment prodDeclarates(CompilationEnvironment compilationEnvironment){
        CompilationEnvironment rt;
        if(getHead() != null) {
            if(getTail() != null) {
                rt = ((ProductDeclarationList)getTail()).prodDeclarates(getHead().prodDeclarate(compilationEnvironment));
            }
            else {
                rt = getHead().prodDeclarate(compilationEnvironment);
            }
        }
        else {
            rt = compilationEnvironment;
        }
        return rt;
    }






}
