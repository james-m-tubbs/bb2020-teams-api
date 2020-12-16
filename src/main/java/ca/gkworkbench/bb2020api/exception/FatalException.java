package ca.gkworkbench.bb2020api.exception;

public class FatalException extends Exception {
    public FatalException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
