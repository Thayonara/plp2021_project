package memory;

import implementations.GeneralType;
import implementations.Id;
import implementations.IdTypeEnum;
import implementations.Types;
import util.BefNode;
import util.Lista;

public interface CompilationEnvironment extends SPL1Environment{

    public IdTypeEnum getTipo(Id id);
    public void mapBefNode(Id fnName, Id BefNodeName);
    public void mapBefChildren(Id fnName, Lista<Id> childrens);
    public Lista<Id> getChildrens(Id id);
    public BefNode getBefNode(Id befNode);
    public void mapFNType(Id fn, GeneralType feautureType);
    public GeneralType getFNType(Id fn);
    public Types getFormType(Id fn);



}
