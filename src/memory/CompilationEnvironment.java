package memory;

import implementations.GeneralType;
import implementations.Id;
import util.BefNode;
import util.Lista;

import java.util.List;

public interface CompilationEnvironment extends SPL1Environment<GeneralType> {

    public void mapBefNode(Id fnName, Id BefNodeName);
    public BefNode getBefNode(Id befNode);
    public List<Id> getChildrens(Id befId, Id idBro);


    }
