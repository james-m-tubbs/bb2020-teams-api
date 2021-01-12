package ca.gkworkbench.bb2020api.exception;

public class AuthException extends Exception {
    public AuthException(String errorMessage) {
        super(errorMessage);
    }
}
