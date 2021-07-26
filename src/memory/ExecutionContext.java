package memory;

import exceptions.*;
import declarations.Id;
import declarations.ProductDeclaration;
import util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ExecutionContext implements ExecutionEnvironment{
    private HashMap<Id, PLDefinition> plDefinitionHashMap;
    private HashMap<Id, FNDefinition> fnDefinitionHashMap;
    private HashMap<Id, FormDefinition> formDefinitionHashMap;
    private HashMap<Id, ProductDefinition> productDefinitionHashMap;
    private HashMap<String, List<ProductDeclaration>> poolTest;
    private ArrayList<BefNode> arrayBefNode;
    private Stack<HashMap<Id, Object>> stack;



    public ExecutionContext(){
        this.plDefinitionHashMap = new HashMap<Id, PLDefinition>();
        this.fnDefinitionHashMap = new HashMap<Id, FNDefinition>();
        this.formDefinitionHashMap = new HashMap<Id, FormDefinition>();
        this.productDefinitionHashMap = new HashMap<Id, ProductDefinition>();
        this.poolTest = new HashMap<String, List<ProductDeclaration>>();
        this.arrayBefNode = new ArrayList <BefNode> ();
        this.stack = new Stack<HashMap<Id, Object>>();

    }

    public ExecutionContext(ExecutionEnvironment executionEnvironment){
        this.plDefinitionHashMap = new HashMap<Id, PLDefinition>();
        this.fnDefinitionHashMap = new HashMap<Id, FNDefinition>();
        this.formDefinitionHashMap = new HashMap<Id, FormDefinition>();
        this.productDefinitionHashMap = new HashMap<Id, ProductDefinition>();
        this.poolTest = new HashMap<String, List<ProductDeclaration>>();
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
        if (plDefinition == null) {
            arrayBefNode.add(new BefNode( plName, BefNodeName));
        }
    }

    @Override
    public void mapPoolTest(String idPl, List<ProductDeclaration> productDeclarationList) {
        poolTest.put(idPl, productDeclarationList);

    }

    @Override
    public List<ProductDeclaration> getPoolTesting(Id idPL) {
        return this.poolTest.get(idPL);
    }

    @Override
    public HashMap<String, List<ProductDeclaration>> getAllPools() {
        return this.poolTest;
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
    public void mapPLDeclaration(Id id, PLDefinition plDefinition) throws PreviouslyDeclaredPLException {
        PLDefinition plDefinition1 = getPlDefinition(id);
        if (plDefinition1 == null) {
            plDefinitionHashMap.put(id, plDefinition);
        } else {
            throw new PreviouslyDeclaredPLException(id);
        }
    }

    @Override
    public void mapFNDeclaration(Id id, FNDefinition fnDefinition) throws PreviouslyDeclaredFNException, UndeclaredFNException {
            fnDefinitionHashMap.put(id, fnDefinition);
    }

    @Override
    public void mapFormDeclaration(Id id, FormDefinition formDefinition) throws PreviouslyDeclaredFormException, UndeclaredFormException {
            formDefinitionHashMap.put(id, formDefinition);

    }

    @Override
    public void mapProdDeclaration(Id id, ProductDefinition productDefinition) throws PreviouslyDeclaredProductException, UndeclaredProductException {
            productDefinitionHashMap.put(id, productDefinition);

    }
    @Override
    public PLDefinition getPlDefinition(Id id){
        PLDefinition result = null;
        result = this.plDefinitionHashMap.get(id);
        if (result == null) {
            return null;
        } else {
            return result;
        }
    }

    @Override
    public FNDefinition getFNDefinition(Id id) {
        FNDefinition result = null;
        result = this.fnDefinitionHashMap.get(id);
        if (result == null) {
            return null;
        } else {
            return result;
        }
    }

    @Override
    public FormDefinition getFormDefinition(Id id){
        FormDefinition result = null;
        result = this.formDefinitionHashMap.get(id);
        if (result == null) {
            return null;
        } else {
            return result;
        }
    }

    @Override
    public ProductDefinition getProdDefinition(Id id){
        ProductDefinition result = null;
        result = this.productDefinitionHashMap.get(id);
        if (result == null) {
            return null;
        } else {
            return result;
        }
    }

}
