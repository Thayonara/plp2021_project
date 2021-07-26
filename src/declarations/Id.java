package declarations;

import formulas.Formula;
import memory.CompilationEnvironment;
import types.GeneralType;

import java.util.Objects;

public class Id implements Formula {
    private String idName;

    public Id(String strName) {
        this.idName = strName;
    }

    public String getIdName() {
        return idName;
    }

    public String toString() {
        return this.getIdName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Id)) return false;
        Id id = (Id) o;
        return Objects.equals(idName, id.idName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idName);
    }

    //o "avaliar" em nosso contexto é checar se as formulas são satisfeitas na geracao de um produto
    @Override
    public boolean evaluate(CompilationEnvironment compilationEnvironment, ProductDeclaration productDeclaration) {
        return productDeclaration.isPresent(productDeclaration.getFeaturesSelected(), this);
    }

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        boolean rt = true;
        compilationEnvironment.get(this);
        return rt;
    }

    @Override
    public GeneralType getType(CompilationEnvironment compilationEnvironment) {
        GeneralType generalType =  (GeneralType) compilationEnvironment.get(this);
        return generalType;

    }

    public Id clone() {
        return this;
    }

}