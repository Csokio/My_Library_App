package userinput_validators;

import exceptions.IncorrectUserInputException;
import exceptions.MissingUserInputException;
import exceptions.UITooShortException;

public class UITooShortValidator extends AbstractValidator{


    @Override
    public void validate(String userInput) throws IncorrectUserInputException, MissingUserInputException {

        super.validate(userInput);


        int length = userInput.length();
        if(userInput.length() < 4){
            throw new UITooShortException("Input length is: " + length + " Only 4 digits numbers are allowed.");
        }
    }

}
