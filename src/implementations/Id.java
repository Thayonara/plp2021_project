package implementations;

public class Id implements Formula{
    private String idName;
    private IdType idType;

    public Id(String strName, IdType idType) {
        this.idName = strName;
        this.idType = idType;
    }

    public String getIdName() {
        return idName;
    }

    public IdType getIdType() {
        return idType;
    }
}