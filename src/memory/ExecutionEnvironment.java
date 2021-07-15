package memory;

import implementations.Id;
import util.*;

import java.util.HashMap;

public interface ExecutionEnvironment extends SPL1Environment{

    public void mapBefNode(Id plName, Id BefNodeName);
    public BefNode getBefNode(Id classe);
    public HashMap<Id, PLDefinition> getMapPLDef();
    public HashMap<Id, FNDefinition> getMapFNDef();
    public HashMap<Id, FormDefinition> getMapFormDef();
    public HashMap<Id, ProductDefinition> getMapProductDef();


}
