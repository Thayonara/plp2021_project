package exceptions;

import declarations.Id;

public class EmptyCompilationEnvironmentException extends Exception {
    public EmptyCompilationEnvironmentException() {

        super("Ambiente sem declarações");
    }
}
