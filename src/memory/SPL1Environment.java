package memory;

import exceptions.*;
import declarations.Id;
import util.FNDefinition;
import util.FormDefinition;
import util.PLDefinition;
import util.ProductDefinition;

public interface SPL1Environment <T> extends Environment <T> {

    /**
     * Mapeia um Id as definicoes (PL, FN, FORM ou PROD)
     *
     * @throws exceptions quando a declaracao já foi feita
     */

    public void mapPLDeclaration (Id id, PLDefinition plDefinition) throws PreviouslyDeclaredPLException;
    public void mapFNDeclaration (Id id, FNDefinition fnDefinition) throws PreviouslyDeclaredFNException, UndeclaredFNException;
    public void mapFormDeclaration (Id id, FormDefinition formDefinition) throws PreviouslyDeclaredFormException, UndeclaredFormException;
    public void mapProdDeclaration (Id id, ProductDefinition productDefinition) throws PreviouslyDeclaredProductException, UndeclaredProductException;
    public PLDefinition getPlDefinition(Id id);
    public FNDefinition getFNDefinition(Id id);
    public FormDefinition getFormDefinition(Id id);
    public ProductDefinition getProdDefinition(Id id);

}
