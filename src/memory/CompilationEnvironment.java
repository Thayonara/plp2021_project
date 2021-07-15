package memory;

import implementations.Id;
import implementations.IdType;
import implementations.Types;
import util.BefNode;

public interface CompilationEnvironment extends SPL1Environment{

    public IdType getTipo(Id id);
    public void mapBefNode(Id plName, Id BefNodeName);
    public BefNode getBefNode(Id classe);
    public void mapFNType(Id fn, Types feautureType);
    public Types getFNType(Id fn);

}
