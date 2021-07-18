package memory;

import implementations.Id;
import util.FNDefinition;
import util.FormDefinition;
import util.PLDefinition;
import util.ProductDefinition;

public interface SPL1Environment <T> extends Environment <T> {

    public void mapPLDeclaration (Id id, PLDefinition plDefinition);
    public void mapFNDeclaration (Id id, FNDefinition fnDefinition);
    public void mapFormDeclaration (Id id, FormDefinition formDefinition);
    public void mapProdDeclaration (Id id, ProductDefinition productDefinition);

    public PLDefinition getPlDefinition(Id id);
    public FNDefinition getFNDefinition(Id id);
    public FormDefinition getFormDefinition(Id id);
    public ProductDefinition getProdDefinition(Id id);

}
