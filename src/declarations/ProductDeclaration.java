package declarations;

import exceptions.*;
import memory.CompilationEnvironment;
import memory.ExecutionEnvironment;
import types.FNTypeClass;
import types.IdTypeClass;
import types.IdTypeEnum;
import types.Types;
import util.*;

import java.util.ArrayList;
import java.util.List;


public class ProductDeclaration implements Declaration {

    private Id productName;
    private List<Id> featuresSelected;

    public ProductDeclaration(Id productName, List<Id> featuresSelected) {
        this.productName = productName;
        this.featuresSelected = featuresSelected;
    }

    public Id getProductName() {
        return productName;
    }

    public List<Id> getFeaturesSelected() {
        return featuresSelected;
    }

    @Override
    public ExecutionEnvironment elaborate(ExecutionEnvironment executionEnvironment) throws PreviouslyDeclaredProductException, UndeclaredProductException {
       executionEnvironment.mapProdDeclaration(this.productName, new ProductDefinition(this.productName, this.featuresSelected));
       executionEnvironment.map(this.productName, new ProductDefinition(this.productName, this.featuresSelected));


        return executionEnvironment;
    }

    @Override
    public boolean TypeCheck(CompilationEnvironment compilationEnvironment) throws UndeclaredFNException, PreviouslyDeclaredProductException, UndeclaredProductException, FormulaNotSatisfiedException, ExtendedNodeNotFoundException, MultipleSelectedAlternativesFeaturesException, MandatoryFeatureNotSelectedException {
        compilationEnvironment.increments();
        //checa se todas as features foram declaradas
        for (int i = 0; i < this.featuresSelected.size(); i++) {
            if (compilationEnvironment.get(featuresSelected.get(i)) == null) {
                throw new UndeclaredFNException(featuresSelected.get(i));
            }
        }
        compilationEnvironment.mapProdDeclaration(this.productName, new ProductDefinition(this.productName, this.featuresSelected));
        compilationEnvironment.map(this.productName, new IdTypeClass(IdTypeEnum.PRODUCT));

        //recupera fórmula prevismente definida
        List<FormDefinition> formDefinitions = new ArrayList<>(compilationEnvironment.getFormDefinitions().values());

        //checa se a fórmula é satisfeita no produto
        if(formDefinitions.get(0) != null){
            if(!(formDefinitions.get(0).getFormula().evaluate(compilationEnvironment, this))) {
                throw new FormulaNotSatisfiedException(this.productName);
            }
        }
        compilationEnvironment.restore();
        //checa se as restrições da hierarquia é satisfeita no produto
        return isFormValid(compilationEnvironment, featuresSelected);
    }


    public boolean isPresent(List<Id> featureNameDeclarationList,
                             Id featureNameDeclaration) {
        boolean rt = false;
        for (int i = 0; i < featureNameDeclarationList.size(); i++) {
            if (featureNameDeclarationList.get(i).getIdName().equals(featureNameDeclaration.getIdName())) {
                return true;
            }
        }

        return rt;
    }

    /*
    - o root estará sempre presente
    - para os demais nós:
            - se o current é alternativo, não pode haver irmão alternartivo também
            - checa se há algum irmão MANDATORY que não está presente
            - o produto tem que contem o pai do current
            - se tem filho que é mandatório
            - se tem algum filho que é alternativo
     */

    public boolean isFormValid(CompilationEnvironment compilationEnvironment, List<Id> featureNameDeclarationList) throws UndeclaredFNException, ExtendedNodeNotFoundException, MultipleSelectedAlternativesFeaturesException, MandatoryFeatureNotSelectedException {
        boolean isRoot= false;
        boolean alternativePresent = false;
        boolean hasAlternative = true;

        for (int i = 0; i < featureNameDeclarationList.size(); i++) {
            FNDefinition fnDefinition = compilationEnvironment.getFNDefinition(featureNameDeclarationList.get(i));
            FeatureNameDeclaration current = new FeatureNameDeclaration(fnDefinition.getFeatureName(), fnDefinition.getExtendedNode(), fnDefinition.getNodeType());
            //o root sempre estará presente
            if (current.getNodeType().getTipo().toString().equals(new FNTypeClass(Types.ROOT).getTipo().toString())) {
                isRoot = true;
            } else {
                //marcar o current como alternative feature
                boolean isAlternative = current.getNodeType().getTipo().toString().equals(new FNTypeClass(Types.ALTERNATIVE).getTipo().toString());
                Id befNode = current.extendedNode;
                if (!(isPresent(featureNameDeclarationList, befNode))) {
                    throw new ExtendedNodeNotFoundException(current.featureName, this.productName);
                } else {
                    //recupera a lista de irmãos do current para identificar se falta algun nó mandatório ou se a restrição alternative não está sendo seguida
                    List<Id> broNodes = compilationEnvironment.getChildrens(befNode, current.getFeatureName());
                    for (int j = 0; j < broNodes.size(); j++) {
                        Id broCurrent = broNodes.get(j);
                        if (compilationEnvironment.getFNDefinition(broCurrent).getNodeType().toString().equals(new FNTypeClass(Types.MANDATORY).getTipo().toString())) {
                            if (!(isPresent(featureNameDeclarationList, broCurrent))) {
                                throw new MandatoryFeatureNotSelectedException(broCurrent, this.productName);
                            }
                        } else {
                            if (compilationEnvironment.getFNDefinition(broCurrent).getNodeType().toString().equals(new FNTypeClass(Types.ALTERNATIVE).getTipo().toString())) {
                                if (isPresent(featureNameDeclarationList, broCurrent)) {
                                    if (isAlternative) {
                                        throw new MultipleSelectedAlternativesFeaturesException(broCurrent, this.productName);
                                    }
                                }
                            }

                        }
                    }


                }

            }
            List<Id> childrens = compilationEnvironment.getChildrens(current.featureName, current.getFeatureName());
            for (int z = 0; z < childrens.size(); z++) {
                Id childCurrent = childrens.get(z);
                if (compilationEnvironment.getFNDefinition(childCurrent).getNodeType().toString().equals(new FNTypeClass(Types.MANDATORY).getTipo().toString())) {
                    if (!(isPresent(featureNameDeclarationList, childCurrent))) {
                        throw new MandatoryFeatureNotSelectedException(childCurrent, this.productName);
                    }
                } else {
                    if (compilationEnvironment.getFNDefinition(childCurrent).getNodeType().toString().equals(new FNTypeClass(Types.ALTERNATIVE).getTipo().toString())) {
                        if (!(isPresent(featureNameDeclarationList, childCurrent)) && !(alternativePresent)) {
                            hasAlternative = false;
                        }
                        if ((isPresent(featureNameDeclarationList, childCurrent))) {
                            alternativePresent = true;
                            hasAlternative = true;

                        }

                    }

                }

            }

        }

        return isRoot && hasAlternative;
    }

    public CompilationEnvironment prodDeclarate(CompilationEnvironment compilationEnvironment) {
        compilationEnvironment.map(this.productName, IdTypeClass.PROD_TYPE.getType(compilationEnvironment));
        return compilationEnvironment;
    }


}