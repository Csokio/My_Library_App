package exceptions;

public class UITooLongException extends IncorrectUserInputException{

    public UITooLongException() {
        super();
    }

    public UITooLongException(String message) {
        super(message);
    }

    public UITooLongException(String message, Throwable cause) {
        super(message, cause);
    }

    public UITooLongException(Throwable cause) {
        super(cause);
    }
}
