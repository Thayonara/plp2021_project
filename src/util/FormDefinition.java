package util;

import implementations.Formula;
import implementations.Id;

public class FormDefinition {
    private Id formName;
    private Formula formula;

    public FormDefinition(Id formName, Formula formula){
        this.formName = formName;
        this.formula = formula;
    }

    public Id getFormName() {
        return formName;
    }

    public Formula getFormula() {
        return formula;
    }
}
