package memory;

import implementations.Id;
import util.PLDefinition;

public interface SPL1Environment <T> {

    public void mapPLDeclaration (Id id, PLDefinition plDefinition);

    public PLDefinition getPlDefinition(Id id);


}
