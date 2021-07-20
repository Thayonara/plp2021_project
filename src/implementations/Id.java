package implementations;

import memory.CompilationEnvironment;

import java.util.Objects;

public class Id implements Formula{
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

    @Override
    public boolean typeCheck(CompilationEnvironment compilationEnvironment) {
        boolean rt = true;
        compilationEnvironment.get(this);
        return rt;
    }

    @Override
    public GeneralType getType(CompilationEnvironment compilationEnvironment) {
        return (GeneralType) compilationEnvironment.get(this);
    }

    public Id clone() {
        return this;
    }

}