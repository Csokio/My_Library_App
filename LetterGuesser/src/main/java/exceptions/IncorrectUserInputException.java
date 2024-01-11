package exceptions;

public class IncorrectUserInputException extends Exception{

    public IncorrectUserInputException() {
        super();
    }

    public IncorrectUserInputException(String message) {
        super(message);
    }

    public IncorrectUserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectUserInputException(Throwable cause) {
        super(cause);
    }
}
