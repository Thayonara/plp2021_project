package memory;

import exceptions.*;
import implementations.GeneralType;
import implementations.Id;
import util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ExecutionContext implements ExecutionEnvironment{
    private HashMap<Id, PLDefinition> plDefinitionHashMap;
    private HashMap<Id, FNDefinition> fnDefinitionHashMap;
    private HashMap<Id, FormDefinition> formDefinitionHashMap;
    private HashMap<Id, ProductDefinition> productDefinitionHashMap;
    private ArrayList<BefNode> arrayBefNode;
    private Stack<HashMap<Id, Object>> stack;



    public ExecutionContext(){
        this.plDefinitionHashMap = new HashMap<Id, PLDefinition>();
        this.fnDefinitionHashMap = new HashMap<Id, FNDefinition>();
        this.formDefinitionHashMap = new HashMap<Id, FormDefinition>();
        this.productDefinitionHashMap = new HashMap<Id, ProductDefinition>();
        this.arrayBefNode = new ArrayList <BefNode> ();
        this.stack = new Stack<HashMap<Id, Object>>();

    }

    public ExecutionContext(ExecutionEnvironment executionEnvironment){
        this.plDefinitionHashMap = new HashMap<Id, PLDefinition>();
        this.fnDefinitionHashMap = new HashMap<Id, FNDefinition>();
        this.formDefinitionHashMap = new HashMap<Id, FormDefinition>();
        this.productDefinitionHashMap = new HashMap<Id, ProductDefinition>();
        this.arrayBefNode = new ArrayList <BefNode> ();
        this.stack = new Stack<HashMap<Id, Object>>();

    }


    @Override
    public void increments() {
        stack.push(new HashMap<Id, Object>());

    }

    @Override
    public void restore() {
        stack.pop();

    }

    @Override
    public void map(Id idArg, Object obj) throws PreviouslyDeclaredIdException {
        HashMap<Id, Object> aux = stack.peek();
        if (aux.put(idArg, obj) != null) {
            throw new PreviouslyDeclaredIdException("Id já declarado anteriormente.");
     }
    }

    @Override
    public Object get(Id id) throws UndeclaredIdException {
        Object result = null;
        Stack<HashMap<Id, Object>> auxStack = new Stack<HashMap<Id, Object>>();
        while (result == null && !stack.empty()) {
            HashMap<Id, Object> aux = stack.pop();
            auxStack.push(aux);
            result = aux.get(id);
        }
        while (!auxStack.empty()) {
            stack.push(auxStack.pop());
        }
        if (result == null) {
            throw new UndeclaredIdException("Id não declarado anteriormente.");
        } else {
            return result;
        }
    }

    @Override
    public void mapBefNode(Id plName, Id BefNodeName) throws UndeclaredPLException {
        PLDefinition plDefinition = getPlDefinition(BefNodeName);
        if (plDefinition != null) {
            arrayBefNode.add(new BefNode( plName, BefNodeName));
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
    public Stack<HashMap<Id, Object>> getStack() {
        return null;
    }

    @Override
    public HashMap<Id, PLDefinition> getMapPLDef() {
        return this.plDefinitionHashMap;
    }

    @Override
    public HashMap<Id, FNDefinition> getMapFNDef() {
        return this.fnDefinitionHashMap;
    }

    @Override
    public HashMap<Id, FormDefinition> getMapFormDef() {
        return this.formDefinitionHashMap;
    }

    @Override
    public HashMap<Id, ProductDefinition> getMapProductDef() {
        return this.productDefinitionHashMap;
    }

    @Override
    public void mapPLDeclaration(Id id, PLDefinition plDefinition) throws PreviouslyDeclaredPLException, UndeclaredPLException {
        PLDefinition plDefinition1 = getPlDefinition(id);
        if (plDefinition1 != null) {
            plDefinitionHashMap.put(id, plDefinition);
        } else {
            throw new PreviouslyDeclaredPLException(id);
        }
    }

    @Override
    public void mapFNDeclaration(Id id, FNDefinition fnDefinition) throws PreviouslyDeclaredFNException, UndeclaredFNException {
        FNDefinition fnDefinition1 = getFNDefinition(id);
        if (fnDefinition1 != null) {
            fnDefinitionHashMap.put(id, fnDefinition);
        } else {
            throw new PreviouslyDeclaredFNException(id);

        }
    }

    @Override
    public void mapFormDeclaration(Id id, FormDefinition formDefinition) throws PreviouslyDeclaredFormException, UndeclaredFormException {
        FormDefinition formDefinition1 = getFormDefinition(id);
        if (formDefinition1 != null) {
            formDefinitionHashMap.put(id, formDefinition);
        } else {
            throw new PreviouslyDeclaredFormException(id);

        }
    }

    @Override
    public void mapProdDeclaration(Id id, ProductDefinition productDefinition) throws PreviouslyDeclaredProductException, UndeclaredProductException {
        ProductDefinition productDefinition1 = getProdDefinition(id);
        if (productDefinition1 != null) {
            productDefinitionHashMap.put(id, productDefinition);
        } else {
            throw new PreviouslyDeclaredProductException(id);
        }
    }
    @Override
    public PLDefinition getPlDefinition(Id id) throws UndeclaredPLException {
        PLDefinition result = null;
        result = this.plDefinitionHashMap.get(id);
        if (result == null) {
            throw new UndeclaredPLException(id);
        } else {
            return result;
        }
    }

    @Override
    public FNDefinition getFNDefinition(Id id) throws UndeclaredFNException {
        FNDefinition result = null;
        result = this.fnDefinitionHashMap.get(id);
        if (result == null) {
            throw new UndeclaredFNException(id);
        } else {
            return result;
        }
    }

    @Override
    public FormDefinition getFormDefinition(Id id) throws UndeclaredFormException {
        FormDefinition result = null;
        result = this.formDefinitionHashMap.get(id);
        if (result == null) {
            throw new UndeclaredFormException(id);
        } else {
            return result;
        }
    }

    @Override
    public ProductDefinition getProdDefinition(Id id) throws UndeclaredProductException {
        ProductDefinition result = null;
        result = this.productDefinitionHashMap.get(id);
        if (result == null) {
            throw new UndeclaredProductException(id);
        } else {
            return result;
        }
    }

}