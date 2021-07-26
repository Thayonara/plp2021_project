package memory;

import exceptions.UndeclaredPLException;
import declarations.Id;
import declarations.ProductDeclaration;
import util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public interface ExecutionEnvironment extends SPL1Environment <Object>{

    public void mapBefNode(Id plName, Id BefNodeName) throws UndeclaredPLException;
    public void mapPoolTest(String idPl, List<ProductDeclaration> productDeclarationList);
    public List<ProductDeclaration> getPoolTesting(Id idPL);
    public HashMap<String, List<ProductDeclaration>> getAllPools();
    public List<Id> getChildrens(Id befId, Id idBro);


}
