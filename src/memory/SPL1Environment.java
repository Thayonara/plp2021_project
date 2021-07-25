package memory;

import exceptions.*;
import declarations.Id;
import util.FNDefinition;
import util.FormDefinition;
import util.PLDefinition;
import util.ProductDefinition;

public interface SPL1Environment <T> extends Environment <T> {

    public void mapPLDeclaration (Id id, PLDefinition plDefinition) throws PreviouslyDeclaredPLException, UndeclaredPLException;
    public void mapFNDeclaration (Id id, FNDefinition fnDefinition) throws PreviouslyDeclaredFNException, UndeclaredFNException;
    public void mapFormDeclaration (Id id, FormDefinition formDefinition) throws PreviouslyDeclaredFormException, UndeclaredFormException;
    public void mapProdDeclaration (Id id, ProductDefinition productDefinition) throws PreviouslyDeclaredProductException, UndeclaredProductException;

    public PLDefinition getPlDefinition(Id id) throws UndeclaredPLException;
    public FNDefinition getFNDefinition(Id id) throws UndeclaredFNException;
    public FormDefinition getFormDefinition(Id id) throws UndeclaredFormException;
    public ProductDefinition getProdDefinition(Id id) throws UndeclaredProductException;

}
