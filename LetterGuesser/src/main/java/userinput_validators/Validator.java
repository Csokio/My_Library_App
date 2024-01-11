package userinput_validators;

import exceptions.IncorrectUserInputException;
import exceptions.MissingUserInputException;

public interface Validator {

    void validate(String userInput) throws IncorrectUserInputException, MissingUserInputException;

}
