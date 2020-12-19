package ca.gkworkbench.bb2020api.exception;

public class FatalException extends Exception {
    public FatalException(String errorMessage) {
        super(errorMessage);
    }
}
