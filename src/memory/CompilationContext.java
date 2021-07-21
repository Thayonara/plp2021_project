package memory;

import exceptions.*;
import implementations.FeatureNameDeclarationList;
import implementations.GeneralType;
import implementations.Id;
import implementations.ProductDeclarationList;
import util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CompilationContext implements CompilationEnvironment{

    /**
     * A pilha de tipos do contexto. Onde o tipo do id pode ser
     * um tipo primitivo ou uma classe.
     */
    private Stack<HashMap<Id, GeneralType>> stack;

    private Stack<HashMap<Id, FeatureNameDeclarationList>> fNStack;
    private Stack<HashMap<Id, ProductDeclarationList>> prodStack;

    private HashMap<Id, PLDefinition> plDefinitionMap;
    private HashMap<Id, FNDefinition> fnDefinitionMap;
    private HashMap<Id, FormDefinition> formDefinitionMap;
    private HashMap<Id, ProductDefinition> prodDefinitionMap;

    private ArrayList<BefNode> arrayBefNode;


    public CompilationContext(){
        this.stack = new Stack<HashMap<Id, GeneralType>>();
        this.fNStack = new Stack<HashMap<Id, FeatureNameDeclarationList>>();
        this.prodStack = new Stack<HashMap<Id, ProductDeclarationList>>();
        this.plDefinitionMap =  new HashMap<Id, PLDefinition>();
        this.fnDefinitionMap =  new HashMap<Id, FNDefinition>();
        this.formDefinitionMap =  new HashMap<Id, FormDefinition>();
        this.prodDefinitionMap =  new HashMap<Id, ProductDefinition>();
        this.arrayBefNode = new ArrayList <BefNode> ();
    }


    @Override
    public void mapBefNode(Id fnName, Id BefNodeName){
        BefNode befNode = getBefNode(BefNodeName);
        if (befNode != null) {
            arrayBefNode.add(new BefNode( fnName, BefNodeName));
        }
    }

    @Override
    public BefNode getBefNode(Id befNode) {
        for(int i=0; i < arrayBefNode.size(); i++){
            String befName = arrayBefNode.get(i).getBefNodeName().getIdName();
            if(befName.equalsIgnoreCase(befNode.getIdName())){
                return arrayBefNode.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Id> getChildrens(Id befId, Id idBro) {
        ArrayList<Id> childrens = new ArrayList <Id> ();
        for(int i=0; i < arrayBefNode.size(); i++){
            String befName = arrayBefNode.get(i).getBefNodeName().getIdName();
            if(befName.equalsIgnoreCase(befId.getIdName())){
                if(!(arrayBefNode.get(i).getPlName().getIdName().equalsIgnoreCase(idBro.getIdName()))){
                    childrens.add(arrayBefNode.get(i).getPlName());
                }
            }
        }
        return childrens;
    }

    @Override
    public void increments() {
        stack.push(new HashMap<Id, GeneralType>());
        fNStack.push(new HashMap<Id, FeatureNameDeclarationList>());
        prodStack.push(new HashMap<Id, ProductDeclarationList>());
    }

    @Override
    public void restore() {
        stack.pop();
        fNStack.pop();
        prodStack.pop();
    }

    @Override
    public void map(Id idArg, GeneralType tipoId) throws PreviouslyDeclaredIdException{
            HashMap<Id, GeneralType> aux = stack.peek();
            if (aux.put(idArg, tipoId) != null) {
                throw new PreviouslyDeclaredIdException("Id já declarado anteriormente.");
            }
    }

    @Override
    public GeneralType get(Id id) throws UndeclaredIdException{
            GeneralType result = null;
            Stack<HashMap<Id, GeneralType>> auxStack = new Stack<HashMap<Id, GeneralType>>();
            while (result == null && !stack.empty()) {
                HashMap<Id, GeneralType> aux = stack.pop();
                auxStack.push(aux);
                result = aux.get(id);
            }
            while (!auxStack.empty()) {
                stack.push(auxStack.pop());
            }
            if (result == null) {

                throw new UndeclaredIdException(id + " não declarado");

            } else {
                return result;
            }
    }

    @Override
    public void mapPLDeclaration(Id id, PLDefinition plDefinition) throws PreviouslyDeclaredPLException, UndeclaredPLException {
        PLDefinition plDefinition1 = getPlDefinition(id);
        if (plDefinition1 == null) {
            plDefinitionMap.put(id, plDefinition);
        } else {
            throw new PreviouslyDeclaredPLException(id);
        }
    }

    @Override
    public void mapFNDeclaration(Id id, FNDefinition fnDefinition) throws PreviouslyDeclaredFNException, UndeclaredFNException {
        FNDefinition fnDefinition1 = getFNDefinition(id);
        if (fnDefinition1 == null) {
            fnDefinitionMap.put(id, fnDefinition);
        } else {
            throw new PreviouslyDeclaredFNException(id);

        }
    }

    @Override
    public void mapFormDeclaration(Id id, FormDefinition formDefinition) throws PreviouslyDeclaredFormException, UndeclaredFormException {
        FormDefinition formDefinition1 = getFormDefinition(id);
        if (formDefinition1 != null) {
            formDefinitionMap.put(id, formDefinition);
        } else {
            throw new PreviouslyDeclaredFormException(id);

        }
    }

    @Override
    public void mapProdDeclaration(Id id, ProductDefinition productDefinition) throws PreviouslyDeclaredProductException, UndeclaredProductException {
        ProductDefinition productDefinition1 = getProdDefinition(id);
        if (productDefinition1 != null) {
            prodDefinitionMap.put(id, productDefinition);
        } else {
            throw new PreviouslyDeclaredProductException(id);
        }
    }

    @Override
    public PLDefinition getPlDefinition(Id id) throws UndeclaredPLException {
        PLDefinition result = null;
        result = this.plDefinitionMap.get(id);
        if (result == null) {
           // throw new UndeclaredPLException(id);
            return null;
        } else {
            return result;
        }
    }

    @Override
    public FNDefinition getFNDefinition(Id id) throws UndeclaredFNException {
        FNDefinition result = null;
        result = this.fnDefinitionMap.get(id);
        if (result == null) {
            //throw new UndeclaredFNException(id);
            return null;
        } else {
            return result;
        }
    }

    @Override
    public FormDefinition getFormDefinition(Id id) throws UndeclaredFormException {
        FormDefinition result = null;
        result = this.formDefinitionMap.get(id);
        if (result == null) {
            //throw new UndeclaredFormException(id);
            return null;
        } else {
            return result;
        }
    }

    @Override
    public ProductDefinition getProdDefinition(Id id) throws UndeclaredProductException {
        ProductDefinition result = null;
        result = this.prodDefinitionMap.get(id);
        if (result == null) {
            //throw new UndeclaredProductException(id);
            return null;
        } else {
            return result;
        }
    }
}
