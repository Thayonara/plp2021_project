package memory;

import exceptions.UndeclaredPLException;
import implementations.Id;
import implementations.ProductDeclarationList;
import util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public interface ExecutionEnvironment extends SPL1Environment <Object>{

    public void mapBefNode(Id plName, Id BefNodeName) throws UndeclaredPLException;
    public void mapPoolTest(Id idPl, List<ProductDefinition> productDeclarationList);
    public List<ProductDefinition> getPoolTesting(Id idPL);
    public BefNode getBefNode(Id classe);
    public Stack<HashMap<Id, Object>> getStack();
    public List<Id> getChildrens(Id befId, Id idBro);
    public HashMap<Id, PLDefinition> getPLDefinitions();
    public HashMap<Id, PLDefinition> getMapPLDef();
    public HashMap<Id, FNDefinition> getMapFNDef();
    public HashMap<Id, FormDefinition> getMapFormDef();
    public HashMap<Id, ProductDefinition> getMapProductDef();


}
