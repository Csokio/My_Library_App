package userinput_validators;

import exceptions.IncorrectUserInputException;
import exceptions.MissingUserInputException;
import exceptions.UITooLongException;

public class UITooLongValidator extends AbstractValidator{

    @Override
    public void validate(String userInput) throws IncorrectUserInputException, MissingUserInputException {

        super.validate(userInput);

        int length = userInput.length();
        if(userInput.length() > 4){
            throw new UITooLongException("Maximum 4 digits allowed! Number of digits provided: " + length);
        }

    }
}
