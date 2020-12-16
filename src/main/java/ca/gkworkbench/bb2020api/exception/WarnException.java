package ca.gkworkbench.bb2020api.exception;

public class WarnException extends Exception {
    public WarnException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
