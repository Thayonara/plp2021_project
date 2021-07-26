package memory;

import exceptions.UndeclaredPLException;
import types.GeneralType;
import declarations.Id;
import util.*;

import java.util.HashMap;
import java.util.List;

public interface CompilationEnvironment extends SPL1Environment<GeneralType> {

    public void mapBefNode(Id fnName, Id BefNodeName) throws UndeclaredPLException;
    public List<Id> getChildrens(Id befId, Id idBro);
    public HashMap<Id, PLDefinition> getPLDefinitions();
    public HashMap<Id, FNDefinition> getFNDefinitions();
    public HashMap<Id, FormDefinition> getFormDefinitions();


    }
