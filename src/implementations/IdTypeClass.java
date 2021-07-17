package implementations;

import memory.CompilationEnvironment;

import java.util.Objects;

public class IdTypeClass implements GeneralType{
    protected Enum type;

    public static final Id FN_TYPE = new Id("fn");
    public static final Id FORM_TYPE = new Id("formula");
    public static final Id PROD_TYPE = new Id("product");
    public static final Id PL_TYPE = new Id("pl");


    public IdTypeClass(Enum type) {
        this.type = type;
    }

    @Override
    public Id getTipo() {
        Id rt = new Id("undefined");
        switch(type.ordinal()) {
            case(0):
                rt = FN_TYPE;
                break;
            case(1):
                rt = FORM_TYPE;
                break;
            case(3):
                rt = PROD_TYPE;
                break;
            case(2):
                rt = PL_TYPE;
                break;
        }
        return rt;
    }

    public boolean isFN() {
        return this.type == IdTypeEnum.FEATURENAME;
    }

    public boolean isForm() {
        return this.type == IdTypeEnum.FORM;
    }

    public boolean isProd() {
        return this.type == IdTypeEnum.PRODUCT;
    }

    public boolean isPL() {
        return this.type == IdTypeEnum.PL;
    }

    @Override
    public boolean isValid(CompilationEnvironment compilationEnvironment) {
        return this.type == IdTypeEnum.FEATURENAME ||
                this.type == IdTypeEnum.FORM ||
                this.type == IdTypeEnum.PRODUCT ||
                this.type == IdTypeEnum.PL;
    }

    public boolean isValid() {
        return this.type == IdTypeEnum.FEATURENAME ||
                this.type == IdTypeEnum.FORM ||
                this.type == IdTypeEnum.PRODUCT ||
                this.type == IdTypeEnum.PL;
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
                rt = "fn";
                break;
            case(1):
                rt = "formula";
                break;
            case(2):
                rt = "pl";
                break;
            case(3):
                rt = "product";
                break;
        }
        return rt;
    }
}
