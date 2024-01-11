package exceptions;

public class InvalidCharException extends IncorrectUserInputException{

    public InvalidCharException() {
        super();
    }

    public InvalidCharException(String message) {
        super(message);
    }

    public InvalidCharException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCharException(Throwable cause) {
        super(cause);
    }
}
