package implementations;

import memory.CompilationEnvironment;

import java.util.Objects;

public class FNTypeClass implements GeneralType{
    protected Enum type;

    public static final Id MANDATORY_TYPE = new Id("mandatory");
    public static final Id OPTIONAL_TYPE = new Id("optional");
    public static final Id ROOT_TYPE = new Id("root");
    public static final Id ALTERNATIVE_TYPE = new Id("alternative");
    public static final Id OR_TYPE = new Id("or");


    public FNTypeClass(Enum type) {
        this.type = type;
    }

    @Override
    public Id getTipo() {
        Id rt = new Id("undefined");
        switch(type.ordinal()) {
            case(0):
                rt = ROOT_TYPE;
                break;
            case(1):
                rt = MANDATORY_TYPE;
                break;
            case(2):
                rt = OR_TYPE;
                break;
            case(3):
                rt = ALTERNATIVE_TYPE;
                break;
            case(4):
                rt = OPTIONAL_TYPE;
                break;
        }
        return rt;
    }

    public boolean isMandatory() {
        return this.type == Types.MANDATORY;
    }

    public boolean isOptional() {
        return this.type == Types.OPTIONAL;
    }

    public boolean isRoot() {
        return this.type == Types.ROOT;
    }

    public boolean isAlternative() {
        return this.type == Types.ALTERNATIVE;
    }

    public boolean isOr() {
        return this.type == Types.OR;
    }

    @Override
    public boolean isValid(CompilationEnvironment compilationEnvironment) {
        return this.type == Types.MANDATORY ||
                this.type == Types.OPTIONAL ||
                this.type == Types.ROOT ||
                this.type == Types.OR ||
                this.type == Types.ALTERNATIVE;
    }

    public boolean isValid() {
        return this.type == Types.MANDATORY ||
                this.type == Types.OPTIONAL ||
                this.type == Types.ROOT ||
                this.type == Types.OR ||
                this.type == Types.ALTERNATIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdTypeClass)) return false;
        IdTypeClass that = (IdTypeClass) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public String toString() {
        String rt = "undefined";
        switch(type.ordinal()) {
            case(0):
                rt = "root";
                break;
            case(1):
                rt = "mandatory";
                break;
            case(2):
                rt = "or";
                break;
            case(3):
                rt = "alternative";
                break;
            case(4):
                rt = "optional";
                break;
        }
        return rt;
    }
}
