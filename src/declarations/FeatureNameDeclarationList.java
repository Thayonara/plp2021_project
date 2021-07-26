package declarations;

import exceptions.*;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import util.Lista;

public class FeatureNameDeclarationList extends Lista<FeatureNameDeclaration> {

    public FeatureNameDeclarationList() {
    }

    public FeatureNameDeclarationList(FeatureNameDeclaration featureNameDeclaration) {
        super(featureNameDeclaration, null);
    }

    public FeatureNameDeclarationList(FeatureNameDeclaration featureNameDeclaration, FeatureNameDeclarationList featureNameDeclarationList) {
        super(featureNameDeclaration, featureNameDeclarationList);
    }


    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) throws PreviouslyDeclaredFNException, UndeclaredFNException, UndeclaredPLException {
        ExecutionEnvironment rt;
        if (getHead() != null) {
            if (getTail() != null) {
                rt = ((FeatureNameDeclarationList) getTail()).elaborate(getHead().elaborate(executionEnvironment));
            } else {
                rt = getHead().elaborate(executionEnvironment);
            }
        } else {
            rt = executionEnvironment;
        }
        return rt;
    }

    public boolean typeCheck(CompilationEnvironment compilationEnvironment) throws UndeclaredPLException, PreviouslyDeclaredFNException, UndeclaredFNException, ExtendsNullException, MultipleRootException {
        boolean rt;
        if (getHead() != null) {
            if (getTail() != null) {
                rt = getHead().TypeCheck(compilationEnvironment) &&
                        ((FeatureNameDeclarationList) getTail()).typeCheck(compilationEnvironment);
            } else {
                rt = getHead().TypeCheck(compilationEnvironment);
            }
        } else {
            rt = true;
        }
        return rt;
    }

    public CompilationEnvironment fnDeclarate(CompilationEnvironment compilationEnvironment) {
        CompilationEnvironment rt;
        if (getHead() != null) {
            if (getTail() != null) {
                rt = ((FeatureNameDeclarationList) getTail()).fnDeclarate(getHead().fnDeclarate(compilationEnvironment));
            } else {
                rt = getHead().fnDeclarate(compilationEnvironment);
            }
        } else {
            rt = compilationEnvironment;
        }
        return rt;
    }

    public FeatureNameDeclaration getFN(Id idFN) {
        FeatureNameDeclaration aux = this.head;
        Lista<FeatureNameDeclaration> auxList = this.tail;
        if (aux.getFeatureName().getIdName().equals(idFN.getIdName())) {
            return getHead();
        } else {
            return getFNAux(auxList, idFN);
        }

    }

    public FeatureNameDeclaration getFNAux(Lista<FeatureNameDeclaration> featureNameDeclarationList, Id id) {
        while (featureNameDeclarationList.getHead() != null) {
            if (featureNameDeclarationList.getHead().getFeatureName().toString().equalsIgnoreCase(id.getIdName())) {
                return featureNameDeclarationList.getHead();
            } else {
                if (tail != null) {
                    featureNameDeclarationList = featureNameDeclarationList.getTail();
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}