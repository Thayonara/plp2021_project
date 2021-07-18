package memory;

import implementations.Id;
import util.*;

import java.util.HashMap;
import java.util.Stack;

public interface ExecutionEnvironment extends SPL1Environment <Object>{

    public void mapBefNode(Id plName, Id BefNodeName);
    public BefNode getBefNode(Id classe);
    public Stack<HashMap<Id, Object>> getStack();
    public HashMap<Id, PLDefinition> getMapPLDef();
    public HashMap<Id, FNDefinition> getMapFNDef();
    public HashMap<Id, FormDefinition> getMapFormDef();
    public HashMap<Id, ProductDefinition> getMapProductDef();


}
