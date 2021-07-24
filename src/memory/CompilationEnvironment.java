package memory;

import exceptions.UndeclaredPLException;
import implementations.GeneralType;
import implementations.Id;
import util.BefNode;
import util.FNDefinition;
import util.Lista;
import util.PLDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public interface CompilationEnvironment extends SPL1Environment<GeneralType> {

    public void mapBefNode(Id fnName, Id BefNodeName) throws UndeclaredPLException;
    public BefNode getBefNode(Id befNode);
    public List<Id> getChildrens(Id befId, Id idBro);
    public HashMap<Id, PLDefinition> getPLDefinitions();
    public HashMap<Id, FNDefinition> getFNDefinitions();


    }
