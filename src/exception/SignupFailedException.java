package exception;

public class SignupFailedException extends RuntimeException {
    public SignupFailedException(String message) {
        super(message);
    }
}
