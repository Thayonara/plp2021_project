package exceptions;

public class EmptyExecutionEnvironmentException extends Exception {
    public EmptyExecutionEnvironmentException() {

        super("Ambiente vazio");
    }
}
