package exceptions;

public class MissingUserInputException extends RuntimeException {

    public MissingUserInputException() {
        super();
    }

    public MissingUserInputException(String message) {
        super(message);
    }

    public MissingUserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingUserInputException(Throwable cause) {
        super(cause);
    }

}
