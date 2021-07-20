package memory;

import implementations.GeneralType;
import implementations.Id;

public interface Environment <T> {
    public void increments();
    public void restore();
    public void map(Id idArg, T tipoId);
    public T get(Id id);
}
