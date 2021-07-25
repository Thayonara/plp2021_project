package types;

import declarations.Id;
import memory.CompilationEnvironment;

public interface GeneralType {
    public Id getTipo();
    public boolean equals(Object obj);
    public boolean isValid(CompilationEnvironment compilationEnvironment);

}
