package exceptions;

public class UITooShortException extends IncorrectUserInputException{

    public UITooShortException() {
        super();
    }

    public UITooShortException(String message) {
        super(message);
    }

    public UITooShortException(String message, Throwable cause) {
        super(message, cause);
    }

    public UITooShortException(Throwable cause) {
        super(cause);
    }
}
